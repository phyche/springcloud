package com.example.springcloud.filter;

import com.example.springcloud.util.FilterUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

@Component
public class SpecialRoutesFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    @Override
    public String filterType() {
        return "routing";
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        System.out.println("outbound headers:" + FilterUtil.getCorrelationId());
        //获取原始HTTP请求中传入的关联ID，并将它注入响应中
        context.getResponse().addHeader(FilterUtil.CORRELATION_ID, FilterUtil.getCorrelationId());
        //记录传出的请求URI，它将显示Zuul的用户请求的传入和传出条目
        System.out.println("outgoing request for:" + context.getRequest().getRequestURI());
        return null;
    }
}
