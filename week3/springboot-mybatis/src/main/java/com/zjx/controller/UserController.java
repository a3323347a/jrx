package com.zjx.controller;

import com.zjx.entity.User;
import com.zjx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/get/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getUserAndRole(id);
    }
}
