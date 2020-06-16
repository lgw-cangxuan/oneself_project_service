package com.service.pc.api;
import com.service.pc.entity.UserModel;
import com.service.pc.service.UserService;
import com.service.pc.util.RequestResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserApi{
    @Resource
    private UserService userService;

    @PostMapping(value = "/user/findAllUser")
    public RequestResult<List<UserModel>> findAllUser() {
        return new RequestResult<>(userService.findAllUser());
    }

}
