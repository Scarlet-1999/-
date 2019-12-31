package com.briup.school.web.controller;

import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.service.IAllSurveyService;
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
@RequestMapping("/Allsurvey")
@Api(description = "全部课调管理")
public class AllSurveyController {
    @Autowired
    private IAllSurveyService allSurveyService;


    @GetMapping("/findall")
    @ApiOperation("查询所有")
    public Message findall(){
        List<SurveyEX> list=allSurveyService.findall();

        return MessageUtil.success(list);
    }
}
