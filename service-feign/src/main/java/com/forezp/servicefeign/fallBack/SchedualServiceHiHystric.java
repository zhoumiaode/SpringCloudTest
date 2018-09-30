package com.forezp.servicefeign.fallBack;

import com.forezp.servicefeign.inteface.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: scfchapter1
 * @Package: com.forezp.servicefeign.fallBack
 * @ClassName: SchedualServiceHiHystric
 * @Description: java类作用描述
 * @Author: zhoumiaode
 * @CreateDate: 2018/09/26 11:13
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/09/26 11:13
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
