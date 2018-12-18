package com.junly.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductService productService;

    @Test
    public void findAllByProductStatusTest(){
        JSONObject json = new JSONObject();
        json.put("productStatus", 1);
        String allByProductStatus = productService.findAllByProductStatus(json);
        log.info("allByProductStatus:{}", allByProductStatus);
        System.out.println(allByProductStatus);
    }
}