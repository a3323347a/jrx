package com.boot.controller;

import com.boot.model.Customer;
import com.boot.response.ResponseBean;
import com.boot.response.UnicomResponseEnums;
import com.boot.service.CustomerService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "CustomerController", description = "客户信息控制器 | 对客户表进行增删查改")
@RequestMapping("/customer")
public class CustomerController {

    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;

    /**
     * 根据客户id查询客户信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    @ApiOperation(value = "查询",notes = "根据用户id查询返回单个对象<Customer>")
    @ApiImplicitParam(paramType = "path",name = "id",value = "客户id",required = true,dataType = "int")
    public ResponseBean<Customer> getCustomerById(@PathVariable("id") Integer id){
        Customer customer = customerService.getCustomerById(id);
        return new ResponseBean(true,customer,UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 查询所有客户信息,分页查询，允许传入当前页面和每页显示的行数
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/get")
    @ApiOperation(value = "分页查询",notes = "分页查询返回PageInfo<Customer>")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页",required = false,defaultValue = "1",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name ="pageSize",value = "页行数",required = false,defaultValue = "10",dataType = "int")
    })
    public ResponseBean<Customer> getCustomer(@RequestParam(value = "pageNum", required = false, defaultValue="1")
                                                      Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Customer> lists = customerService.getAllCustomers();
        return new ResponseBean(true,lists,UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 根据客户id删除客户信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除",notes = "根据用户id删除单个对象<Customer>")
    @ApiImplicitParam(paramType = "query",name = "id",value = "客户id",required = true,dataType = "int")
    public ResponseBean deleteCustomerById(@PathVariable("id") Integer id){

        customerService.deleteCustomerById(id);
        return new ResponseBean(true,"201","删除成功");
    }

    /**
     * 增加单个客户对象,在页面编写json数据post上去就行
     * @param customer
     * @return
     */
    @PostMapping ("/post")
    @ApiOperation(value = "增加",notes = "增加单个对象<Customer>")
    public ResponseBean postCustomer(@RequestBody Customer customer){

        customerService.addCustomer(customer);
        return new ResponseBean(true,"202","插入成功");
    }

    /**
     * 修改单个对象信息,当传入对象时，会先按照对象id进行查询
     * @param customer
     * @return
     */
    @PutMapping("/put")
    @ApiOperation(value = "修改",notes = "修改对象<Customer>的属性信息")
    public ResponseBean updateCustomer(@RequestBody Customer customer){

        customerService.updateCustomer(customer);
        return new ResponseBean(true,"203","修改成功");
    }

    /**
     * 查询客户表的记录信息数量
     * @return
     */
    @GetMapping("/getnumber")
    @ApiOperation(value = "查询",notes = "查询客户表的记录数量")
    public ResponseBean getNumber(){
        int number = customerService.getNumber();
        return new ResponseBean(true,number,UnicomResponseEnums.SUCCESS_OPTION);
    }
}
