package com.briup.school.service.Impl;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.ex.SurveyEXMapper;
import com.briup.school.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyServiceImpl implements ISurveyService {

    @Autowired
    private SurveyEXMapper surveyEXMapper;




    @Override
    public List<SurveyEX> FindAll() throws RuntimeException {
        return surveyEXMapper.FindAll();
    }

    @Override
    public List<SurveyEX> FindByCondition(List<Questionnaire> list) throws RuntimeException {
        List<SurveyEX> l = new ArrayList<SurveyEX>();
        for(Questionnaire q:list){
            l.addAll(surveyEXMapper.FindByCondition(q.getId()));
        }
        return l;


    }

}
