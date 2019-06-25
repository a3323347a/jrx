package com.zjx.dao;

import com.zjx.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JpaRepository<操作的实体类类型，实体类中主键属性的类型>
 *     * 封装了基本CRUD操作
 * JpaSpecificationExecutor<操作的实体类类型>
 *     * 封装了复杂查询（分页）
 */
public interface CustomerDao extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer> {

    /**
     * 根据客户名称查询客户信息
     */
    @Query(value="from Customer where custName = ?")
    public Customer findJpql(String custName);

    /**
     * 根据客户ID和名称查询客户信息
     */
    @Query(value = "from Customer where custId = ? and custName = ?")
    public Customer findByIdAndName(long id,String name);

    /**
     *更新客户信息，根据客户ID
     * @Modifying 表示当前执行的是一个更新操作
     * 可以指定占位符参数的位置
     * 索引的方式，指定此占位的取值来源
     */
    @Query(value = " update Customer set custName = ?2 where custId = ?1 ")
    @Modifying
    public void updateCustomer(long custId,String custName);

    /**
     * 模糊查询
     * nativeQuery ： 查询方式
     * true ： sql查询
     * false：jpql查询
     */
    @Query(value="select * from cst_customer where cust_name like ?1",nativeQuery = true)
    public List<Object [] > findBySql(String name);


    @Query(value = "from Customer where custName = ?2 and custId = ?1")
    public Customer findCustNameAndId(Long id,String name);


    @Query(value = "delete from Customer where custId = ?")
    public void deleteCustomerById(Long id);
}
