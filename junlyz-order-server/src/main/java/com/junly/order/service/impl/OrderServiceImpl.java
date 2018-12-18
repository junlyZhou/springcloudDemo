package com.junly.order.service.impl;

import com.junly.order.mapper.OrderMapper;
import com.junly.order.pojo.Order;
import com.junly.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/16 0016 18:26
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> queryOrderByStatus(Integer orderStatus) {
        return orderMapper.queryOrderByStatus(orderStatus);
    }
}
