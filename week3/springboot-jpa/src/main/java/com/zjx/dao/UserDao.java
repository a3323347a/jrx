package com.zjx.dao;

import com.zjx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 用户的dao接口
 * JpaRepository封装了基本的CRUD
 * JpaSpecificationExecutor封装了复杂查询
 */
public interface UserDao extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
}
