package com.service.api;
import com.service.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserApi{
    @Resource
    private UserService userService;

    @PostMapping(value = "/user/findAllUser")
    public String findAllUser() {
        return userService.findAllUser();
    }

}
