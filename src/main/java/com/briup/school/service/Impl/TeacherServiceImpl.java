package com.briup.school.service.Impl;

import com.briup.school.bean.Teacher;
import com.briup.school.bean.TeacherExample;
import com.briup.school.mapper.TeacherMapper;
import com.briup.school.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public List<Teacher> findAll() {

        TeacherExample example=new TeacherExample();
        List<Teacher> list=teacherMapper.selectByExample(example);
        return list;
    }
}
