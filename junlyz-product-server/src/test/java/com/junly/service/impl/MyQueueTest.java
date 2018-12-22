package com.junly.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ClassName MyQueueTest
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/20 0020 22:19
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyQueueTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

/**
 * @description 测试mq发送消息
 * @author junly
 * @date 2018/12/20
 */
    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue", "now date:"+new Date());
    }

    @Test
    public void orderSend(){
        amqpTemplate.convertAndSend("orderExchange", "fruit" ,"fruit now date:"+new Date());
    }

    @Test
    public void orderSend2(){
        amqpTemplate.convertAndSend("orderExchange","rice","fruit now date:"+new Date());
    }

    @Test
    public void orderSend3(){
        amqpTemplate.convertAndSend("myExchange","","fruit now date:"+new Date());
    }
}
