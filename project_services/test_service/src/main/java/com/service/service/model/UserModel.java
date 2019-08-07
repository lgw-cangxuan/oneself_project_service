package com.service.service.model;

import lombok.Data;
import java.util.*;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2019/8/7
 */
@Data
public class UserModel {
    private String id;

    private String userName;

    private String userPassword;

    private String userPhone;

    private Date createDate;

    private Date updateDate;
}
