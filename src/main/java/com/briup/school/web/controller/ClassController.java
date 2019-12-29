package com.briup.school.web.controller;

import com.briup.school.bean.Class;
import com.briup.school.bean.ex.ClassEx;
import com.briup.school.service.IClassService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "class")
@Api(description = "班级管理")
public class ClassController {

    @Autowired
    private IClassService classService;

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询全部班级")
    public Message selectAll(){
        List<ClassEx> classExes = classService.selectAll();
        return MessageUtil.success(classExes);
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "根据id查询班级")
    public Message selectById(int id){
        return MessageUtil.success(classService.selectById(id));
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除班级")
    public Message deleteById(int id){
        classService.deleteById(id);
        return MessageUtil.success();
    }



    @PostMapping("/add")
    @ApiOperation(value = "添加班级")
    public Message add(Class cla) {
        classService.addOrUpadate(cla);
        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新班级")
    public Message deleteById(Class cla){
        classService.addOrUpadate(cla);
        return MessageUtil.success();
    }

    @GetMapping("/search")
    @ApiOperation(value = "更新班级")
    public Message search(String key,String word){
        return MessageUtil.success(classService.search(key,word));
    }










}
