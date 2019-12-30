package com.briup.school.mapper.ex;

import com.briup.school.bean.Question;
import com.briup.school.bean.ex.QuestionEX;

import java.util.List;

public interface QuestionEXMapper {

    List<QuestionEX> selectAll() throws RuntimeException;

    List<QuestionEX> selectByName(String word) throws RuntimeException;

    void insert(QuestionEX questionEX) throws RuntimeException;

    Question selectLastOne() throws RuntimeException;
}
