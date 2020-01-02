package com.briup.school.service;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyMonitorService {

List<SurveyEX> selectAll();
   void changeStatusOn(int id) throws RuntimeException ;
    void changeStatusOff(int id);
    List<SurveyEX> FindByCondition(List<Questionnaire> list);

}
