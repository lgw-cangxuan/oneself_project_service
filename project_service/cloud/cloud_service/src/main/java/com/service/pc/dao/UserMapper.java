package com.service.pc.dao;

import com.service.pc.entity.UserModel;

import java.util.List;

public interface UserMapper {
    List<UserModel> findAllUser();
}
