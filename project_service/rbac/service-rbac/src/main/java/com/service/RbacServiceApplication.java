package com.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudServiceApplication class
 *
 * @author lgw
 * @date 2020/06/16
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan({ "com.service.pc.dao"})
public class RbacServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RbacServiceApplication.class, args);
    }

}
