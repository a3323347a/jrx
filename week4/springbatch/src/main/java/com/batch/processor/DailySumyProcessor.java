package com.batch.processor;

import com.batch.entity.DailySummary;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 对汇总信息在处理一下输出
 */
@Component("DailySumyProcessor")
public class DailySumyProcessor implements ItemProcessor<DailySummary,DailySummary> {

    @Override
    /**
     * 参数是读取进来，然后这里返回输出出去
     */
    public DailySummary process(DailySummary dailySummary) throws Exception {
        DailySummary result_dailysummary = new DailySummary();
        String dateTime = dailySummary.getDatetime();
        //提取日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        result_dailysummary.setCustId(dailySummary.getCustId());
        result_dailysummary.setDatetime(dailySummary.getDatetime());
        //获取日期,不要具体时间
        Date date = dateFormat.parse(dateTime);
        //获取UUID
        String sIndex = UUID.randomUUID().toString().replaceAll("-","").substring(0,4)+"_"+dateFormat.format(date);
        //设置索引项
        result_dailysummary.setSindex(sIndex);
        result_dailysummary.setDate(date);
        result_dailysummary.setCustName(dailySummary.getCustName());
        result_dailysummary.setTranMaxAmt(dailySummary.getTranMaxAmt());
        result_dailysummary.setPayAmt(dailySummary.getPayAmt());
        result_dailysummary.setPayCnt(dailySummary.getPayCnt());
        result_dailysummary.setTranCnt(dailySummary.getTranCnt());
        result_dailysummary.setTranAmt(dailySummary.getTranAmt());
        return result_dailysummary;
    }
}
