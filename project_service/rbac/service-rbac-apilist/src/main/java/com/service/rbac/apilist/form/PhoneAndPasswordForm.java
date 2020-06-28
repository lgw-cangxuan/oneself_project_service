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
public class PhoneAndPasswordForm {
    @NotNull(message = "手机号码不能为空")
    @ApiModelProperty(value = "手机号码")
    private String phone;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "新密码,忘记密码使用")
    private String newPassword;

}
