package com.service.api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi{


    @PostMapping(value = "/user/test")
    public String test() {
        return "aaaaaa";
    }

}
