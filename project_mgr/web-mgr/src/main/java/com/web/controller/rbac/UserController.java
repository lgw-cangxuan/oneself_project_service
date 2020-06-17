package com.web.controller.rbac;

import com.web.controller.BaseController;
import com.web.remote.UserRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户操作
 * @Author: lgw
 * @Date: 2020/06/16
 */
@RestController
@RequestMapping(value = "/rbac/user",produces = {"application/json;charset=UTF-8"})
public class UserController extends BaseController {
    @Autowired
    private UserRemote userRemote;

    @GetMapping("/findAllUser")
    public String findAllUser() {
        return returnAppSuccessInfo(userRemote.findAllUser().pickBody());
    }
}

