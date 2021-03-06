package com.example.springcloud.filter;

import com.example.springcloud.util.FilterUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class TrackingFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    @Override
    //告诉Zuul改过滤器是前置过滤器、路由过滤器还是后置过滤器
    public String filterType() {
        return "pre";
    }

    @Override
    //返回一个整数值，指示不同类型的过滤器的执行顺序
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    //返回布尔值来指示该过滤器是否要执行
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    private boolean isCorrelationIdPresent() {
        if (FilterUtil.getCorrelationId() != null) {
            return true;
        }
        return false;
    }
    //该辅助方法实际上检查tmx-correlation-id是否存在，并且可以生成相关联ID的GUID值
    private String generateCorrelationId(){
        return UUID.randomUUID().toString();
    }

    @Override
    //每次服务通过过滤器时执行的代码，run方法检查tmx-correlation-id是否存在，如果不存在，则
    //生成一个关联值，并设置HTTP首部tmx-correlation-id
    public Object run() {
        if (isCorrelationIdPresent()) {
            System.out.println("found:" + FilterUtil.getCorrelationId());
        } else {
            FilterUtil.setCorrelationId(generateCorrelationId());
            System.out.println("generated:" + FilterUtil.getCorrelationId());
        }
        RequestContext context = RequestContext.getCurrentContext();
        System.out.println("incoming request:" +context.getRequest().getRequestURI());
        return null;
    }
}
