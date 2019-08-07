package com.service.service.dao;


import com.service.service.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserModel> queryUser();
}
