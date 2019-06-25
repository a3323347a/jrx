package com.test;

import com.boot.Application;
import com.boot.model.Customer;
import com.boot.service.CustomerService;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Locale;

/**使用Faker生成数据
 * 这个代码仅仅是用来更新客户地址用的,
 * 后面报表显示才能用到地图
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class testUpdateAddress {

    @Autowired
    private CustomerService customerService;
    private String[] city =
            {
                    "北京", "天津", "上海", "重庆", "河北", "河南", "云南",
                    "辽宁", "黑龙江", "湖南", "安徽", "山东", "新疆", "江苏",
                    "浙江", "江西", "湖北", "广西", "江苏", "浙江", "江西",
                    "湖北", "广西", "甘肃", "山西",
                    "内蒙", "陕西", "吉林", "福建", "贵州", "广东", "陕西",
                    "吉林", "福建", "贵州", "广东", "陕西", "吉林",
                    "福建", "贵州", "广东", "广东", "广东", "陕西", "吉林",
                    "福建", "贵州", "广东", "青海", "西藏", "四川", "宁夏", "海南"
            };
    @Test
    public void testjavafaker(){
        Faker faker = new Faker(new Locale("zh_CN"));
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            int between = faker.number().numberBetween(0, 51);
            customer.setAddress(city[between]);
            customerService.updateCustomer(customer);
        }

    }
}
