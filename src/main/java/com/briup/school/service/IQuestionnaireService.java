package com.briup.school.service;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.ex.QuestionEX;
import com.briup.school.bean.ex.QuestionnaireEX;

import java.util.List;

public interface IQuestionnaireService {
    List<Questionnaire> findAll() throws RuntimeException;
    Questionnaire findByid(int id) throws RuntimeException;
    List<Questionnaire> selectByName(String name) throws  RuntimeException;
    void deleteByid(int id) throws RuntimeException;
    void deletesome(int[] ids) throws  RuntimeException;

    void addOrUpdate(Questionnaire questionnaire,int[] Qids) throws RuntimeException;

    List<QuestionEX> seeQuestionByid(int id) throws RuntimeException;
    void  deleteInManyTable(int id);

    QuestionnaireEX selectById(int id)  throws RuntimeException;

}
