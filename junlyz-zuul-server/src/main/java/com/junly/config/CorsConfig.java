package com.junly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName CorsConfig
 * @Description 采用spring注入的方式 解决跨域请求
 * @Author Administrator
 * @Date 2018/12/23 0023 10:56
 * @Version 1.0
 **/
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        // 允许所有请求跨域请求
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        //设置允许跨域的头， 设置成 * 表示允许所有的头跨域
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        //设置跨域的请求方式（GET / POST等， * 表示全部都允许）
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        //设置缓存时间
        corsConfiguration.setMaxAge(300l);
        source.registerCorsConfiguration("/**", corsConfiguration);
        CorsFilter corsFilter = new CorsFilter(source);
        return corsFilter;
    }

}
