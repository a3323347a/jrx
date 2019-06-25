package com.batch;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试读取数据库数据并导出到文件中
 */
@ImportResource(locations = "classpath:application.yml")
public class TestDataToFile {

    /**
     * 测试读取数据库数据并导出到文件中
     */
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("batch_DTF.xml");
        JobLauncher launcher = (JobLauncher)context.getBean("jobLauncher");
        Job job = (Job) context.getBean("dbjobtofile");

        try {
            System.out.println("JOB运行开始...");
            JobExecution result = launcher.run(job, new JobParametersBuilder()
                    .addString("sql", "select * from examsummary").toJobParameters());
            System.out.println("处理结束，控制台打印处理结果:"+result.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
