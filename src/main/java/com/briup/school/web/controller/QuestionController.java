package com.briup.school.web.controller;

import com.briup.school.bean.Options;
import com.briup.school.bean.Question;
import com.briup.school.bean.ex.QuestionEX;
import com.briup.school.service.IClassService;
import com.briup.school.service.IQuestionService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import com.sun.xml.internal.ws.api.model.MEP;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@Api(description = "题库管理")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有题")
    public Message selectAll(){
        return MessageUtil.success(questionService.selectAll());
    }

    @GetMapping("/deleteBatch")
    @ApiOperation(value = "批量删除")
    public Message deleteBatch(int[] ids){
        for (int id:ids){
            questionService.deleteById(id);
        }
        return MessageUtil.success();
    }

    @GetMapping("/search")
    @ApiOperation(value = "搜索")
    public Message search(String word){
        return MessageUtil.success(questionService.selectByName(word));
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加题目")
    public Message add(Question question,@RequestBody List<Options> options){
        questionService.addOrUpdate(question,options);
        System.out.println(question.getId());
        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改题目")
    public Message update(Question question,@RequestBody List<Options> options){
        questionService.addOrUpdate(question,options);
        return MessageUtil.success();
    }
}