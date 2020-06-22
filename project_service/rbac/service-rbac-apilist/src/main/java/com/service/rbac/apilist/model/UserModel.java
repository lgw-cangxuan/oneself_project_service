package com.service.rbac.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 用户实体
 * @Author: lgw
 * @Date: 2020/06/16
 */
@Data
public class UserModel {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "昵称")
    private String nike;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
