package com.example.microservicegatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;


public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            PreRequestLogFilter.class
    );

    /**
     * 定义过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        //在PreDecorationFilter之前执行
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    /**
     * 此方法的“true”返回意味着应该调用run（）方法
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = ctx.getRequest();
        PreRequestLogFilter.LOGGER.info(String.format(
                "send %s request from %s to %s",
                httpServletRequest.getMethod(),
                httpServletRequest.getRemoteAddr(),
                httpServletRequest.getRequestURL().toString()
                ));

        return null;
    }
}
