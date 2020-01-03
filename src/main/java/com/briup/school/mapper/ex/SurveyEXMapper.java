package com.briup.school.mapper.ex;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.SurveyExample;
import com.briup.school.bean.ex.SurveyEX;

import java.util.List;

public interface SurveyEXMapper {
    List<SurveyEX> FindAll();
    List<SurveyEX> FindByCondition(int id);
    SurveyEX FindById(int id);
   List<SurveyEX> lhjFindAll();
    List<SurveyEX>  lhjFindByCondition(int id);


}
