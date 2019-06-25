package com.zjx.test;


import com.zjx.dao.CustomerDao;
import com.zjx.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestCoustomerDao {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 测试根据id查询
     */
    @Test
    public void testFindOne(){
        Customer customer = customerDao.findOne(1l);
        System.out.println(customer);
    }

    /**
     * 测试增加一个对象
     */
    @Test
    public void testSave() {
        Customer customer  = new Customer();
        customer.setCustName("程序员");
        customer.setCustLevel("高级会员");
        customer.setCustIndustry("it教育");
        customerDao.save(customer);
    }
    /**
     * 测试根据id查询并修改客户信息
     */
    @Test
    public void testUpdate() {
        Customer customer  = customerDao.findOne(2l);
        customer.setCustAddress("广东广州");
        customerDao.save(customer);
    }

    /**
     * 查询所有
     */
    @Test
    public void testFindAll() {
        List<Customer> list = customerDao.findAll();
        for(Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 测试更新客户的信息
     */
    @Test
    @Transactional  //添加事务的支持
    @Rollback(value = false)
    public void testUpdateByNameAndId(){
        customerDao.updateCustomer(1l,"高级程序员");
    }

    /**
     * 测试通过id和名字查询
     */
    @Test
    public void testFindCustNameAndId() {
        // Customer customer =  customerDao.findCustNameAndId("传智播客",1l);
        Customer customer =  customerDao.findCustNameAndId(2l,"程序员");
        System.out.println(customer);
    }
}
