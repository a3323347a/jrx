package com.boot.controller;

import com.boot.model.Dailysummary;
import com.boot.response.ResponseBean;
import com.boot.response.UnicomResponseEnums;
import com.boot.service.DailySummaryService;
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
@Api(tags = "DailySummaryController", description = "日汇总表控制器 | 对汇总表进行增删查改")
@RequestMapping("/dailysummary")
public class DailySummaryController {

    public static final Logger logger = LoggerFactory.getLogger(DailySummaryController.class);

    @Autowired
    private DailySummaryService dailySummaryService;

    /**
     * 全部查询的汇总表信息，分页查询,可以传入2个参数
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/get")
    @ApiOperation(value = "查询",notes = "查询全部汇总表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "pageNum",value = "当前页",required = false,defaultValue = "1",dataType = "int"),
            @ApiImplicitParam(paramType = "query",name ="pageSize",value = "页行数",required = false,defaultValue = "10",dataType = "int")
    })
    public ResponseBean<Dailysummary> getAllDailysummary(@RequestParam(value = "pageNum", required = false, defaultValue="1")
                                                                     Integer pageNum,
                                                         @RequestParam(value = "pageSize", required = false, defaultValue="10") Integer pageSize){
        try {
            PageHelper.startPage(pageNum,pageSize);
            List<Dailysummary> lists = dailySummaryService.selectAll();
            return new ResponseBean(true,lists,UnicomResponseEnums.SUCCESS_OPTION);
        }catch (Exception e){
            logger.info(e.toString());
            return new ResponseBean(false,"400","出现错误");
        }
    }

    /**
     * 根据id来查询客户全部的日汇总表信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    @ApiOperation(value = "查询",notes = "根据客户id来查询全部日汇总信息")
    @ApiImplicitParam(paramType = "path",name = "id",value = "客户id",required = true,dataType = "int")
    public ResponseBean<Dailysummary> getAllById(@PathVariable("id") Integer id){
        List<Dailysummary> lists = dailySummaryService.selectById(id);
        return new ResponseBean(true,lists,UnicomResponseEnums.SUCCESS_OPTION);
    }

    /**
     * 查询日汇总表的记录数量
     * @return
     */
    @GetMapping("/getnumber")
    @ApiOperation(value = "查询",notes = "查询日汇总表的记录数量")
    public ResponseBean testGetnumber(){
        int number = dailySummaryService.getNumber();
        return new ResponseBean(true,number,UnicomResponseEnums.SUCCESS_OPTION);
    }
}
