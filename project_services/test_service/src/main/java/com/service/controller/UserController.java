package com.service.controller;

import com.service.service.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2019/8/7
 */
@RestController
@RequestMapping(value = "/web/mgr/test", produces = {"application/json;charset=UTF-8"})
public class UserController {
    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return userService.queryUser().get(0).toString();
    }
}
