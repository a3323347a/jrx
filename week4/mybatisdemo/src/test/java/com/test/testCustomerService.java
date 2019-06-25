package com.test;

import com.boot.Application;
import com.boot.model.Customer;
import com.boot.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class testCustomerService {

    @Autowired
    private CustomerService customerService;

    /**
     * 测试根据客户ID获取客户信息
     */
    @Test
    public void testGetCustomerByid(){

        Customer customer = customerService.getCustomerById(2);
        System.out.println(customer);
    }

    /**
     * 测试获取全部客户信息
     */
    @Test
    public void testGetAllcustomer(){
        List<Customer> lists = customerService.getAllCustomers();
        for (Customer customer:lists){
            System.out.println(customer);
        }
    }
    /**
     * 测试根据客户ID删除客户
     */
    @Test
    public void testDeleteCustomerById(){
        Integer id = 200001;
        customerService.deleteCustomerById(id);
    }

    /**
     * 测试添加用户
     */
    @Test
    public void testAddCustomer(){
        Customer customer = new Customer();
        customer.setAge(18);
        customer.setGender("男");
        customer.setSurname("张三");
        customer.setEducades("本科");
        customer.setMardes("未婚");
        customer.setAddress("测试地址");
        customerService.addCustomer(customer);
    }

    /**
     * 测试获取客户表的记录数量
     */
    @Test
    public void testGetNumber(){
        int number = customerService.getNumber();
        System.out.println("客户表有:"+number+"条");
    }
    /**
     * 测试更新客户信息
     */
    @Test
    public void testUpdateCustomer(){
        //首先先查询
        Customer customer = customerService.getCustomerById(2);
        customer.setAddress("我和你们不一样");
        customerService.updateCustomer(customer);
    }
}
