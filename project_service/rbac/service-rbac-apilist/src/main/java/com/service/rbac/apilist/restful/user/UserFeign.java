package com.service.rbac.apilist.restful.user;

import com.service.base.apilist.RequestResult;
import com.service.rbac.apilist.model.UserModel;
import com.service.rbac.apilist.restful.ZoneConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Description: 用户feign
 * @Author: lgw
 * @Date: 2020/06/16
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface UserFeign {
    @RequestMapping(value = "/user/findAllUser", method = RequestMethod.POST)
    RequestResult<List<UserModel>> findAllUser();
}
