package com.service.apilist.model;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2020/06/16
 */
@Data
public class UserModel {
    private String id;

    private String nike;

    private String name;

    private String password;

    private Date createTime;
}
