package com.zjx;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zjx"})
@ComponentScan("com.zjx")
public class ConsumerFeign_App {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign_App.class, args);
    }
}
