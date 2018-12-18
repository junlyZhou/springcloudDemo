package com.junly.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(name = "PRODUCT-SERVER")
public interface ProductService {

    @RequestMapping("/findProduct")
    String findAllByProductStatus(JSONObject json);

}
