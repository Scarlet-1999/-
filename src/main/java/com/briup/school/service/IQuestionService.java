package com.briup.school.service;

import com.briup.school.bean.Options;
import com.briup.school.bean.Question;
import com.briup.school.bean.ex.QuestionEX;

import java.util.List;

public interface IQuestionService {
    List<QuestionEX> selectAll() throws  RuntimeException;

    void addOrUpdate(Question question,List<Options> options) throws RuntimeException;

    void deleteById(int id) throws RuntimeException;

    List<QuestionEX> selectByName(String word) throws  RuntimeException;
}
