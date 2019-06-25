package com.zjx.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//Ribbon负载均衡工具。
    public RestTemplate getRestTemplate() {
        //Ribbon这里默认使用轮询的算法
        return new RestTemplate();
    }
}
