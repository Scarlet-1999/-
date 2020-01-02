package com.briup.school.service;

import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface IAllSurveyService {
    List<SurveyEX> findall() throws  RuntimeException;
    List<SurveyEX> findByClassName(String ClassName)throws RuntimeException;
    List<SurveyEX> findByAll(String Dname,String Clname,String Coname,String Qname,String word)throws RuntimeException;
    SurveyEX seeById(int id) throws  RuntimeException;
}
