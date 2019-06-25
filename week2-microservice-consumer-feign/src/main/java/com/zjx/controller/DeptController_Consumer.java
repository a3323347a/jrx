package com.zjx.controller;


import com.zjx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/consumer/dept/add")
    public String add() {
        return this.deptService.add();
    }

    @RequestMapping(value = "/consumer/dept/get")
    public String get() {
        return this.deptService.get();
    }

    @RequestMapping(value = "/consumer/dept/list")
    public String list() {
        return this.deptService.list();
    }

}

