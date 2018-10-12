package com.forezp.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: scfchapter1
 * @Package: com.forezp.zuul.filter
 * @ClassName: MyFilter
 * @Description: java类作用描述
 * @Author: zhoumiaode
 * @CreateDate: 2018/10/12 10:12
 * @UpdateUser: Neil.Zhou
 * @UpdateDate: 2018/10/12 10:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class MyFilter extends ZuulFilter{
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    
    /** 
    * @Description:  代表过滤器类型，分为四种生命周期的过滤器类型
     * pre:路由前
     * routing:路由时
     * post:路由后
     * error:错误时
    * @Param: [] 
    * @return: java.lang.String 
    * @Author: zhoumiaode
    * @Date: 2018/10/12 
    */ 
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        ServletRequestAttributes requestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=requestAttributes.getRequest();
        if(request.getServletPath().equals("/api-a/hi")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
