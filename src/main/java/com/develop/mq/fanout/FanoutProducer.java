package com.develop.mq.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: developer
 * @date: 2018/8/29 20:57
 * @description: fanout模式生产者
 */

@Component
@Slf4j
public class FanoutProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {

        //fanout模式不需要routingkey
        rabbitTemplate.convertAndSend(msg + "fanoutall");
        log.info("向两个队列发送消息");
        log.info("direct模式发送消息：{}", msg);
        log.info("direct模式消息发送成功");

    }
}
