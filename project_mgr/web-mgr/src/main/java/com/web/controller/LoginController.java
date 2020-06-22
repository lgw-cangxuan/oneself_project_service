package com.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: login controller
 * @Author: lgw
 * @Date: 2020/06/16
 */
@RestController
@RequestMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
@Api(value = "系统登录相关", description = "系统登录相关接口", tags = "系统登录相关")
public class LoginController extends BaseController {
    @GetMapping("/login")
    @ApiOperation(value = "系统登录")
    public String login(String userName, String password) {
        return "";
    }
}

