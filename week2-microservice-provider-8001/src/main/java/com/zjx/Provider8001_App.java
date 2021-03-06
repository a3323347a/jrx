package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //本服务启动会自动注册进Eureka服务中
public class Provider8001_App {

    public static void main(String[] args) {
        SpringApplication.run(Provider8001_App.class, args);
    }
}
