package com.service.base.apilist.idutil;

import java.util.UUID;

/**
 * @Description: uuid生成
 * @Author: lgw
 * @Date: 2020/07/01
 */
public class UuIdUtil {
    public static String getUuId(){
        //得到32位的uuid
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        System.out.println(getUuId());
    }
}
