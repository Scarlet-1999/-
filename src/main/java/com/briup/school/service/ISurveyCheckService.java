package com.briup.school.service;

import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyCheckService {
    List<SurveyEX> selectAll() throws RuntimeException;
    void check(int id) throws RuntimeException;



}
