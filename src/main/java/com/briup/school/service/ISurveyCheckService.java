package com.briup.school.service;

import com.briup.school.bean.Answer;
import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyCheckService {
    List<SurveyEX> selectAll() throws RuntimeException;

    SurveyEX showDetail(int id) throws RuntimeException;

    void updateAnswer(Answer answer) throws  RuntimeException;
    void deleteAnswer(int id) throws  RuntimeException;

    void check(int key,int id)throws RuntimeException;




}
