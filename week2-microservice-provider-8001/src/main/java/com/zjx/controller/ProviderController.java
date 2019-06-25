package com.zjx.controller;

import com.zjx.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {


    @Autowired
    private ProviderService providerService;

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public String add() {
        return providerService.add();
    }

    @RequestMapping(value = "/dept/get", method = RequestMethod.GET)
    public String get() {
        return providerService.get();
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public String list() {
        return providerService.list();
    }

}
