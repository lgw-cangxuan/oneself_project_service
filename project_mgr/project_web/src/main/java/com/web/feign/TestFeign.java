package com.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @desc: -.
 * @Author: lgw
 * @CreateDate: 2020//12
 */
@FeignClient("project-service")
public interface TestFeign {
    @RequestMapping(method = RequestMethod.POST, value = "/test/")
    String test();
}
