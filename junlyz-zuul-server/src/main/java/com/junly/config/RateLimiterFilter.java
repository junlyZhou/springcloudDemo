package com.junly.config;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @ClassName RateLimiterFilter
 * @Description 限流过滤器
 * @Author Administrator
 * @Date 2018/12/22 0022 22:29
 * @Version 1.0
 **/
public class RateLimiterFilter extends ZuulFilter {

    /**
     * @description 采用google guava已经实现的令牌算法
     * @author junly
     * @date 2018/12/22
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        if(!RATE_LIMITER.tryAcquire()){
            //此处可以抛出异常，也可以和其他鉴权方式一样返回响应码的方式；这里采用返回响应
            requestContext.setSendZuulResponse(false);
            //401 ： 表示权限不足
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }

        return null;
    }
}
