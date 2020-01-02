package com.briup.school.service.Impl;

import com.briup.school.bean.Survey;
import com.briup.school.bean.SurveyExample;
import com.briup.school.bean.ex.ClassEX;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.mapper.ex.ClassEXMapper;
import com.briup.school.service.IClassAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassAnalysisServiceImpl implements IClassAnalysisService {
    @Autowired
    private ClassEXMapper classEXMapper;
    @Autowired
    private SurveyMapper  surveyMapper;
    @Override
    public List<ClassEX> selectById(int id) throws RuntimeException {
        return classEXMapper.selectById(id);
    }

    @Override
    public List<ClassEX> selectAll() throws RuntimeException {
       return classEXMapper.selectAll();
    }

    @Override
    public List<Survey> findAll() throws RuntimeException {
       SurveyExample surveyExample=new SurveyExample();
       List<Survey> surveys=surveyMapper.selectByExample(surveyExample);
       return surveys;
    }

    @Override
    public Survey selectById1(int id) throws RuntimeException {
        Survey survey=new Survey();

       return survey;
   }

    @Override
    public List<ClassEX> selectByName(String name) throws RuntimeException {
        return classEXMapper.selectByName(name);
    }

    @Override
    public List<ClassEX> selectAverage() throws RuntimeException {
        return classEXMapper.selectAverage();
    }

    @Override
    public List<ClassEX> selectNameAndAverage(String name) throws RuntimeException {
        return classEXMapper.selectNameAndAverage(name);
    }


}
