package com.briup.school.mapper;

import com.briup.school.bean.Survey;
import com.briup.school.bean.SurveyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyMapper {
    long countByExample(SurveyExample example);

    int deleteByExample(SurveyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Survey record);

    int insertSelective(Survey record);

    List<Survey> selectByExample(SurveyExample example);

    Survey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByExample(@Param("record") Survey record, @Param("example") SurveyExample example);

    int updateByPrimaryKeySelective(Survey record);

    int updateByPrimaryKey(Survey record);
}