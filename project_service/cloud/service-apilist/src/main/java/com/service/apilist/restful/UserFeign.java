package com.service.apilist.restful;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * create by zxl on 2019/7/23
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface UserFeign {
    @RequestMapping(value = "/user/findAllUser", method = RequestMethod.POST)
    String findAllUser();
}
