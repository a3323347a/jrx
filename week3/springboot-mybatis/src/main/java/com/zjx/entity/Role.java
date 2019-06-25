package com.zjx.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {

    private Long roleId;

    private String roleName;

    /**
     * 一个角色对应多个用户
     */
    private Set<User> users = new HashSet<>();

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
