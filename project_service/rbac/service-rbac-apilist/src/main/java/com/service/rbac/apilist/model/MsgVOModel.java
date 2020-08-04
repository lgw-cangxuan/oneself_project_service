package com.service.rbac.apilist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @Author: lgw
 * @Date: 2020/07/22
 */
@Data
@ApiModel(description = "websocket消息内容")
public class MsgVOModel {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String nickname;

    @ApiModelProperty(value = "用户头像")
    private String avatarUrl;

    @ApiModelProperty(value = "消息")
    private String messageContent;

    @ApiModelProperty(value = "在线人数")
    private int count;

}
