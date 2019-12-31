package com.briup.school.service;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyService {
    List<SurveyEX> FindAll() throws RuntimeException;

    List<SurveyEX> FindByCondition(List<Questionnaire> list) throws RuntimeException;
}
