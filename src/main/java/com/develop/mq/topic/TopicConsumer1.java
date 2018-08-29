package com.develop.mq.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: developer
 * @date: 2018/8/27 23:19
 * @description:topic模式消费者
 */

@Component
@Slf4j
public class TopicConsumer1 implements ChannelAwareMessageListener {


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        String msg = new String(message.getBody(), "utf-8");
        System.out.println("topic recv[1] msg:" + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        log.info("topic模式消息消费成功 recv[1]");

    }
}