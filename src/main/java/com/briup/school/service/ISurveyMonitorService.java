package com.briup.school.service;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyMonitorService {

List<SurveyEX> selectAll();
   String changeStatusOn(int id) throws RuntimeException ;
    String changeStatusOff(int id);
    List<SurveyEX> FindByCondition(List<Questionnaire> list);

}
