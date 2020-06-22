package com.service.rbac.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @Description: 用户实体
 * @Author: lgw
 * @Date: 2020/06/16
 */
@Data
public class UserForm {
    @ApiModelProperty(value = "id")
    private String id;

    @NotNull(message = "昵称不能为空")
    @ApiModelProperty(value = "昵称")
    private String nike;

    @NotNull(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名")
    private String name;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;
}
