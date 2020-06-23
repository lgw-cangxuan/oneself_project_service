package com.service.rbac.apilist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.base.apilist.util.CommonDateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    public String getCreateTimeDesc(){
        return createTime == null ? null : CommonDateUtil.formatDateToyyyy_MM_dd_HH_mm_ss(createTime);
    }
}
