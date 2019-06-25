package com.batch.filetodatabase;

import com.batch.entity.ExamDetail;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 将实体类数据写入数据库
 */
@Component("FTD_ExamWriter")
public class FTD_ExamWriter implements ItemWriter<ExamDetail> {

    private static final String insert_examinfo="insert into examdetail (id,math,chinese,english,examnumber,examtime) values (?,?,?,?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(List<? extends ExamDetail> list) throws Exception {

        for (ExamDetail examDetail:list){
            jdbcTemplate.update(insert_examinfo,examDetail.getId(),examDetail.getMath(),examDetail.getChinese(),
                examDetail.getEnglish(), examDetail.getExamnumber(),examDetail.getExamtime());
        }
    }
}
