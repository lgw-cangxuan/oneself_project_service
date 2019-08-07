package com.mgr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2019/8/7
 */
@RestController
@RequestMapping("/web/mgr/test")
public class TestController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "百度！";
    }
}
