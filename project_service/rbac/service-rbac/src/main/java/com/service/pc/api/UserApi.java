package com.service.pc.api;

import com.service.base.apilist.RequestResult;
import com.service.pc.service.UserService;
import com.service.rbac.apilist.model.UserModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserApi{
    @Resource
    private UserService userService;

    @PostMapping(value = "/findAllUser")
    public RequestResult<List<UserModel>> findAllUser() {
        return new RequestResult<>(userService.findAllUser());
    }

}