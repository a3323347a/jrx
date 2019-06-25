package com.zjx.test;

import com.zjx.dao.CustomerDao;
import com.zjx.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;
    /**
     * 测试分页查询
     */
    @Test
    public void test1(){
        Specification specification = null;
        /**
         * 第一个参数：当前查询的页数（从0开始）
         * 第二个参数：每页查询的数量
         */
        Pageable pageable = new PageRequest(0,2);
        Page<Customer> page = customerDao.findAll(pageable);
        System.out.println(page.getContent());//得到数据集合列表

        System.out.println("页面总条数:"+page.getTotalElements()+"条");
        System.out.println("总页数:"+page.getTotalPages()+"页");
    }

    /**
     * 完成根据客户名称的模糊查询，返回客户列表
     */
    @Test
    public void test2(){
        //构造查询条件
        Specification<Customer> specification = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //查询属性：客户名
                Path<Object> custName = root.get("custName");
                //查询方式：模糊匹配
                Predicate predicate = criteriaBuilder.like(custName.as(String.class),"程序员%");
                return predicate;
            }
        };
        //降序排序
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<Customer> list = customerDao.findAll(specification, sort);
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}
