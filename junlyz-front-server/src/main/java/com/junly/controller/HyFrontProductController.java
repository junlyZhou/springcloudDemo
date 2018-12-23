package com.junly.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junly.service.HyProductService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HyFrontProductController
 * @Description 测试hystrix 熔断机制
 * @Author Administrator
 * @Date 2018/12/23 0023 11:41
 * @Version 1.0
 **/
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HyFrontProductController {

    private static final Logger log = LoggerFactory.getLogger(HyFrontProductController.class);

    @Autowired
    private HyProductService hyProductService;

    //设置熔断机制的超时时间2000秒 , 也可以写在配置文件中
    @HystrixCommand(commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"))
    @RequestMapping("/product")
    public Object findByProductId(@RequestBody JSONObject json){
        log.info("json:"+ JSON.toJSONString(json));
        return hyProductService.findByProductId(json);
    }

//    public Object fallback(JSONObject json){
//        return "系统忙，请稍后再试！！！";
//    }

    public Object defaultFallback(){
        return "默认提示：系统忙，请稍后再试！！！";
    }

}
