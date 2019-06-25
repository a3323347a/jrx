package com.zjx.service;

import com.zjx.entity.Customer;
import com.zjx.mapper.CustomerMapper;
import com.zjx.tx.InsertException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@MapperScan("com.zjx.mapper")
public class CustService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private LinkManService linkManService;

    /**
     * 删除操作必须配置事务，删除一个客户的同时删除客户对应的多个联系人
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String deleteCustomer(Long id) {

        if (linkManService.getLinkManBylkmcustId(id)!=null){
            linkManService.deleteLinkManBylkmcustId(id);
        }
        customerMapper.deleteCustomerById(id);
        return "删除成功";
    }

    /**
     *测试事务，c1是可以正常添加进去的，c2是有问题的
     *观察数据库是否是二者都没添加进去
     */
    @Transactional
    public String insertCustomer(){

        Customer c1 = new Customer();
        c1.setCustId(3L);
        c1.setCustName("测试事务管理1");
        customerMapper.addCustomer(c1);

        Customer c2 = new Customer();
        c1.setCustId(44L);
        c1.setCustName("测试事务管理2");
        customerMapper.addCustomer(c2);
        if (customerMapper.getCustomerById(44L)!=null){
            return "插入成功";
        }
        else{
            throw new InsertException("id是自增的,不能直接插入id");
        }
    }


    public Customer getCustomerById(Long id){
        return customerMapper.getCustomerById(id);
    }

    public Customer addCustomer(Customer customer){
        customerMapper.addCustomer(customer);
        return customer;
    }

    public Customer updateCustomer(Customer customer){
        customerMapper.updateCustomerById(customer);
        return customer;
    }
}
