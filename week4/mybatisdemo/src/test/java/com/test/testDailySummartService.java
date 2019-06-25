package com.test;

import com.boot.Application;
import com.boot.model.Customer;
import com.boot.model.Dailysummary;
import com.boot.service.CustomerService;
import com.boot.service.DailySummaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class testDailySummartService {


    @Autowired
    private DailySummaryService dailySummaryService;

    @Autowired
    private CustomerService customerService;

    /**
     * 测试添加日汇总表信息
     */
    @Test
    public void testAddDailySummary(){
        Dailysummary dailysummary = new Dailysummary();
        //这里的客户名字应该是查询出来的，所以先获取客户信息
        Customer customer = customerService.getCustomerById(2);
        dailysummary.setCustId(customer.getCustid());
        dailysummary.setSurname(customer.getSurname());
        dailysummary.setsIndex("034d_2019-07-13");
        BigDecimal bigDecimal = new BigDecimal("200.005");
        dailysummary.setPayAmt(bigDecimal);
        dailysummary.setPayCnt(1);
        dailysummary.setTranAmt(bigDecimal);
        dailysummary.setTranCnt(1);
        dailysummary.setTranMaxAmt(bigDecimal);
        dailysummary.setUpdateTime(new Date());
        dailysummary.setTransDate(new Date());
        dailySummaryService.addDailysummary(dailysummary);
    }
    /**
     * 测试获取日汇总记录数量
     */
    @Test
    public void testGetNumber(){
        int number = dailySummaryService.getNumber();
        System.out.println("总共有："+number+"条记录");
    }

    /**
     * 测试获取全部的记录
     */
    @Test
    public void testGetAll(){
        List<Dailysummary> lists = dailySummaryService.selectAll();
        for (Dailysummary dailysummary:lists){
            System.out.println(dailysummary);
        }
    }

    /**
     * 测试根据客户ID来删除他在汇总表的全部消费记录
     */
    @Test
    public void testDeleteByCustId(){
        dailySummaryService.deleteByCustId(2);
    }

    /**
     *测试更新日汇总表信息
     */
    @Test
    public void testUpdateDailySummary(){
        //先查出来
        Dailysummary dailysummary = dailySummaryService.getDailysummaryBysIndex("034d_2019-07-13");
        System.out.println("更新前------------------------------");
        System.out.println(dailysummary);
        dailysummary.setTranMaxAmt(new BigDecimal("4000.00"));
        System.out.println("更新后-------------------------------");
        dailySummaryService.updateDailysummaryBysIndex(dailysummary);

        dailysummary = dailySummaryService.getDailysummaryBysIndex("034d_2019-07-13");
        System.out.println(dailysummary);
    }

    /**
     * 测试删除汇总表
     * 根据索引项删除
     */
    @Test
    public void testDeleteBySindex(){
        String sindex = "fc1b_2019-09-04";
        dailySummaryService.deleteDailysummaryBySindex(sindex);
        //在进行查找看是否查到
        try {
            Dailysummary dailysummary = dailySummaryService.getDailysummaryBysIndex(sindex);
            System.out.println(dailysummary);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 测试获取日汇总表的数量
     */
    @Test
    public void testgetNumber(){
        int number = dailySummaryService.getNumber();
        System.out.println("总共有："+number+"条");
    }
}
