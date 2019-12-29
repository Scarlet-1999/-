package com.briup.school.web.controller;


import com.briup.school.bean.Teacher;
import com.briup.school.service.ITeacherService;
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
@RequestMapping("/teacher")
@Api(description = "教师管理器")
public class TeacherController  {
    @Autowired
    private ITeacherService teacherService;

    @GetMapping("/findAll")
    @ApiOperation("查询所有")
    public Message findAll(){
        List<Teacher>list=teacherService.findAll();

        return MessageUtil.success(list);
    }



}
