package com.service.pc.service;

import com.service.base.apilist.idutil.SnowflakesIdUtil;
import com.service.car.apilist.form.UserMessageForm;
import com.service.car.apilist.model.UserMessageModel;
import com.service.pc.dao.UserMessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 消息
 * @Author: lgw
 * @Date: 2020/07/03
 */
@Service
public class UserMessageService {
    @Resource
    private UserMessageMapper userMessageMapper;

    public List<UserMessageModel> findAllUserMessage(){
        return userMessageMapper.findAllUserMessage();
    }

    public boolean insertUserMessage(UserMessageForm form){
        try{
            form.setId(SnowflakesIdUtil.getInstance().nextIdAsString());
            userMessageMapper.insertUserMessage(form);
            return true;
        }catch (RuntimeException ex){
            throw new RuntimeException("消息保存失败！");
        }
    }
}
