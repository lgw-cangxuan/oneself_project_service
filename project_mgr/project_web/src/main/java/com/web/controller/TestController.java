package com.web.controller;

import com.web.feign.TestFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2020/06/12
 */
@RestController
@RequestMapping("/person")
public class TestController {
    @Resource
    private TestFeign testFeign;

    @GetMapping("/personGetFeignTest")
    @ResponseBody
    public String personGetFeignTest() {
        return testFeign.test();
    }
}
