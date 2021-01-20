package com.web.controller.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: lgw
 * @Date: 2020/08/18
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(4^5);
        System.out.println(Integer.toBinaryString(45));
        //System.out.println(Integer.parseInt("110", 2));
        System.out.println(Math.round(5));
        char a='a';
        int p;
        p=a;
        System.out.println(p);
        System.out.println(a<<8);
        System.gc();
    }
}
