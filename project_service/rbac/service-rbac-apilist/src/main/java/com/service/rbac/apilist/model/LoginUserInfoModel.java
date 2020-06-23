package com.service.rbac.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 用户实体
 * @Author: lgw
 * @Date: 2020/06/16
 */
@Data
public class LoginUserInfoModel extends UserModel {
    @ApiModelProperty(value = "token")
    private String token;
}
