package com.zmd.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.Date;

/**
 * @ClassName QuatzConfig
 * @Description TODO  此种Quatz无法传参
 * @Author zmd
 * @Date 2019/11/15 15:49
 * Version 1.0
 **/
@Configuration
public class QuatzConfig {

    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean(){
        MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean=new MethodInvokingJobDetailFactoryBean();
        methodInvokingJobDetailFactoryBean.setTargetBeanName("job1");
        methodInvokingJobDetailFactoryBean.setTargetMethod("method");
        return  methodInvokingJobDetailFactoryBean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setStartTime(new Date());
        simpleTriggerFactoryBean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        simpleTriggerFactoryBean.setRepeatInterval(3000);
        return  simpleTriggerFactoryBean;
    }
}
