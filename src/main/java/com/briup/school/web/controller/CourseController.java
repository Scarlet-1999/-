package com.briup.school.web.controller;


import com.briup.school.bean.Course;
import com.briup.school.service.ICourseService;
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
@RequestMapping("/course")
@Api(description = "课程管理")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping("/selectAll")
    @ApiOperation(value = "查询所有课程")
    public Message selectAll(){
        List<Course> courses=courseService.selectAll();
        return MessageUtil.success(courses);

    }
    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除课程")
    @ApiImplicitParam(name= "id",value="课程id",paramType = "query" ,
            dataType = "int",required = true)
    public  Message deleteById(int id){
         courseService.deleteById(id);
            return  MessageUtil.success("删除成功");
    }
    @PostMapping("/addCourse")
    @ApiOperation(value="添加课程")
    public Message addCourse(Course course){
        courseService.saveOrUpdate(course);
        return    MessageUtil.success("添加成功");
    }
    @PostMapping("/updateCourse")
    @ApiOperation(value="修改课程")
    public Message updateCourse(Course course){
        courseService.saveOrUpdate(course);
        return MessageUtil.success("修改成功");
    }

    @GetMapping("/seletByKW")
    public Message  selectsomeing (String key ,String word){

        List<Course> courses=courseService.selectByKW(key,word);
        return MessageUtil.success(courses);
    }

    @GetMapping("/deleteBatch")
public  Message deleteBatch(int[] ids){//也可以用String类型

        for (int id : ids)
        courseService.deleteById(id);
        return MessageUtil.success("删除成功");
}
}
