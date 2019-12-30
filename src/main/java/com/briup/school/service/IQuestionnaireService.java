package com.briup.school.service;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.QuestionnaireExample;
import com.briup.school.bean.ex.QqnEX;
import com.briup.school.bean.ex.QuestionEX;

import java.util.List;

public interface IQuestionnaireService {
    List<Questionnaire> findAll() throws RuntimeException;
    Questionnaire findByid(int id) throws RuntimeException;
    List<Questionnaire> selectByName(String name) throws  RuntimeException;
    void deleteByid(int id) throws RuntimeException;
    void deletesome(int[] ids) throws  RuntimeException;

    void addOrUpdate(Questionnaire questionnaire,int[] Qids) throws RuntimeException;

    List<QuestionEX> seeQuestionByid(int id) throws RuntimeException;
    List<QqnEX> selectByQuId(int id);
    void  deleteInManyTable(int id);

}
