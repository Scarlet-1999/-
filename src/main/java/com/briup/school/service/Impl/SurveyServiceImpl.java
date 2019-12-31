package com.briup.school.service.Impl;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.SurveyMapper;
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

    @Autowired
    private SurveyMapper surveyMapper;




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

    @Override
    public SurveyEX FindById(int id) throws RuntimeException {
        return surveyEXMapper.FindById(id);

    }

    @Override
    public void SaveOrUpdate(Survey survey) throws RuntimeException {
        //id不为空为增加操作
        if (survey.getId()!=null||"".equals(survey.getId())){
            //不为空开始判断外键存在问题(这里的逻辑还在写不要动！！！)
            boolean flag=true;
            if(flag){

                surveyMapper.updateByPrimaryKey(survey);
            }


        }
        else {
            surveyMapper.insert(survey);
        }
    }

}
