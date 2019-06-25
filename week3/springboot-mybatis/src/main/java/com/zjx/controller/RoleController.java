package com.zjx.controller;

import com.zjx.entity.Role;
import com.zjx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role/get/{id}")
    public Role getRoleAndUserById(@PathVariable("id") Long id){
        return roleService.GetRoleAndStudent(id);
    }
}
