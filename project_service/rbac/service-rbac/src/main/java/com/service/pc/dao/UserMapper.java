package com.service.pc.dao;




import com.service.rbac.apilist.model.UserModel;

import java.util.List;

public interface UserMapper {
    /**
     * 所有用户查询
     * @return
     */
    List<UserModel> findAllUser();
}
