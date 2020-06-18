package com.web.controller.rbac;

import com.alibaba.fastjson.JSON;
import com.service.base.apilist.cache.RedisCache;
import com.service.base.apilist.cache.cachekey.CacheKeyType;
import com.service.rbac.apilist.model.UserModel;
import com.web.controller.BaseController;
import com.web.remote.UserRemote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户操作
 * @Author: lgw
 * @Date: 2020/06/16
 */
@RestController
@RequestMapping(value = "/rbac/user",produces = {"application/json;charset=UTF-8"})
public class UserController extends BaseController {
    @Resource
    private UserRemote userRemote;

    @Resource
    private RedisCache redisCache;

    @GetMapping("/findAllUser")
    public String findAllUser() {
        List<UserModel> list = userRemote.findAllUser().pickBody();
        redisCache.put(CacheKeyType.USER_INFO,"list",JSON.toJSONString(list));
        return returnSuccessInfo(list);
    }
}

