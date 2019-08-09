package com.service.service.service;

import com.service.service.dao.UserMapper;
import com.service.service.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2019/8/7
 */
@Service
public class UserService {
    @Resource
    private UserMapper testMapper;

    public List<UserModel> queryUser(){
        List<UserModel> user=testMapper.queryUser();
        System.out.println("123455");
        return user;
    }

}
