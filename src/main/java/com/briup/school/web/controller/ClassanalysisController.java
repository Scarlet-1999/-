package com.briup.school.web.controller;

import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.service.IClassAnalysisService;
import com.briup.school.service.IClassService;
import com.briup.school.service.ISurveyService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "分析")
public class ClassanalysisController {
    @Autowired
    private IClassAnalysisService classAnalysisService;
    @Autowired
    private ISurveyService surveyService;
   // @GetMapping("/seleById")
    public Message selectById(int id){

        return MessageUtil.success(classAnalysisService.selectById(id));
    }
    //@GetMapping("/selectAll")
   public  Message selectAll(){
        List<SurveyEX> surveys=surveyService.FindAll();
        return MessageUtil.success();

    }
   //@GetMapping("/selectById1")
    public  Message selectById1(int id){
       SurveyEX survey=surveyService.FindById(id);
      return MessageUtil.success(survey);
    }
    //@GetMapping("/selectByName")
    public Message selectByName(String name){
        return MessageUtil.success(classAnalysisService.selectByName(name));

    }
    @GetMapping("全部查询")
    public  Message  selectNameAndAverage() {
        return MessageUtil.success(classAnalysisService.selectNameAndAverage());
    }
}
