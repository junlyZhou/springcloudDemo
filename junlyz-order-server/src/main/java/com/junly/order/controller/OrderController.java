package com.junly.order.controller;

import com.alibaba.fastjson.JSONObject;
import com.junly.order.pojo.Order;
import com.junly.order.response.Response;
import com.junly.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 18:28
 * @Version 1.0
 **/
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public Response queryOrderByStatus(@RequestBody JSONObject json){
        Integer orderStatus = json.getInteger("orderStatus");
        System.out.println(orderStatus);
        List<Order> orders = orderService.queryOrderByStatus(orderStatus);
        Response<List<Order>> response = new Response<>();
        response.setData(orders);
        return response;
    }
}
