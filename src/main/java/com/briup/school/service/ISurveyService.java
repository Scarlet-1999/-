package com.briup.school.service;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyService {
    List<SurveyEX> FindAll() throws RuntimeException;

    List<SurveyEX> FindByCondition(List<Questionnaire> list) throws RuntimeException;

    SurveyEX FindById(int id) throws RuntimeException;

    char SaveOrUpdate(Survey survey) throws RuntimeException;

    void DeleteById(int id) throws RuntimeException;
}
