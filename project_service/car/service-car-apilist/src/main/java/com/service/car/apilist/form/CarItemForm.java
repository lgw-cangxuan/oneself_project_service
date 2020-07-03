package com.service.car.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * @Description: 汽车名
 * @Author: lgw
 * @Date: 2020/07/03
 */
@Data
public class CarItemForm {
    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "首字母")
    private String firstLetter;

    @ApiModelProperty(value = "生产商")
    private String producers;

    @ApiModelProperty(value = "款式")
    private String style;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
