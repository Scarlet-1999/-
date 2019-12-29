package com.briup.school.mapper.ex;

import com.briup.school.bean.ex.ClassEx;

import java.util.List;

public interface ClassEXMapper {
    List<ClassEx> selectByNameOrDescription(String word) throws RuntimeException;

    List<ClassEx> selectByName(String word) throws RuntimeException;
    List<ClassEx> selectByDescription(String word) throws RuntimeException;
    List<ClassEx> selectAll() throws RuntimeException;


}
