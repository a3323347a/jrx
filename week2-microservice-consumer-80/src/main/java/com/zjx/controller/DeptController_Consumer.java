package com.zjx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";

    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public String add() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/add", String.class);
    }

    @RequestMapping(value = "/consumer/dept/get")
    public String get() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get", String.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public String list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", String.class);
    }
}

