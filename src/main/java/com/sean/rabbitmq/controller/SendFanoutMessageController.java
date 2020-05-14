package com.sean.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : sean
 * @version V1.0
 * @Project: rabbitmq
 * @Package com.sean.rabbitmq.controller
 * @Description: 模拟发送消息给RabbitMQ队列，使用PostMan发送一次请求则往交换机中发送一条消息
 * @date Date : 2020年05月14日 19:04
 */

@RestController
public class SendFanoutMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("sendFanoutMessage")
    public String sendFanoutMessage()
    {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "this is a fanout message provider send ";
        String messageTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        Map<String, String> map = new HashMap(16);
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("messageTime",messageTime);

        rabbitTemplate.convertAndSend("logs","",map);

        return "OK";
    }
}
