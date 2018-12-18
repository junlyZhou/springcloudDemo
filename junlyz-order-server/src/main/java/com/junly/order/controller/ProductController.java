package com.junly.order.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.junly.order.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ProductController 采用调用产品微服务
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 21:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/hello")
    public Object getHello(){
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8081/hello", String.class);
        log.info(forObject);
        return forObject;
    }

    /**
     * @description 采用RestTemplate模板实现服务之间的调用 方法一
     * @author junly
     * @date 2018/12/16
     */
    @RequestMapping("/info/{productId}")
    public Object getProductInfo(@PathVariable Integer productId){
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8081/findProduct/" + productId, String.class);
        Object jsonResult = JSON.parse(forObject);
        log.info(forObject);
        return forObject;
    }

    /**
     * @description 采用RestTemplate模板实现服务之间的调用 方法二
     * @author junly
     * @date 2018/12/16
     */
    @RequestMapping("/info2/{productId}")
    public Object getProductInfo2(@PathVariable Integer productId){
        RestTemplate restTemplate = new RestTemplate();
        //通过负载均衡器获取到产品服务的url地址，负载均衡器默认是轮询的负载方式
        ServiceInstance productServer = loadBalancerClient.choose("PRODUCT-SERVER");
        String url = String.format("http://%s:%s", productServer.getHost(), productServer.getPort());
        String forObject = restTemplate.getForObject(url + "/findProduct/" + productId, String.class);
        Object jsonResult = JSON.parse(forObject);
        log.info(forObject);
        return forObject;
    }

    @Autowired
    private ProductService productService;

    /**
     * @description 采用@Feign的方式请求实现服务之间的通信（推荐使用，是比较好的方式，自动集成了ribbon 负载均衡）
     * @author junly
     * @date 2018/12/16
     */
    @RequestMapping("/info3")
    public Object getProductInfo3(@RequestBody JSONObject json){
        log.info(JSON.toJSONString(json));
        String products = productService.findAllByProductStatus(json);
        log.info(products);
        return products;
    }
}
