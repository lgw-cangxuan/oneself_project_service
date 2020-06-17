package com.web.remote;

import com.service.base.apilist.RequestResult;
import com.service.rbac.apilist.model.UserModel;
import com.service.rbac.apilist.restful.user.UserFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户remote
 *
 * @author lgw
 * @date 2020/06/16
 */

@Service
public class UserRemote {

    @Resource
    private UserFeign agentUserFeign;

    public RequestResult<List<UserModel>> findAllUser(){
        return agentUserFeign.findAllUser();
    }

}
