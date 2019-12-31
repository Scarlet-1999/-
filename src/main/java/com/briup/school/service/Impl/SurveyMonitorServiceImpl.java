package com.briup.school.service.Impl;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.Survey;
import com.briup.school.bean.SurveyExample;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.mapper.ex.SurveyEXMapper;
import com.briup.school.service.ISurveyMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyMonitorServiceImpl implements ISurveyMonitorService {
    @Autowired
    private SurveyEXMapper surveyEXMapper;
    @Autowired
   private SurveyMapper surveyMapper;
    @Override
    public List<SurveyEX> selectAll() {
        List<SurveyEX> surveyEXES=surveyEXMapper.FindAll();



        return surveyEXES;
    }

    @Override
    public void changeStatusOn(int id) {
        SurveyExample example=new SurveyExample();
        example.createCriteria().andIdEqualTo(id);
        Survey survey= new Survey();
      int  code= (int) Math.round((Math.random()+1) * 1000);
        survey.setCode(code);
        survey.setStatus("开启");
        surveyMapper.updateByExampleSelective(survey,example);
    }

    @Override
    public void changeStatusOff(int id) {
        SurveyExample example=new SurveyExample();
        example.createCriteria().andIdEqualTo(id);
        Survey survey= new Survey();
        survey.setCode(id);
        survey.setStatus("结束");
        surveyMapper.updateByExampleSelective(survey,example);
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
