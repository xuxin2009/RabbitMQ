package com.sean.rabbitmq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : sean
 * @version V1.0
 * @Project: rabbitmq
 * @Package com.sean.rabbitmq.controller
 * @Description: TODO
 * @date Date : 2020年05月14日 17:57
 */

@RestController
public class userController {


    /**
     * it is just a test for git change
     * @param userId
     * @return
     */
    @GetMapping("/id")
    public String getUserbyId(@PathVariable("userId")String userId)
    {
        return "user";
    }
    /**
     * just a test infor
     */

}
