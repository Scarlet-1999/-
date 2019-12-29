package com.briup.school.web.controller;

import com.briup.school.bean.Questionnaire;
import com.briup.school.service.IQuestionnaireService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
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
    @GetMapping
    public  Message selectAll(){
        List<Questionnaire> questionnaires=questionnaireService.findAll();
        return MessageUtil.success(questionnaires);
    }
}
