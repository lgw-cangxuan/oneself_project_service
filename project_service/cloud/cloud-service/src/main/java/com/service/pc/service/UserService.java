package com.service.pc.service;

import com.service.apilist.model.UserModel;
import com.service.pc.dao.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户
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
}
