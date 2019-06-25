package com.zjx.dao;

import com.zjx.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 角色的dao接口
 * JpaRepository封装了基本的CRUD
 * JpaSpecificationExecutor封装了复杂查询
 */
public interface RoleDao extends JpaRepository<Role,Long>,JpaSpecificationExecutor<Role> {
}
