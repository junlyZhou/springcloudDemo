package com.junly.controller;

import com.alibaba.fastjson.JSONObject;
import com.junly.enume.ResponseEnume;
import com.junly.pojo.Product;
import com.junly.response.ResultVo;
import com.junly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/15 0015 15:35
 * @Version 1.0
 **/
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/hello")
    //@GetMapping("/hello")
    public String testHello(){
        return "hello";
    }

    /**
     * @description 通过产品状态查询产品列表，采用rest的方式传递参数
     * @author junly
     * @date 2018/12/16
     * @param productStatus
     * @return java.lang.Object
     */
    @RequestMapping("/findProduct/{productStatus}")
    public ResultVo<List<Product>> findAllByProductStatus(@PathVariable Integer productStatus){
        ResultVo<List<Product>> resultVo = new ResultVo<>();
        List<Product> allByProduct = productService.findAllByProductStatus(productStatus);
        resultVo.setData(allByProduct);
        resultVo.setCode(ResponseEnume.SUCCESS.getCode());
        resultVo.setMsg(ResponseEnume.SUCCESS.getDesc());
        return resultVo;
    }

    @RequestMapping("/findProduct")
    public ResultVo<List<Product>> findAllByProductStatus2(@RequestBody JSONObject json){
        ResultVo<List<Product>> resultVo = new ResultVo<>();
        Integer productStatus = json.getInteger("productStatus");
        List<Product> allByProduct = productService.findAllByProductStatus(productStatus);
        resultVo.setData(allByProduct);
        resultVo.setCode(ResponseEnume.SUCCESS.getCode());
        resultVo.setMsg(ResponseEnume.SUCCESS.getDesc());
        return resultVo;
    }

}
