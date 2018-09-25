package com.forezp.servicefeign.inteface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: scfchapter1
 * @Package: com.forezp.servicefeign.inteface
 * @ClassName: SchedualServiceHi
 * @Description: java类作用描述
 * @Author: zhoumiaode
 * @CreateDate: 2018/09/25 11:51
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/09/25 11:51
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */

@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
