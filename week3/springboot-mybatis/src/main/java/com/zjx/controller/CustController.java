package com.zjx.controller;

import com.zjx.entity.Customer;
import com.zjx.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustController {

    /**
     * 客户服务层
     */
    @Autowired
    private CustService custService;

    @GetMapping("/customer/get/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return custService.getCustomerById(id);
    }

    @GetMapping("/customer/add")
    public Customer addCustomer(Customer customer){
        return custService.addCustomer(customer);
    }
    @GetMapping("/customer/update")
    public Customer updateCustomer(Customer customer){
        return custService.updateCustomer(customer);
    }
    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id){
        return custService.deleteCustomer(id);
    }

    /**
     * 此插入方法用来测试事务
     */
    @GetMapping("/customer/insert")
    public void insertCustomer(){
        custService.insertCustomer();
    }
}
