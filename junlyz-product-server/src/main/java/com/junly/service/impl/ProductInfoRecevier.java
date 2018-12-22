package com.junly.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @ClassName ProductInfoRecevier
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 0022 19:38
 * @Version 1.0
 **/
@Component
@Transactional
public class ProductInfoRecevier {
    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_";

    @Autowired
    private StringRedisTemplate template;

    public String saveRedis(JSONObject json){
        String productId =  json.getString("productId");
        template.opsForValue().set(PRODUCT_STOCK_TEMPLATE, productId);
        return productId + " success";
    }

}
