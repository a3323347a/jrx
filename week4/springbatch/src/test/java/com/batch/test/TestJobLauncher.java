package com.batch.test;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.batch.core.launch.JobLauncher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestJobLauncher {

    /**
     * 执行批处理作业.<br>
     * @param jobPath	作业配置文件
     * @param jobName	作业名
     * @param builder	作业参数构造器
     */
    public static void executeJob(String jobPath, String jobName, JobParametersBuilder builder) {
        ApplicationContext context = new ClassPathXmlApplicationContext(jobPath);
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean(jobName);
        try {
            JobExecution result = launcher.run(job, builder.toJobParameters());
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 批行处理任务
     * @param jobPath 作业配置文件
     * @param jobName 作业名
     * @param beginDate  开始时间
     * @param endDate    结束时间
     */
    public static void executeJobByTime(String jobPath,String jobName,String beginDate,String endDate){
        ApplicationContext context = new ClassPathXmlApplicationContext(jobPath);
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean(jobName);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate1 = LocalDate.parse(beginDate,df);
        LocalDate localDate2 = LocalDate.parse(endDate,df);
        JobParametersBuilder builder = new JobParametersBuilder();
        //一天执行一次job,直到结束日期
        while (localDate1.isBefore(localDate2)){
            try {
                /**
                 * 设置job参数,以日期作为参数
                 */
                builder.addString("tran_date",localDate1.format(df));
                JobExecution result = launcher.run(job,builder.toJobParameters());
                System.out.println(result.toString());
                localDate1 = localDate1.plusDays(1);
                System.out.println(localDate1.format(df));

            }catch (Exception e){
                e.printStackTrace();
                break;
            }

        }
    }

    /**
     * 读取txt客户信息文件并导入数据库
     */
    @Test
    public void testCustomerJob(){
        executeJob("batch-filetodb.xml","customerjob",
                new JobParametersBuilder().addDate("date", new Date()));
    }
    /**
     * 读取txt交易明细信息文件并导入数据库
     */
    @Test
    public void testTransDetailJob(){
        executeJob("batch-filetodb.xml","transdetailjob",
                new JobParametersBuilder().addDate("date", new Date()));
    }

    /**
     * 读取客户信息表和明细表并汇总
     */
    @Test
    public void testDailyJob(){
            executeJobByTime("batch-dbtodb.xml","dbtodbJob",
                    "2019-06-22", "2019-09-05");
        }
}
