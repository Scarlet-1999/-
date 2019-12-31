package com.briup.school.service;

import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyCheckService {
    List<SurveyEX> selectAll() throws RuntimeException;
    List<SurveyEX> searchByName(String word) throws RuntimeException;

}
