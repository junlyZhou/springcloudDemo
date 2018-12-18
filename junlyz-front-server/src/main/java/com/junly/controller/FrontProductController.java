package com.junly.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junly.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FrontProductController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/17 0017 20:06
 * @Version 1.0
 **/
@RestController
@RequestMapping("/front")
public class FrontProductController {

    private static final Logger log = LoggerFactory.getLogger(FrontProductController.class);

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public Object findAllByProductStatus(@RequestBody JSONObject json){
        log.info("json:"+ JSON.toJSONString(json));
        return productService.findAllByProductStatus(json);
    }

}
