package com.service.car.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 消息实体类
 * @Author: lgw
 * @Date: 2020/07/22
 */
@Data
public class UserMessageForm {
    @ApiModelProperty(value = "id", hidden = true)
    private String id;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "发送的用户id")
    private String toUserId;

    @ApiModelProperty(value = "群id")
    private String groupId;

    @ApiModelProperty(value = "消息内容")
    private String messageContent;
}
