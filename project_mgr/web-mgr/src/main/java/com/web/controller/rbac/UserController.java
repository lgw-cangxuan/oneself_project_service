package com.web.controller.rbac;

import com.alibaba.fastjson.JSON;
import com.service.base.apilist.cache.RedisCache;
import com.service.base.apilist.cache.cachekey.CacheKeyType;
import com.service.rbac.apilist.form.UserForm;
import com.service.rbac.apilist.model.UserModel;
import com.web.controller.BaseController;
import com.web.remote.UserRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "用户相关", description = "用户相关接口", tags = "用户相关")
public class UserController extends BaseController {
    @Resource
    private UserRemote userRemote;

    @Resource
    private RedisCache redisCache;

    @GetMapping("/findAllUser")
    @ApiOperation(value = "查询用户列表")
    @ApiResponses({
            @ApiResponse(message = "用户信息",code = 1,response = UserModel.class)
    })
    public String findAllUser() {
        List<UserModel> list = userRemote.findAllUser().pickBody();
        redisCache.put(CacheKeyType.USER_INFO,"list",JSON.toJSONString(list));
        return returnSuccessInfo(list);
    }

    @PostMapping("insertUser")
    @ApiOperation(value = "保存用户信息")
    @ApiResponses({
            @ApiResponse(message = "用户信息",code = 1,response = Boolean.class)
    })
    public String insertUser(@RequestBody UserForm form){
        return returnSuccessInfo(userRemote.insertUser(form).pickBody());
    }

    @PostMapping("updateUser")
    @ApiOperation(value = "修改用户信息")
    @ApiResponses({
            @ApiResponse(message = "用户信息",code = 1,response = Boolean.class)
    })
    public String updateUser(@RequestBody UserForm form){
        return returnSuccessInfo(userRemote.updateUser(form));
    }
}

