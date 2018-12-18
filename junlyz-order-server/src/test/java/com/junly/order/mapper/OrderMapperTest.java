package com.junly.order.mapper;

import com.junly.order.pojo.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/**
 * @description  测试类
 * @author junly
 * @date 2018/12/16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void queryOrderByGenderTest(){
        List<Order> order = orderMapper.queryOrderByStatus(1);
        Assert.assertTrue(order.size()>0);
    }

}