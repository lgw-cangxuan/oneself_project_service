package com.web.controller.rbac;

import com.alibaba.fastjson.JSON;
import com.service.base.apilist.cache.RedisCache;
import com.service.base.apilist.cache.cachekey.CacheKeyType;
import com.service.rbac.apilist.form.UserForm;
import com.service.rbac.apilist.model.UserModel;
import com.web.controller.BaseController;
import com.web.remote.UserRemote;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: user controller
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

    @PostMapping("insertUser")
    public String insertUser(@RequestBody UserForm form){
        return returnSuccessInfo(userRemote.insertUser(form).pickBody());
    }

    @PostMapping("updateUser")
    public String updateUser(@RequestBody UserForm form){
        return returnSuccessInfo(userRemote.updateUser(form));
    }
}

