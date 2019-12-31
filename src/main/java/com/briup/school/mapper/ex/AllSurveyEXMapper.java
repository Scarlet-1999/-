package com.briup.school.mapper.ex;

import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface AllSurveyEXMapper {
    List<SurveyEX> FindAll();
    List<SurveyEX> findByClassName(String classname);
    List<SurveyEX> findByDepartmentNAme(String Dname);
    List<SurveyEX> findByAll(String Dname,String Clname,String Coname,String Qname,String word);

}
