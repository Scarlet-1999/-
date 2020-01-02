package com.briup.school.web.controller;

import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.service.IAllSurveyService;
import com.briup.school.service.ISurveyCheckService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @Autowired
    private ISurveyCheckService surveyCheckService;


    @GetMapping("/findall")
    @ApiOperation("查询所有")
    public Message findall(){
        List<SurveyEX> list=allSurveyService.findall();

        return MessageUtil.success(list);
    }

    @ApiOperation("通过班级名字查询")
    @GetMapping("/findByClassName")
    public Message findByClassName(String Classname){
        List<SurveyEX> list =allSurveyService.findByClassName(Classname);
        return MessageUtil.success(list);
    }


    @GetMapping("/findByAll")
    @ApiOperation("条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Dname",value = "年级名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "Clname",value = "班级名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "Coname",value = "课程名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "Qname",value = "问卷名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "word",value = "关键字",paramType = "query",dataType = "String")
    })
    public Message findByAll(String Dname,String Clname,String Coname,String Qname,String word){
        List<SurveyEX> list=allSurveyService.findByAll(Dname,Clname,Coname,Qname,word);
        return MessageUtil.success(list);
    }



    @GetMapping("/seeById")
    @ApiOperation("预览")
    public Message seeById(int id){
        return MessageUtil.success(allSurveyService.seeById(id));
    }

}
