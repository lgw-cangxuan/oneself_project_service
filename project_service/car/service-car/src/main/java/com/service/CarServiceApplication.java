package com.service;

import com.service.base.apilist.config.RedisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @Description: service启动类
 * @author lgw
 * @date 2020/06/16
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({ "com.service.pc.dao"})
@Import(RedisConfig.class)
public class CarServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarServiceApplication.class, args);
    }

}
