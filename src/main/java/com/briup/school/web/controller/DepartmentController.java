package com.briup.school.web.controller;

import com.briup.school.bean.Department;
import com.briup.school.service.IDepartmentService;
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
@Api(description = "年级管理")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @PostMapping("/saveorupdate")
    @ApiOperation(value = "添加年级或者更新年级")
    public Message SaveOrUpdate(Department department){
        iDepartmentService.SaveOrUpdate(department);
        System.out.println(department.getId());
        System.out.println(department.getName());
        System.out.println(department.getDescription());
        return MessageUtil.success();
    }

    @GetMapping("/findall")
    @ApiOperation(value = "查询所有年级")
    public Message FindAll(){
        List<Department> list=iDepartmentService.FindAll();
        return MessageUtil.success(list);
    }

    @GetMapping("/findbyid")
    @ApiOperation(value = "通过id查找年级")
    public Message Find(int id){
        return MessageUtil.success(iDepartmentService.Find(id));
    }


    @GetMapping("/deletebyid")
    @ApiOperation(value = "通过id删除年级")
    public Message Delete(int id){
        iDepartmentService.Delete(id);
        return MessageUtil.success();
    }


    @GetMapping("/findbyconditon")
    @ApiOperation(value = "通过关键字查找年级，关键字可以是年级的所有属性")
    public Message FindByCondition(String key){
        List<Department> list=iDepartmentService.FindByCondition(key);
        return MessageUtil.success(list);


    }


    @GetMapping("/deletebatch")
    @ApiOperation(value = "批量删除")
    public Message deleteBatch(int[] id){
        for (int i:id){
            iDepartmentService.Delete(i);
            System.out.println(i);
        }
        return MessageUtil.success();
    }



}
