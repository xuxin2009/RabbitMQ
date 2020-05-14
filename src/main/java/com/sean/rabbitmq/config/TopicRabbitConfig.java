package com.sean.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : sean
 * @version V1.0
 * @Project: rabbitmq
 * @Package com.sean.rabbitmq.config
 * @Description: TODO
 * @date Date : 2020年05月13日 22:18
 */
@Configuration
public class TopicRabbitConfig {

    /**
     * 绑定键
     */
    public  final static String man = "topic.man";
    public final static  String woman = "topic.woman";

    @Bean
    public Queue firstQueue()
    {
        return new Queue(TopicRabbitConfig.man);
    }

    @Bean
    public Queue secondQueue()
    {
        return new Queue(TopicRabbitConfig.woman);
    }
    @Bean
    TopicExchange  exchange()
    {
        return new TopicExchange("topicExchange");
    }


    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }


    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

}
