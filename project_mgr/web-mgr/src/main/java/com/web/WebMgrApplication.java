package com.web;

import com.service.base.apilist.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.service")
@Import(RedisConfig.class)
public class WebMgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMgrApplication.class, args);
    }

}
