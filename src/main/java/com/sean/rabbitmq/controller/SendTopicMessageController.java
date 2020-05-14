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
 * @Description: TODO
 * @date Date : 2020年05月13日 15:25
 */

@RestController
public class SendTopicMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("sendTopicMessage1")
    public String sendDirectMessage1()
    {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: Man";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, String> map = new HashMap<>();

        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        rabbitTemplate.convertAndSend("topicExchange","topic.man",map);
        return "OK";
    }
    @GetMapping("sendTopicMessage2")
    public String sendDirectMessage2()
    {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "message: woman";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, String> map = new HashMap<>();

        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);

        rabbitTemplate.convertAndSend("topicExchange","topic.woman",map);
        return "OK";
    }
}
