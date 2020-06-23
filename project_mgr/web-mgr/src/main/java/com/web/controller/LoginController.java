package com.web.controller;

import com.service.rbac.apilist.form.PhoneAndPasswordForm;
import com.web.remote.LoginRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: login controller
 * @Author: lgw
 * @Date: 2020/06/16
 */
@RestController
@RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
@Api(value = "系统登录相关", description = "系统登录相关接口", tags = "系统登录相关")
public class LoginController extends BaseController {
    @Resource
    private LoginRemote loginRemote;

    @PostMapping("/login")
    @ApiOperation(value = "系统登录")
    public String login(@RequestBody PhoneAndPasswordForm form) {
        return returnAppSuccessInfo(loginRemote.login(form).pickBody());
    }
}

