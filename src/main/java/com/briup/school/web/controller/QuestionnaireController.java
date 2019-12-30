package com.briup.school.web.controller;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.QqnEX;
import com.briup.school.bean.ex.QuestionEX;
import com.briup.school.service.IQuestionnaireService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @ApiImplicitParam(name = "id",value = "id",paramType = "query",dataType = "int",required = true)
    public Message findByid(int id){
        Questionnaire questionnaire=questionnaireService.findByid(id);

        return MessageUtil.success(questionnaire);
    }

    @GetMapping("/deletesome")
    @ApiOperation("批量删除")
    @ApiImplicitParam(name = "ids",value = "需要删除的id",paramType = "query",required = true,dataType = "int",allowMultiple = true)
    public Message deletesome(int[] ids){
        questionnaireService.deletesome(ids);
        return MessageUtil.success();
    }

    @PostMapping("/add")
    @ApiOperation("添加问卷")
    @ApiImplicitParam(name = "Qids",value = "需要添加的题目id",paramType = "query",dataType = "int",allowMultiple = true)
    public Message add(Questionnaire questionnaire,int [] Qids){
        questionnaireService.addOrUpdate(questionnaire,Qids);
        return MessageUtil.success();
    }


    @PostMapping("/update")
    @ApiOperation("修改问卷")
    @ApiImplicitParam(name = "Qids",value = "修改后的题目id",paramType = "query",dataType = "int",allowMultiple = true)
    public Message update(Questionnaire questionnaire,int[] Qids){
        questionnaireService.addOrUpdate(questionnaire,Qids);
        return MessageUtil.success();
    }

    @GetMapping("/seeQuestionByid")
    @ApiOperation("预览")
    @ApiImplicitParam(name = "id",value = "id",paramType = "query",dataType = "int",required = true)
    public Message seeQuestionByid(int id){
        List<QuestionEX> list=questionnaireService.seeQuestionByid(id);
        return MessageUtil.success(list);
    }


    @GetMapping("/selectByName")
    @ApiOperation("通过问卷名字查询")
    @ApiImplicitParam(name = "name",value = "姓名",paramType = "query",dataType = "String",required = true)
    public Message selectByName(String name){
        List<Questionnaire> list=questionnaireService.selectByName(name);
        return MessageUtil.success(list);
    }


    @GetMapping("/selectByQuId")
    @ApiOperation(value = "id查询所有问卷信息")
    public Message selectByQuId(int id){
        List<QqnEX> qqnEXES = questionnaireService.selectByQuId(id);
        return MessageUtil.success(qqnEXES);
    }
    @GetMapping("/deleteInManyTable")
    @ApiOperation(value = "按id多表删除")
    public Message deleteById(int id){
        questionnaireService.deleteInManyTable(id);

        return MessageUtil.success("删除成功");
    }


}
