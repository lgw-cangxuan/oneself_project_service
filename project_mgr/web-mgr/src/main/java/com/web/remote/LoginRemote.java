package com.web.remote;

import com.service.base.apilist.RequestResult;
import com.service.base.apilist.cache.RedisCache;
import com.service.base.apilist.cache.cachekey.CacheKeyType;
import com.service.base.apilist.enums.JsonCommonCodeEnum;
import com.service.base.apilist.encryption.MD5_Encoding;
import com.service.rbac.apilist.form.PhoneAndPasswordForm;
import com.service.rbac.apilist.form.UserForm;
import com.service.rbac.apilist.model.LoginUserInfoModel;
import com.service.rbac.apilist.model.UserModel;
import com.service.rbac.apilist.restful.user.UserFeign;
import com.web.exception.GlobalRequestException;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: login
 * @Author: lgw
 * @Date: 2020/06/23
 */
@Service
public class LoginRemote {
    private Mapper mapper = new DozerBeanMapper();

    @Resource
    private UserFeign userFeign;

    @Resource
    private RedisCache redisCache;

    public RequestResult<LoginUserInfoModel> login(PhoneAndPasswordForm form){
        UserModel userModel = userFeign.queryUserByNameAndPassword(form).pickBody();
        if(userModel != null){
            LoginUserInfoModel userInfoModel = mapper.map(userModel, LoginUserInfoModel.class);
            String phone = userInfoModel.getPhone();
            //把手机号用md5随机加盐加密组成token
            String token = phone+"_"+ MD5_Encoding.generateRandomSalt(phone);
            userInfoModel.setToken(token);
            //把token保存到redis
            redisCache.put(CacheKeyType.LOGIN_USER_TOKEN,phone,token);
            return new RequestResult<>(userInfoModel);
        }else {
            throw new GlobalRequestException("用户名与密码不匹配！", JsonCommonCodeEnum.C0001);
        }
    }

    public RequestResult<Boolean> forget(PhoneAndPasswordForm form){
        UserModel userModel = userFeign.queryUserByNameAndPassword(form).pickBody();
        if(userModel != null){
            UserForm userForm = mapper.map(userModel, UserForm.class);
            userForm.setPassword(form.getNewPassword());
            RequestResult<Boolean> result = userFeign.updateUser(userForm);
            redisCache.remove(CacheKeyType.LOGIN_USER_TOKEN,userForm.getPhone());
            return result;
        }else {
            throw new GlobalRequestException("用户名与密码不匹配！", JsonCommonCodeEnum.C0001);
        }
    }
}
