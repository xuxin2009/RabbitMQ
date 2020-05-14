package com.sean.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : sean
 * @version V1.0
 * @Project: rabbitmq
 * @Package com.sean.rabbitmq.config
 * @Description: 这是一个使用RabbitMQ的订阅/发布模式的消息
 * @date Date : 2020年05月14日 18:53
 */
@Configuration
public class FanoutRabbitConfig {

    /**
     * 设置指定一个fanout类型的持久化保存，不自动删除的交换机
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange()
    {
        return new FanoutExchange("logs",true,false);
    }

    /**
     * 设置一个名子交log_one的持久化/排他/自动删除的队列
     * @return
     */
    @Bean
    Queue firstFanoutQueue()
    {
        return new Queue("logs_first",true,false,true);
    }

    /**
     * 设置一个名字为log_second的队列
     * @return
     */
    @Bean
    Queue secondFanoutQueue()
    {
        return new Queue("logs_second",true,false,true);
    }

    @Bean
    Binding bingExchangeToFirstQueue()
    {
        return BindingBuilder.bind(firstFanoutQueue()).to(fanoutExchange());
    }

    @Bean
    Binding bindExchangeToSecondQueue()
    {
        return BindingBuilder.bind(secondFanoutQueue()).to(fanoutExchange());
    }

}
