package com.develop.mq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: developer
 * @date: 2018/8/28 20:10
 * @description:topic模式生产者
 */

@Component
@Slf4j
public class TopicProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {

        rabbitTemplate.convertAndSend("rabbtimq.topic.routingkey", msg);
        log.info("topic模式发送消息：{}", msg);
        log.info("topic模式消息发送成功");
    }

}
