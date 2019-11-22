package com.zmd.tasks;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @ClassName Job2
 * @Description TODO
 * @Author zmd
 * @Date 2019/11/15 15:42
 * Version 1.0
 **/
public class Job2 extends QuartzJobBean {

    public HelloService helloService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        helloService.method();
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
