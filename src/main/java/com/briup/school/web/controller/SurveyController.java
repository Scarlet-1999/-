package com.briup.school.web.controller;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.service.IQuestionnaireService;
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
@RequestMapping("/survey")
@Api(description = "课调管理")
public class SurveyController {

    @Autowired
    private ISurveyService iSurveyService;

    @Autowired
    private IQuestionnaireService iQuestionnaireService;

    @GetMapping("/findall")
    @ApiOperation(value = "查看所有课调")
    public Message FindAll(){
        List<SurveyEX> list=iSurveyService.FindAll();
//        for(SurveyEX s:list){
//            System.out.println(s.getaClass().getName());
//            System.out.println(s.getCourse().getName());
//        }
        return MessageUtil.success(list);
    }


    @GetMapping("/findbycondition")
    @ApiOperation(value = "通过问卷名字条件查找")
    public Message FindByCondition(String key){
        List<Questionnaire> l=iQuestionnaireService.selectByName(key);

        List<SurveyEX> list=iSurveyService.FindByCondition(l);
        System.out.println(123);
        System.out.println(list);
        return MessageUtil.success(list);
    }



}
