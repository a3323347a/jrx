package com.batch.filetodatabase;

import com.batch.entity.Student;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * 将文件记录映射成学生类
 */
public class StudentFieldSetMapper implements FieldSetMapper<Student> {

    @Override
    public Student mapFieldSet(FieldSet fieldSet) throws BindException {

        Student student = new Student();
        student.setId(fieldSet.readInt("id"));
        student.setClassesId(fieldSet.readString("classesId"));
        student.setName(fieldSet.readString("name"));
        student.setSex(fieldSet.readString("sex"));
        student.setAge(fieldSet.readInt("age"));
        return student;
    }
}
