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
        if (word==null){
            word="";
        }
        if ((key==null||"".equals(key))&&(word==null||"".equals(word))){
            //都为空
            TeacherExample example=new TeacherExample();
            List<Teacher> list=teacherMapper.selectByExample(example);
            return list;
        }if((key==null||"".equals(key))){
            //key为空

            word="%"+word+"%";
            TeacherExample example=new TeacherExample();
            example.createCriteria().andGenderLike(word);
            example.or().andNameLike(word);
            return teacherMapper.selectByExample(example);

        }if (key.equals("name")){
            //key=name
            word="%"+word+"%";
            TeacherExample example=new TeacherExample();

            example.createCriteria().andNameLike(word);

            return teacherMapper.selectByExample(example);

        }if ("gender".equals(key)){
            //key=gender
            word="%"+word+"%";
            TeacherExample example=new TeacherExample();
            example.createCriteria().andGenderLike(word);

            return teacherMapper.selectByExample(example);

        }

        return null;
    }

    @Override
    public void deleteByid(int id) throws RuntimeException {
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delelteByids(int[] ids) throws RuntimeException {

        for (int id:ids){
            teacherMapper.deleteByPrimaryKey(id);

        }


    }

    @Override
    public void addOrUpdate(Teacher teacher) throws RuntimeException {
        if (teacher==null){
            throw new RuntimeException("参数为空");
        }
        if(teacher.getId()==null){
            teacherMapper.insert(teacher);
        }else {
            teacherMapper.updateByPrimaryKey(teacher);

        }

    }
}
