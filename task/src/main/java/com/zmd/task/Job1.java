package com.zmd.task;

import org.springframework.stereotype.Component;

/**
 * @ClassName Job1
 * @Description TODO
 * @Author zmd
 * @Date 2019/11/15 15:42
 * Version 1.0
 **/

@Component
public class Job1 {

    public void method(){
        System.out.print(System.currentTimeMillis());
    }
}
