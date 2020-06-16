package com.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "producer-service")
public interface UserFeign {
    /**
     * 测试feigin
     * @param
     * @return 保证该抽象方法与生产者服务中的方法完全相同
     */
    @RequestMapping(value = {"/user/findAllUser"}, method = {RequestMethod.POST})
    String findAllUser();
}
