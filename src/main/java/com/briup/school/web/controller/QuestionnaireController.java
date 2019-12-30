package com.briup.school.web.controller;

import com.briup.school.bean.Questionnaire;
import com.briup.school.service.IQuestionnaireService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Questionnaire")
@Api(description = "问卷管理")
public class QuestionnaireController {
    @Autowired
    private IQuestionnaireService questionnaireService;

    @GetMapping("/selectAll")
    @ApiOperation("显示所有问卷")
    public  Message selectAll(){
        List<Questionnaire> questionnaires=questionnaireService.findAll();
        return MessageUtil.success(questionnaires);
    }


    @GetMapping("/deleteByid")
    @ApiOperation("通过id删除")
    @ApiImplicitParam(name = "id",value = "id",paramType = "query",dataType = "int",required = true)
    public Message deleteByid(int id){
        questionnaireService.deleteByid(id);
        return MessageUtil.success();
    }

    @GetMapping("/findByid")
    @ApiOperation("通过id查询")
    public Message findByid(int id){
        Questionnaire questionnaire=questionnaireService.findByid(id);

        return MessageUtil.success(questionnaire);
    }

    @GetMapping("/deletesome")
    @ApiOperation("批量删除")

    public Message deletesome(int[] ids){
        questionnaireService.deletesome(ids);
        return MessageUtil.success();
    }


}
