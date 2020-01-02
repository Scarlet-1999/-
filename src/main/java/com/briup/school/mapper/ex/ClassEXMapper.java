package com.briup.school.mapper.ex;

import com.briup.school.bean.ex.ClassEX;

import java.util.List;

public interface ClassEXMapper {
List<ClassEX> selectById(int id) throws  RuntimeException;
List<ClassEX> selectAll() throws  RuntimeException;
List<ClassEX> select(int id) throws  RuntimeException;
List<ClassEX> selectByName(String name) throws RuntimeException;
List<ClassEX> selectAverage() throws  RuntimeException;
    List<ClassEX> selectNameAndAverage(String name) throws  RuntimeException;
}
