package com.develop.mq.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: developer
 * @date: 2018/8/29 20:57
 * @description: direct模式生产者
 */

@Component
@Slf4j
public class DirectProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {

        //注意这里的routingkey，需要根据具体配置进行改变
        rabbitTemplate.convertAndSend("rabbtimq_direct_key1", msg + "direct1");
        rabbitTemplate.convertAndSend("rabbtimq_direct_key2", msg + "direct2");
        log.info("向两个队列发送消息");
        log.info("direct模式发送消息：{}", msg);
        log.info("direct模式消息发送成功");

    }
}
