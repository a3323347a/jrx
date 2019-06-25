package com.test;

import com.boot.Application;
import com.boot.model.TransDetail;
import com.boot.service.TransDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class testTransDetailService {

    @Autowired
    private TransDetailService transDetailService;
    /**
     * 测试根据单号查询
     */
    @Test
    public void testgetTransDetailById(){
        TransDetail transDetail = transDetailService.getTransDetailById(10000001);
        System.out.println(transDetail);
    }
    /**
     * 测试获取所有交易记录
     */
    @Test
    public void testgetAllTransDetail(){
        List<TransDetail> lists = transDetailService.getAllTransDetail();
        for (TransDetail transDetail:lists){
            System.out.println(transDetail);
        }
    }
    /**
     * 测试获取交易记录的数量
     */
    @Test
    public void testgetCount(){
        int number = transDetailService.getCount();
        System.out.println("总共有"+number+"条");
    }
}
