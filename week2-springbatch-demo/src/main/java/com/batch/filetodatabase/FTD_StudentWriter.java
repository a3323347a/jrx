package com.batch.filetodatabase;

import com.batch.entity.Student;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 将学生类数据写入数据库
 */
@Component("FTD_StudentWriter")
public class FTD_StudentWriter implements ItemWriter<Student> {

    private static final String insert_student = "insert into student (id,classesId,name,sex,age) values (?,?,?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void write(List<? extends Student> list) throws Exception {
        for (Student student:list){
            jdbcTemplate.update(insert_student,student.getId(),
                    student.getClassesId(),student.getName(),student.getSex(),student.getAge());
        }
    }
}
