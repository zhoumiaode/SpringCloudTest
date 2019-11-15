package com.zmd.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;

@SpringBootApplication
@EnableScheduling
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	/*@Scheduled(fixedRate = 3000,initialDelay = 3000)
	public void method(){
		System.out.print(System.currentTimeMillis()+"\n");
	}*/
}
