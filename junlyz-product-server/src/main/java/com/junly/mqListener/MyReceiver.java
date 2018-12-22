package com.junly.mqListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyReceiver
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/20 0020 22:13
 * @Version 1.0
 **/
@Component
public class MyReceiver {
    private static final Logger log = LoggerFactory.getLogger(MyReceiver.class);

    @RabbitListener(queues = "myQueue")
    public void process(String message){
        System.out.println("===============");
        log.info("打印消息：" + message);
    }

    /**
     * @description 自动创建队列
     * @author junly
     * @date 2018/12/20
     */
    @RabbitListener(queuesToDeclare = @Queue("myQueue2"))
    public void process2(String message){
        System.out.println("===============");
        log.info("打印消息：" + message);
    }

    /*
     * @description 自动创建队列 和自动绑定交换
     * @author junly
     * @date 2018/12/20
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue3"),
            exchange = @Exchange("myExchange")
    ))
    public void process3(String message){
        System.out.println("===============");
        log.info("process3 打印消息：" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue3"),
            exchange = @Exchange("myExchange")
    ))
    public void process4(String message){
        System.out.println("===============");
        log.info("process4 打印消息：" + message);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitQueue"),
            key = "fruit",
            exchange = @Exchange("orderExchange")
    ))
    public void fruitProcess(String message){
        System.out.println("===============");
        log.info("打印消息 fruitProcess：" + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("riceQueue"),
            key = "rice",
            exchange = @Exchange("orderExchange")
    ))
    public void riceProcess(String message){
        System.out.println("===============");
        log.info("打印消息 riceProcess：" + message);
    }

}
