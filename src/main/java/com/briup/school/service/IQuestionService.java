package com.briup.school.service;

import com.briup.school.bean.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> selectAll() throws  RuntimeException;
}
