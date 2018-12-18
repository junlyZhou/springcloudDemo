package com.junly.order.service;

import com.junly.order.pojo.Order;

import java.util.List;

public interface OrderService {

    public List<Order> queryOrderByStatus(Integer orderStatus);
}
