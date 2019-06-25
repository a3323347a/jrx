package com.batch.databasetodatabase;

import com.batch.entity.ExamDetail;
import com.batch.entity.ExamSummary;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 *处理读取的数据：这里是将考试详细表转化为考试汇总表
 */
@Component("DTD_examProcessor")
public class ExamProcessor implements ItemProcessor<ExamDetail,ExamSummary> {
    @Override
    public ExamSummary process(ExamDetail examDetail) throws Exception {

        ExamSummary examSummary = new ExamSummary();
        examSummary.setId(examDetail.getId());
        examSummary.setExamnumber(examDetail.getExamnumber());
        int sum = examDetail.getChinese()+examDetail.getMath()+examDetail.getEnglish();
        double average = (double)sum/3;
        examSummary.setTotalpoint(sum);
        examSummary.setAveragescore(average);
        return examSummary;
    }
}
