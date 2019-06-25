package com.zjx.mapper;

import com.zjx.entity.Role;

public interface RoleMapper {

    /**
     * 通过id获取角色和用户
     * 一个角色可以有多个用户
     * @param id
     * @return
     */
    Role selectRoleAndUser(Long id);
}
