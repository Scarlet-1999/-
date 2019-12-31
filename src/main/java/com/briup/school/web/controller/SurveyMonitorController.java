package com.briup.school.web.controller;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.service.IQuestionnaireService;
import com.briup.school.service.ISurveyMonitorService;
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
@RequestMapping("/surveyMonitor")
@Api(description = "课调监控")
public class SurveyMonitorController {
@Autowired
    private ISurveyMonitorService surveyMonitorService;
    @Autowired
private   IQuestionnaireService iQuestionnaireService;
    @Autowired
   private ISurveyService iSurveyService;

@GetMapping("selectAll")
@ApiOperation(value = "查询相关的课调信息")
    public Message selectAll() {

        List<SurveyEX> surveyEXES =surveyMonitorService.selectAll();
        return MessageUtil.success(surveyEXES);

    }
    @GetMapping("changeStatusOn")
    @ApiOperation(value = "开启课调")
public Message changeStatusOn(int id){
 surveyMonitorService.changeStatusOn(id);
    return MessageUtil.success("更改成功");
}
    @GetMapping("changeStatusOff")
    @ApiOperation(value = "结束课调")
    public Message changeStatusOff(int id){
        surveyMonitorService.changeStatusOn(id);
        return MessageUtil.success("更改成功");
    }
    @GetMapping("/FindByCondition")
    @ApiOperation(value = "根据条件查询课调信息")
    public Message FindByCondition(String key) {
        List<Questionnaire> l=iQuestionnaireService.selectByName(key);

        List<SurveyEX> list=iSurveyService.FindByCondition(l);
        System.out.println(123);
        System.out.println(list);
        return MessageUtil.success(list);

    }

}
