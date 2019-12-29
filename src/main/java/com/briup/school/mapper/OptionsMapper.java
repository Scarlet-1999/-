package com.briup.school.mapper;

import com.briup.school.bean.Options;
import com.briup.school.bean.OptionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptionsMapper {
    long countByExample(OptionsExample example);

    int deleteByExample(OptionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Options record);

    int insertSelective(Options record);

    List<Options> selectByExample(OptionsExample example);

    Options selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Options record, @Param("example") OptionsExample example);

    int updateByExample(@Param("record") Options record, @Param("example") OptionsExample example);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKey(Options record);
}