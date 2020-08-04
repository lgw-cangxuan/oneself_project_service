package com.web.controller.message;

import com.service.car.apilist.model.UserMessageModel;
import com.web.controller.BaseController;
import com.web.remote.car.UserMessageRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: user controller
 * @Author: lgw
 * @Date: 2020/06/16
 */
@RestController
@RequestMapping(value = "/message/message",produces = {"application/json;charset=UTF-8"})
@Api(value = "用户相关", description = "用户相关接口", tags = "用户相关")
public class MessageController extends BaseController {
    @Resource
    private UserMessageRemote messageRemote;

    @GetMapping("/findAllUserMessage")
    @ApiOperation(value = "查询消息记录")
    @ApiResponses({
            @ApiResponse(message = "用户信息",code = 1,response = UserMessageModel.class)
    })
    public String findAllUserMessage() {
        return returnSuccessInfo(messageRemote.findAllUserMessage().pickBody());
    }
}

