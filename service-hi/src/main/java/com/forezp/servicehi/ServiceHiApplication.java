package com.forezp.servicehi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient //表示服务注册
@RestController
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/hi1")
    public String home1(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping(value = "getList")
    public List<String> getList(){
        List<String> list=new ArrayList<String>();
        list.add("first");
        list.add("second");
        return  list;
    }


}
