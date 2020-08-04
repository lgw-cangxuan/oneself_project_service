package com.service.car.apilist.model;

import com.service.base.apilist.util.CommonDateUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 消息实体类
 * @Author: lgw
 * @Date: 2020/07/22
 */
@Data
public class UserMessageModel {
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

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String avatarUrl;

    public String getCreateTimeDesc(){
        return createTime == null ? null : CommonDateUtil.formatDateToyyyy_MM_dd_HH_mm_ss(createTime);
    }
}
