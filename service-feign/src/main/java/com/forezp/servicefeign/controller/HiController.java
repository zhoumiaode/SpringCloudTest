package com.forezp.servicefeign.controller;

import com.forezp.servicefeign.inteface.SchedualServiceHi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: scfchapter1
 * @Package: com.forezp.servicefeign.controller
 * @ClassName: HiController
 * @Description: java类作用描述
 * @Author: zhoumiaode
 * @CreateDate: 2018/09/25 11:52
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/09/25 11:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@RestController
public class HiController {

    @Resource
    private SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne( name );
    }

}
