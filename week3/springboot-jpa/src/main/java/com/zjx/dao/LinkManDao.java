package com.zjx.dao;

import com.zjx.entity.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 联系人的dao接口
 * JpaRepository封装了基本的CRUD
 * JpaSpecificationExecutor封装了复杂查询
 */
public interface LinkManDao extends JpaRepository<LinkMan,Long>, JpaSpecificationExecutor<LinkMan> {

}
