package com.service.pc.api;

import com.service.pc.service.TestService;
import com.service.util.RequestResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: guowei liu
 * @Date: 2020/06/12
 */
@RestController
public class TestApi {
    @Resource
    private TestService testService;

    @PostMapping("/test")
    public RequestResult<String> test(){
        return new RequestResult<>(testService.test());
    }
}
