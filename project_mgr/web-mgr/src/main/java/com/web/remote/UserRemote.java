package com.web.remote;

import com.service.base.apilist.RequestResult;
import com.service.rbac.apilist.form.UserForm;
import com.service.rbac.apilist.model.UserModel;
import com.service.rbac.apilist.restful.user.UserFeign;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: user remote
 *
 * @author lgw
 * @date 2020/06/16
 */

@Service
public class UserRemote {
    @Resource
    private UserFeign userFeign;

    public RequestResult<List<UserModel>> findAllUser(){
        return userFeign.findAllUser();
    }

    public RequestResult<Boolean> insertUser(UserForm form){
        return userFeign.insertUser(form);
    }

    public RequestResult<Boolean> updateUser(UserForm form){
        return userFeign.updateUser(form);
    }
}
