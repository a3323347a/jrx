package com.boot.controller;

import com.boot.model.TransDetail;
import com.boot.response.ResponseBean;
import com.boot.response.UnicomResponseEnums;
import com.boot.service.TransDetailService;
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
@Api(tags = "TransDetailCustomer", description = "交易明细表控制器 | 对交易明细表进行增删查改")
@RequestMapping("/trandeteil")
public class TransDetailController {

    public static final Logger logger = LoggerFactory.getLogger(TransDetailController.class);

    @Autowired
    private TransDetailService transDetailService;

    /**
     * 根据单号查询
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    @ApiOperation(value = "查询",notes = "根据交易单号查询")
    @ApiImplicitParam(paramType = "path",name = "id",value = "交易单号",required = true,dataType = "Integer")
    public ResponseBean<TransDetail> getTransDetailById(@PathVariable("id") Integer id){
        try {
            TransDetail transDetail = transDetailService.getTransDetailById(id);
            return new ResponseBean(true,transDetail,UnicomResponseEnums.SUCCESS_OPTION);
        }catch (Exception e){
            e.printStackTrace();
            logger.info(e.toString());
            return new ResponseBean(false,"400","操作出错");
        }
    }

    /**
     * 分页查询全部信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/get")
    @ApiOperation(value = "分页查询",notes = "分页查询返回全部交易记录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页",required = false,defaultValue = "1",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name ="pageSize",value = "页行数",required = false,defaultValue = "10",dataType = "int")
    })
    public ResponseBean<TransDetail> getTransDetail(@RequestParam(value = "pageNum", required = false, defaultValue="1")
                                                                  Integer pageNum,
                                                      @RequestParam(value = "pageSize", required = false, defaultValue="10")Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        try {
            List<TransDetail> lists = transDetailService.getAllTransDetail();
            return new ResponseBean(true,lists,UnicomResponseEnums.SUCCESS_OPTION);
        }catch (Exception e){
            logger.info(e.toString());
            return new ResponseBean(false,"400","出现错误");
        }

    }

    /**
     * 根据客户id进行删除
     * @param custId
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除",notes = "根据客户ID删除")
    @ApiImplicitParam(paramType = "query",name = "id",value = "客户id",required = true,dataType = "int")
    public ResponseBean deleteTransDetailById(@PathVariable("id") Integer custId){
        try {
            transDetailService.deleteTransDetailById(custId);
            return  new ResponseBean(true,"201","操作成功");
        }catch (Exception e){
            logger.info(e.toString());
            return new ResponseBean(false,"400","操作出错");
        }
    }
    /**
     * 增加单条交易明细对象
     * @param transDetail 交易明细
     */
    @PostMapping("/post")
    @ApiOperation(value = "增加",notes = "增加单个交易明细记录")
    public ResponseBean postTransDetail(@RequestBody TransDetail transDetail){
        transDetailService.addTransDetail(transDetail);
        return new ResponseBean(true,"202","插入成功");
    }
    /**
     * 修改单个对象信息,当传入对象时，会先按照对象id进行查询
     * @param transDetail 交易明细
     * @return
     */
    @PutMapping("/put")
    @ApiOperation(value = "修改",notes = "修改对象<transDetail>的属性信息")
    public ResponseBean updateTransDetail(@RequestBody TransDetail transDetail){
        transDetailService.updateTransDetail(transDetail);
        return new ResponseBean(true,"203","修改成功");
    }

    /**
     * 查询交易明细表的记录数量
     * @return
     */
    @GetMapping("/getnumber")
    @ApiOperation(value = "查询",notes = "查询交易明细表的记录数量")
    public ResponseBean getNumber(){
        int number = transDetailService.getCount();
        return new ResponseBean(true,number,UnicomResponseEnums.SUCCESS_OPTION);
    }
}
