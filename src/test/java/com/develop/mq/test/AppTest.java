package com.develop.mq.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.develop.mq.direct.DirectProducer;
import com.develop.mq.fanout.FanoutProducer;
import com.develop.mq.topic.TopicProducer;

/**
 * @author: developer
 * @date: 2018/8/28 20:26
 * @description:
 */

public class AppTest {

    @Test
    public void rabbitmqtopictest() throws InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring.xml");

        TopicProducer topicProducer = (TopicProducer) context.getBean("topicProducer");

        String sendMsg = "topic模式测试消息";
        topicProducer.sendMessage(sendMsg);

        //注意这里需要将线程暂停一下，不然容器销毁后，消费者就不能获取数据了，因为消费者destroy了
        //容器销毁太快，消费者来不及处理消息
        Thread.sleep(100);

    }


    @Test
    public void rabbitmqdirecttest() throws InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring.xml");

        DirectProducer directProducer = (DirectProducer) context.getBean("directProducer");

        String sendMsg = "direct模式测试消息";
        directProducer.sendMessage(sendMsg);

        //注意这里需要将线程暂停一下，不然容器销毁后，消费者就不能获取数据了，因为消费者destroy了
        //容器销毁太快，消费者来不及处理消息
        Thread.sleep(100);

    }


    @Test
    public void rabbitmqfanouttest() throws InterruptedException {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring.xml");

        FanoutProducer fanoutProducer = (FanoutProducer) context.getBean("fanoutProducer");

        String sendMsg = "direct模式测试消息";
        fanoutProducer.sendMessage(sendMsg);

        //注意这里需要将线程暂停一下，不然容器销毁后，消费者就不能获取数据了，因为消费者destroy了
        //容器销毁太快，消费者来不及处理消息
        Thread.sleep(100);

    }

}
