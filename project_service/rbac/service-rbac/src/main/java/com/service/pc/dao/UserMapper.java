package com.service.pc.dao;




import com.service.rbac.apilist.form.PhoneAndPasswordForm;
import com.service.rbac.apilist.form.UserForm;
import com.service.rbac.apilist.model.UserModel;

import java.util.List;

/**
 * user mapper
 *
 * @author lgw
 * @date 2020/06/16
 */
public interface UserMapper {
    /**
     * query user info list
     * @return
     */
    List<UserModel> findAllUser();

    /**
     * query user by name and password
     * @param form
     * @return
     */
    UserModel queryUserByNameAndPassword(PhoneAndPasswordForm form);

    /**
     * query user by id
     * @param id
     * @return
     */
    UserModel queryUserById(String id);

    /**
     * insert user info
     * @param form user info
     */
    void insertUser(UserForm form);

    /**
     * update user info
     * @param form user info
     */
    void updateUser(UserForm form);
}
