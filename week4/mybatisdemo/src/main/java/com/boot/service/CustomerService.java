package com.boot.service;

import com.boot.mapper.CustomerMapper;
import com.boot.model.Customer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@MapperScan("com.boot.mapper")
public class CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    public Customer getCustomerById(Integer id){ return customerMapper.getCustomerById(id);
    }
    public List<Customer> getAllCustomers(){ return customerMapper.getAllCustomer();}

    @Transactional(rollbackFor = Exception.class)
    public void deleteCustomerById(Integer id){ customerMapper.deleteCustomerById(id); }
    public void addCustomer(Customer customer){customerMapper.addCustomer(customer);}
    public void updateCustomer(Customer customer){customerMapper.updateByPrimaryKeySelective(customer);}
    public int getNumber(){ return customerMapper.countByExample();}
}
