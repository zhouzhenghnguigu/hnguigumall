package com.hnguigu.rocketmq.simple;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class MyProducer {

    public static void main(String[] args) {
        try {
            // 实例化消息生产者Producer
            DefaultMQProducer producer = new DefaultMQProducer("hnguigu-productGroup");
            // 设置NameServer的地址
            producer.setNamesrvAddr("192.168.199.133:9876");
            // 启动Producer实例
            producer.start();

            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message("myTopic", "TagA", "Hello RocketMQ".getBytes());
            // 发送消息到一个Broker
            SendResult sendResult = producer.send(msg, 10000);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);
            // 如果不再发送消息，关闭Producer实例。
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
