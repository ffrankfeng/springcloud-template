package com.fengf.demo.springcloud.userfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserFeignApplication.class, args);
    }

}
