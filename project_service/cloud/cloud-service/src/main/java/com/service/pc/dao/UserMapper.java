package com.service.pc.dao;


import com.service.apilist.model.UserModel;

import java.util.List;

public interface UserMapper {
    List<UserModel> findAllUser();
}
