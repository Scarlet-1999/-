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

    @Override
    public List<Teacher> findByNameGenden(String key, String word) {
        if ((key==null||"".equals(key))&&(word==null||"".equals(word))){
            TeacherExample example=new TeacherExample();
            List<Teacher> list=teacherMapper.selectByExample(example);
            return list;
        }if((key==null||"".equals(key))&&!(word==null||"".equals(word))){
            TeacherExample example=new TeacherExample();
            example.createCriteria().andGenderEqualTo(word);
            example.or().andNameEqualTo(word);
            return teacherMapper.selectByExample(example);

        }if (key=="name"){
            TeacherExample example=new TeacherExample();

            example.createCriteria().andNameEqualTo(word);
            return teacherMapper.selectByExample(example);

        }if (key=="gender"){
            TeacherExample example=new TeacherExample();
            example.createCriteria().andGenderEqualTo(word);

            return teacherMapper.selectByExample(example);

        }

        return null;
    }
}
