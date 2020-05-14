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
 * @date Date : 2020年05月13日 15:08
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 队列名
     */

    @Bean
    public Queue DirectQueue()
    {
        /**
         * durable：是否持久化，默认为false,持久化队列会被存储在磁盘上，当消息代理重启时任然存在
         * exclusive:默认也为false,只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
         * autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
         * new Queue(name,durable,exclusive,autoDelete)
         */
        return new Queue("DirectQueue",true);
    }

    @Bean
    DirectExchange TestDirectExchange()
    {
        return new DirectExchange("DirectExchange",true,false);
    }

    @Bean
    Binding bindingExchange()
    {
        return BindingBuilder.bind(DirectQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

}
