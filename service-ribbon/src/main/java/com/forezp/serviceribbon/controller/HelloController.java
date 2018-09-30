package com.forezp.serviceribbon.controller;

import com.forezp.serviceribbon.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: scfchapter1
 * @Package: com.forezp.serviceribbon.controller
 * @ClassName: HelloController
 * @Description: java类作用描述
 * @Author: zhoumiaode
 * @CreateDate: 2018/09/25 11:36
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/09/25 11:36
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@RestController
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }

    @GetMapping(value = "/test")
    public String test(){
        return helloService.test();
    }
}
