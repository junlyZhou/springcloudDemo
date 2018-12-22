package com.junly.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ZuulConfi
 * @Description 完成路由的动态配置；
 * @Author Administrator
 * @Date 2018/12/22 0022 21:33
 * @Version 1.0
 **/
@Component
public class ZuulConfi {

    @ConfigurationProperties
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
