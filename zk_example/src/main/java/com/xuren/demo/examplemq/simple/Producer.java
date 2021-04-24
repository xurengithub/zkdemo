package com.xuren.demo.examplemq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("49.232.215.156");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection("生产者");
            channel = connection.createChannel();
            String queueName = "q1";
            /*
            队列名，持久化，排他，自动删除，参数
             */
            channel.queueDeclare(queueName, false, false, false, null);
            String message = "hello";
            /**
             * 路由器，队列名，是否持久化，字节数据
             */
            channel.basicPublish("", queueName, null, message.getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
