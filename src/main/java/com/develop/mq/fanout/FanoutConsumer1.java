package com.develop.mq.fanout;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: developer
 * @date: 2018/8/29 20:54
 * @description: fanout模式消费者
 */
@Component
@Slf4j
public class FanoutConsumer1 implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {

        String msg = new String(message.getBody(), "utf-8");

        System.out.println("direct recv[1] msg:" + msg);

        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        log.info("direct模式消息消费成功!");

    }
}
