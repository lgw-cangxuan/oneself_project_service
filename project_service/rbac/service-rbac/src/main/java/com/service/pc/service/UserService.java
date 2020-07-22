package com.service.pc.service;

import com.service.base.apilist.idutil.SnowflakesIdUtil;
import com.service.base.apilist.encryption.MD5_Encoding;
import com.service.pc.dao.UserMapper;
import com.service.rbac.apilist.form.PhoneAndPasswordForm;
import com.service.rbac.apilist.form.UserForm;
import com.service.rbac.apilist.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: user service
 * @Author: lgw
 * @Date: 2020/06/16
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public List<UserModel> findAllUser(){
        List<UserModel> list = userMapper.findAllUser();
        return list;
    }

    public UserModel queryUserByNameAndPassword(PhoneAndPasswordForm form){
        form.setPassword(MD5_Encoding.generate(form.getPassword()));
        UserModel userModel = userMapper.queryUserByNameAndPassword(form);
        return userModel;
    }

    public UserModel queryUserById(String id){
        return userMapper.queryUserById(id);
    }

    public Boolean insertUser(UserForm form){
        try{
            form.setId(SnowflakesIdUtil.getInstance().nextIdAsString());
            form.setPassword(MD5_Encoding.generate(form.getPassword()));
            userMapper.insertUser(form);
            return true;
        }catch (RuntimeException ex){
            throw new RuntimeException("用户信息保存失败！");
        }
    }

    public boolean updateUser(UserForm form){
        try{
            form.setPassword(MD5_Encoding.generate(form.getPassword()));
            userMapper.updateUser(form);
            return true;
        }catch (RuntimeException ex){
            throw new RuntimeException("用户信息修改失败！");
        }
    }
}
