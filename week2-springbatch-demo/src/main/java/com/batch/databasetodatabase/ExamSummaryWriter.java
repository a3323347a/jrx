package com.batch.databasetodatabase;

import com.batch.entity.ExamDetail;
import com.batch.entity.ExamSummary;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * 基于注解的形式写数据库，使用jdbcTemplate存进数据库
 */
@Component("DTD_examsummaryWriter")
public class ExamSummaryWriter implements ItemWriter<ExamSummary> {
    private static final String insert_examsummary = "insert into examsummary (id,examnumber,totalpoint,averagescore) values (?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(List<? extends ExamSummary> list) throws Exception {
        for (ExamSummary examSummary:list){

            jdbcTemplate.update(insert_examsummary,examSummary.getId(),examSummary.getExamnumber(),
                    examSummary.getTotalpoint(),examSummary.getAveragescore());
        }
    }
}

