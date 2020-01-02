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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SurveyMonitorServiceImpl implements ISurveyMonitorService {
    @Autowired
    private SurveyEXMapper surveyEXMapper;
    @Autowired
   private SurveyMapper surveyMapper;
    @Override
    public List<SurveyEX> selectAll() {

        List<SurveyEX> surveyEXES=surveyEXMapper.lhjFindAll();
        return surveyEXES;
    }

    @Override
    public void changeStatusOn(int id) {
        String statu = surveyMapper.selectByPrimaryKey(id).getStatus();
        if("未开启".equals(statu)){
        SurveyExample example=new SurveyExample();
        example.createCriteria().andIdEqualTo(id);
        Survey survey= new Survey();

      int  code= (int) Math.round((Math.random()+1) * 1000);
        survey.setCode(code);
        survey.setStatus("开启");
        surveyMapper.updateByExampleSelective(survey,example); }
        else {

            throw new RuntimeException("该课调不符合开启条件") ;

        }
    }

    @Override
    public void changeStatusOff(int id) {
        String statu = surveyMapper.selectByPrimaryKey(id).getStatus();
        if("开启".equals(statu)){
        SurveyExample example=new SurveyExample();
        example.createCriteria().andIdEqualTo(id);
        Survey survey= new Survey();
//            int  code= (int) Math.round((Math.random()+1) * 1000);
//        survey.setCode(code);
        survey.setStatus("未审核");
        surveyMapper.updateByExampleSelective(survey,example);
       // return "课调结束成功，已经进入待审核阶段";
        }else {          throw new RuntimeException("该课调不符合开启条件") ;
      //  return "该课调不符合结束条件";
            }
    }

    @Override
    public List<SurveyEX> FindByCondition(List<Questionnaire> list) throws RuntimeException {
        List<SurveyEX> l = new ArrayList<SurveyEX>();
        for(Questionnaire q:list){
            l.addAll(surveyEXMapper.lhjFindByCondition(q.getId()));
        }
        return l;


    }
}
