package com.web.remote;

import com.service.apilist.restful.UserFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserRemote {

    @Resource
    private UserFeign agentUserFeign;

    public String findAllUser(){
        return agentUserFeign.findAllUser();
    }

}
