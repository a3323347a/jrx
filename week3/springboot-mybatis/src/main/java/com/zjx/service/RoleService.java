package com.zjx.service;

import com.zjx.entity.Role;
import com.zjx.mapper.RoleMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@MapperScan("com.zjx.mapper")
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public Role GetRoleAndStudent(Long id){
        return roleMapper.selectRoleAndUser(id);
    }
}
