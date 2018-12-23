package com.junly.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junly.enume.ResponseEnume;
import com.junly.pojo.Product;
import com.junly.response.ResultVo;
import com.junly.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName HystrixController
 * @Description 测试熔断机制
 * @Author Administrator
 * @Date 2018/12/23 0023 11:20
 * @Version 1.0
 **/
@RestController
public class HystrixController {

    private static final Logger log = LoggerFactory.getLogger(HystrixController.class);

    @Autowired
    private ProductService productService;

    /**
     * @description 测试熔断机制
     * @author junly
     * @date 2018/12/23
     * @param  {"productId": 1}
     * @throws
     * @return com.junly.response.ResultVo<java.util.List<com.junly.pojo.Product>>
     */
    @RequestMapping("/hyProduct")
    public ResultVo<Product> findAllByProductStatus2(@RequestBody JSONObject json){
        log.info("测试熔断机制， 参数：" + JSON.toJSONString(json));
        try {
            //测试熔断机制
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResultVo<Product> resultVo = new ResultVo<>();
        Integer productId = json.getInteger("productId");
        Product product = productService.findByProductId(productId);
        log.info("测试熔断机制， product：" + JSON.toJSONString(product));
        resultVo.setData(product);
        resultVo.setCode(ResponseEnume.SUCCESS.getCode());
        resultVo.setMsg(ResponseEnume.SUCCESS.getDesc());
        return resultVo;
    }

}
