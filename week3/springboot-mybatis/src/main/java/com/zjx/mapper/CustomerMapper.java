package com.zjx.mapper;

import com.zjx.entity.Customer;


public interface CustomerMapper {
    /**
     *根据客户ID来查询客户信息
     */
    Customer getCustomerById(Long id);

    /**
     * 添加客户
     */
    void addCustomer(Customer customer);

    /**
     * 更新客户
     */
    Customer updateCustomerById(Customer customer);

    /**
     * 删除客户
     * @param id
     */
    void deleteCustomerById(Long id);
}
