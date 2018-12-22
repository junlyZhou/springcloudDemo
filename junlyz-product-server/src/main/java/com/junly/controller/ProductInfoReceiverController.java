package com.junly.controller;

import com.alibaba.fastjson.JSONObject;
import com.junly.service.impl.ProductInfoRecevier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductInfoReceiverController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 0022 19:37
 * @Version 1.0
 **/
@RestController
public class ProductInfoReceiverController {

    @Autowired
    private ProductInfoRecevier productInfoRecevier;

    @RequestMapping("/toredis")
    public String saveToRedis(@RequestBody JSONObject json){
        return productInfoRecevier.saveRedis(json);
    }
}
