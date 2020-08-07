package com.web.controller.websocket;

import com.alibaba.fastjson.JSONObject;
import com.service.base.apilist.enums.JsonCommonCodeEnum;
import com.service.car.apilist.form.UserMessageForm;
import com.service.rbac.apilist.model.MsgVOModel;
import com.service.rbac.apilist.model.UserModel;
import com.web.exception.GlobalRequestException;
import com.web.remote.car.UserMessageRemote;
import com.web.remote.rbac.UserRemote;
import com.web.util.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: websocket 处理类Controller
 * @Author: lgw
 * @Date: 2020/07/22
 */
@Slf4j
@Component
@ServerEndpoint("/groupChat/{sid}/{userId}")
public class WebSocketServerController {
    /**
     * 房间号 -> 组成员信息
     */
    private static ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();
    /**
     * 房间号 -> 在线人数
     */
    private static ConcurrentHashMap<String, Set<String>> onlineUserMap = new ConcurrentHashMap<>();

    /**
     * 收到消息调用的方法，群成员发送消息
     *
     * @param sid:房间号
     * @param userId：用户id
     * @param message：发送消息
     */
    @OnMessage
    public void onMessage(@PathParam("sid") String sid, @PathParam("userId") String userId, @PathParam("messageType") String messageType, String message) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        Set<String> onlineUserList = onlineUserMap.get(sid);
        // json字符串转对象
        MsgVOModel msg = JSONObject.parseObject(message, MsgVOModel.class);
        // 聊天中的记录被保存
        if (StringUtils.isEmpty(messageType)) {
            UserMessageForm form = new UserMessageForm();
            form.setUserId(userId);
            form.setGroupId(sid);
            form.setMessageContent(msg.getMessageContent());
            ApplicationContextUtil.getApplicationContext().getBean(UserMessageRemote.class).insertUserMessage(form);
        }
        // 先一个群组内的成员发送消息
        sessionList.forEach(item -> {
            try {
                msg.setCount(onlineUserList.size());
                // json对象转字符串
                String text = JSONObject.toJSONString(msg);
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 建立连接调用的方法，群成员加入
     *
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid, @PathParam("userId") String userId) {
        List<Session> sessionList = groupMemberInfoMap.computeIfAbsent(sid, k -> new ArrayList<>());
        Set<String> onlineUserList = onlineUserMap.computeIfAbsent(sid, k -> new HashSet<>());
        onlineUserList.add(userId);
        sessionList.add(session);
        // 发送上线通知
        sendInfo(sid, userId, onlineUserList.size(), "hello!我来了~", "ON_OPEN");
    }


    public void sendInfo(String sid, String userId, Integer onlineSum, String info, String messageType) {
        // 获取该连接用户信息
        UserModel currentUser = ApplicationContextUtil.getApplicationContext().getBean(UserRemote.class).queryUserById(userId).pickBody();
        if (currentUser == null) {
            throw new GlobalRequestException("请登录！", JsonCommonCodeEnum.C0001);
        }
        // 发送通知
        MsgVOModel msg = new MsgVOModel();
        msg.setCount(onlineSum);
        msg.setUserId(userId);
        msg.setAvatarUrl(currentUser.getAvatarUrl());
        msg.setNickname(currentUser.getNickname());
        msg.setMessageContent(info);
        // json对象转字符串
        String text = JSONObject.toJSONString(msg);
        onMessage(sid, userId, messageType, text);
    }

    /**
     * 关闭连接调用的方法，群成员退出
     *
     * @param session
     * @param sid
     */
    @OnClose
    public void onClose(Session session, @PathParam("sid") String sid, @PathParam("userId") String userId) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        sessionList.remove(session);
        Set<String> onlineUserList = onlineUserMap.get(sid);
        onlineUserList.remove(userId);
        // 发送离线通知
        sendInfo(sid, userId, onlineUserList.size(), "拜拜!", "ON_CLOSE");
    }

    /**
     * 传输消息错误调用的方法
     *
     * @param error
     */
    @OnError
    public void onError(Throwable error) {
        log.info("Connection error");
    }
}
