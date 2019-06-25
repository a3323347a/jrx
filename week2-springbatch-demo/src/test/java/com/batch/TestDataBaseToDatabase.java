package com.batch;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试读取数据库中的学生详细表记录并汇总到学生汇总表
 * 即读取数据库一个表数据并统计转化到另外一个表中
 */

public class TestDataBaseToDatabase {
    /**
     * 测试读取数据库中的学生详细表记录并汇总到学生汇总表
     * 即读取数据库一个表数据并统计转化到另外一个表中
     */
    @Test
    public void test1() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("batch_DTD.xml");
        JobLauncher launcher = (JobLauncher) applicationContext.getBean("jobLauncher");
        Job job = (Job) applicationContext.getBean("DTDJOB");
        JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        JobParameters jobParameters = jobParametersBuilder.addString("sql", "select id,math,chinese,english,examnumber,examtime from examdetail").toJobParameters();
        long start = System.currentTimeMillis();
        launcher.run(job, jobParameters);
        long end = System.currentTimeMillis();
        System.out.println("---耗时：" + (end - start) / 1000 + "秒");
    }

    @Test
    public void test2(){

    }
}
