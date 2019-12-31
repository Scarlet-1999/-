package com.briup.school.mapper;

import com.briup.school.bean.Qqn;
import com.briup.school.bean.QqnExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QqnMapper {
    long countByExample(QqnExample example);

    int deleteByExample(QqnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Qqn record);

    int insertSelective(Qqn record);

    List<Qqn> selectByExample(QqnExample example);

    Qqn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Qqn record, @Param("example") QqnExample example);

    int updateByExample(@Param("record") Qqn record, @Param("example") QqnExample example);

    int updateByPrimaryKeySelective(Qqn record);

    int updateByPrimaryKey(Qqn record);


}