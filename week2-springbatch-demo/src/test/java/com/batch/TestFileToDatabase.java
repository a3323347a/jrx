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
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFileToDatabase {

    /**
     * 测试将学生信息文件导入数据库
     */
    @Test
    public void test1(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("batch_FTD.xml");
        JobLauncher launcher = (JobLauncher) applicationContext.getBean("jobLauncher");
        Job job = (Job) applicationContext.getBean("FTDJOB");

        JobParametersBuilder jpbuilder = new JobParametersBuilder();

        JobParameters jobParameters = jpbuilder.addString("student","data\\student.txt").toJobParameters();
        long start = System.currentTimeMillis();
        try {
            launcher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("---耗时：" + (end - start) / 1000 + "秒");
    }

    /**
     * 测试将学生考试成绩文件导入到数据库
     */
    @Test
    public void test2() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("batch_FTD.xml");
        JobLauncher launcher = (JobLauncher) applicationContext.getBean("jobLauncher");
        Job job = (Job) applicationContext.getBean("fileExamDetailToDb");
        JobParametersBuilder jpbuilder = new JobParametersBuilder();
        JobParameters jobParameters = jpbuilder.addString("examdetail","data\\examdetail.txt").toJobParameters();
        long start = System.currentTimeMillis();

        launcher.run(job, jobParameters);

        long end = System.currentTimeMillis();
        System.out.println("---耗时：" + (end - start) / 1000 + "秒");
    }
}
