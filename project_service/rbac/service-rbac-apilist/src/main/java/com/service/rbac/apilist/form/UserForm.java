package com.service.rbac.apilist.form;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 用户实体
 * @Author: lgw
 * @Date: 2020/06/16
 */
@Data
public class UserForm {
    private String id;

    private String nike;

    private String name;

    private String password;
}
