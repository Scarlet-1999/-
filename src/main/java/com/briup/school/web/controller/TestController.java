package com.briup.school.web.controller;


import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public Message test(){
        return MessageUtil.success();
    }
}
