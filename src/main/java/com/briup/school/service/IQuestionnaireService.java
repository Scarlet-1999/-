package com.briup.school.service;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.QuestionnaireExample;

import java.util.List;

public interface IQuestionnaireService {
List<Questionnaire> findAll() throws RuntimeException;
    List<Questionnaire> selectByName(String name,String description) throws  RuntimeException;
}
