package com.forezp.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ProjectName: scfchapter1
 * @Package: com.forezp.serviceribbon.service
 * @ClassName: HelloService
 * @Description: java类作用描述
 * @Author: zhoumiaode
 * @CreateDate: 2018/09/25 11:35
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/09/25 11:35
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */

@Service
public class HelloService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String test(){
        return restTemplate.getForObject("http://service-feign/test",String.class);
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }
}
