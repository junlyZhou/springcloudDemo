package com.junly.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName TokenFilter
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 0022 22:11
 * @Version 1.0
 **/
public class TokenFilter extends ZuulFilter {

    /**
     * @description 设置为前置过滤器
     * @author junly
     * @date 2018/12/23
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * @description  定义过滤执行的顺序
     * @author junly
     * @date 2018/12/22
     */
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * @description   具体过滤逻辑在这里写
     * @author junly
     * @date 2018/12/22
     * @param []
     * @throws
     * @return java.lang.Object
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //从参数里面获取需要校验的token
        //也可以从cookie , header里面获取token参数（具体看如何定义的）
        String token = request.getParameter("token");
        //如果token为空则不允许通过请求
        if(StringUtils.isEmpty(token)){
            requestContext.setSendZuulResponse(false);
            //401 ： 表示权限不足
            requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
        }
        return null;
    }
}
