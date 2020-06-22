package com.web.controller;

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
public class LoginController extends BaseController {
    @GetMapping("/login")
    public String login(String userName, String password) {
        return "";
    }
}

