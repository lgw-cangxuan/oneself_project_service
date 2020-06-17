package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.service")
public class WebMgrApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebMgrApplication.class, args);
    }

}
