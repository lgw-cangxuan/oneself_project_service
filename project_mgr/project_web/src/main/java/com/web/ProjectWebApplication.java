package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务消费者
 * @author liuguowei
 */
@SpringBootApplication
@EnableEurekaClient
public class ProjectWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectWebApplication.class, args);
    }

}
