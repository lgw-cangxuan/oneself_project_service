package com.web.controller;

import com.web.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2020/06/16
 */
@RestController
@RequestMapping(value = "/user",produces = {"application/json;charset=UTF-8"})
public class UserController {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAllUser")
    public String findAllUser() {
        return userFeign.findAllUser();
    }
}

