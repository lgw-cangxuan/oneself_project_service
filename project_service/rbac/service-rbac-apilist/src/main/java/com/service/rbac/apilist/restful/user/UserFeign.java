package com.service.rbac.apilist.restful.user;

import com.service.base.apilist.RequestResult;
import com.service.rbac.apilist.form.UserForm;
import com.service.rbac.apilist.model.UserModel;
import com.service.rbac.apilist.restful.ZoneConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description: user feign
 * @Author: lgw
 * @Date: 2020/06/16
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface UserFeign {
    /**
     * query user info list
     * @return
     */
    @RequestMapping(value = "/user/findAllUser", method = RequestMethod.POST)
    RequestResult<List<UserModel>> findAllUser();

    /**
     * insert user info
     * @param form user info
     * @return
     */
    @RequestMapping(value = "/user/insertUser", method = RequestMethod.POST)
    RequestResult<Boolean> insertUser(UserForm form);

    /**
     * update user info
     * @param form user info
     * @return
     */
    @RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
    RequestResult<Boolean> updateUser(UserForm form);
}
