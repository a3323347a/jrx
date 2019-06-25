package com.batch.filetodatabase;

import com.batch.entity.ExamDetail;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * 将文件记录并映射成实体类
 */
public class ExamFieldSetMapper implements FieldSetMapper<ExamDetail> {

    @Override
    public ExamDetail mapFieldSet(FieldSet fieldSet) throws BindException {
        ExamDetail examDetail = new ExamDetail();
        examDetail.setId(fieldSet.readInt("id"));
        examDetail.setMath(fieldSet.readInt("math"));
        examDetail.setChinese(fieldSet.readInt("chinese"));
        examDetail.setEnglish(fieldSet.readInt("english"));
        examDetail.setExamnumber(fieldSet.readString("examnumber"));
        examDetail.setExamtime(fieldSet.readString("examtime"));
        return examDetail;
    }
}
