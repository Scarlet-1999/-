package com.briup.school.web.controller;

import com.briup.school.service.IClassService;
import com.briup.school.service.IQuestionService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "题库管理")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有题")
    public Message selectAll(){
        return MessageUtil.success(questionService.selectAll());
    }
}
