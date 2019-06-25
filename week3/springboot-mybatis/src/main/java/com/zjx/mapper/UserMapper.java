package com.zjx.mapper;

import com.zjx.entity.User;

public interface UserMapper {

    /**
     * 通过用户id获取用户和他所对应的角色
     * 一个用户对应多个角色
     * @param id
     * @return
     */
    User getUserAndRoleById(Long id);
}
