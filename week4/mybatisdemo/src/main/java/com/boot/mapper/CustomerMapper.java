package com.boot.mapper;

import com.boot.model.Customer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
     * 查询客户数量
     * @return int
     */
    int countByExample();

    /**
     * 查询所有客户
     * @return  list<customer></>
     */
    List<Customer> getAllCustomer();

    /**
     * 根据id来查询客户信息
     * @param id
     * @return customer
     */
    Customer getCustomerById(Integer id);

    /**
     * 添加客户
     * @param customer
     */
    void addCustomer( Customer customer);

    /**
     * 修改客户信息，根据客户id来选择
     * @param customer
     */
    void updateByPrimaryKeySelective( Customer customer);

    /**
     * 插入客户
     * @param customer
     */
    void insertSelective( Customer customer);

    /**
     * 根据客户id来删除
     * @param id
     */
    void deleteCustomerById(Integer id);

}