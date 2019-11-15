package com.zmd.task;

import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * @ClassName QuatzConfigs
 * @Description TODO
 * @Author zmd
 * @Date 2019/11/15 15:58
 * Version 1.0
 **/

@Configuration
@Async
public class QuatzConfigs {

    @Bean
    public HelloService helloService(){
        return  new HelloService();
    }

    @Bean
    JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("helloService",helloService());
        jobDetailFactoryBean.setJobDataMap(jobDataMap);
        jobDetailFactoryBean.setJobClass(Job2.class);
        return jobDetailFactoryBean;
    }

    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean cronTriggerFactoryBean= new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setCronExpression("0/5 * * * * ?");
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean().getObject());
        return cronTriggerFactoryBean;
    }

    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean schedulerFactoryBean= new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean().getObject(),SpringContextUtil.getBean("simpleTriggerFactoryBean"));
        return schedulerFactoryBean;
    }
}
