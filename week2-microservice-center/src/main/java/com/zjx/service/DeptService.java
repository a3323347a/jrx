package com.zjx.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 使用Feign负载均衡
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT")
public interface DeptService {

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public String add();

    @RequestMapping(value = "/dept/get", method = RequestMethod.GET)
    public String get();

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public String list();
}
