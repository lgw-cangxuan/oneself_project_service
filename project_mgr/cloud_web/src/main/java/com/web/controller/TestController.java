package com.web.controller;

import com.web.feign.TestFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2020/06/16
 */
@RestController
public class TestController {
    @Autowired
    private TestFeign testFeign;

    @RequestMapping("/test")
    public String test(@RequestParam String name) {
        return testFeign.hello(name);
    }
}
