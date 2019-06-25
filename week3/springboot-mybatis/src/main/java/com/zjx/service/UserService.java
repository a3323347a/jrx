package com.zjx.service;

import com.zjx.entity.User;
import com.zjx.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@MapperScan("com.zjx.mapper")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserAndRole(Long id){
        return userMapper.getUserAndRoleById(id);
    }
}
