package com.briup.school.web.controller;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.service.IQuestionnaireService;
import com.briup.school.service.ISurveyCheckService;
import com.briup.school.service.ISurveyService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/surveyCheck")
@Api(description = "课调审核")
public class SurveyCheckController {

    @Autowired
    private ISurveyService iSurveyService;
    @GetMapping("/selectAll")
    @ApiOperation(value = "查看所有课调")
    public Message FindAll(){
        List<SurveyEX> list=iSurveyService.FindAll();
        return MessageUtil.success(list);
    }

    @Autowired
    private IQuestionnaireService iQuestionnaireService;
    @GetMapping("/searchByName")
    @ApiOperation(value = "根据问卷名搜索")
    public Message searchByName(String key){
        List<Questionnaire> questionnaires=iQuestionnaireService.selectByName(key);
        List<SurveyEX> surveyEXs=iSurveyService.FindByCondition(questionnaires);
        return MessageUtil.success(surveyEXs);
    }

    @Autowired
    private ISurveyCheckService iSurveyCheckService;

    @GetMapping("check")
    @ApiOperation(value = "审核")
    public Message check(int id){
        return MessageUtil.success(iSurveyCheckService.check(id));
    }
}
