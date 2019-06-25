package com.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * job工作监听器
 */
public class JobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("任务处理开始---------");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("任务处理结束----------");
    }
}
