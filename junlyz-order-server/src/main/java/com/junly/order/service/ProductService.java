package com.junly.order.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 通过@Feign的方式来调用服务端（即 product）的方法
 * @author junly
 * @date 2018/12/16
 */
@Service
@FeignClient(name="PRODUCT-SERVER") //这里的name 是服务端名称
public interface ProductService {

    @RequestMapping("/findProduct")
    String findAllByProductStatus(JSONObject json);

}
