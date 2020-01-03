package com.briup.school.mapper.ex;

import com.briup.school.bean.ex.ClassEX;

import java.util.List;

public interface ClassEXMapper {
List<ClassEX> selectById(int id) throws  RuntimeException;
List<ClassEX> selectAll() throws  RuntimeException;
List<ClassEX> select(int id) throws  RuntimeException;
List<ClassEX> selectByName(String name) throws RuntimeException;
List<ClassEX> selectAverage() throws  RuntimeException;
    List<ClassEX> selectNameAndAverage(String key1, String key2, String word) throws  RuntimeException;
    List<ClassEX> selectdepartword(String key1, String word);

    List<ClassEX> selectclassword(String key2, String word);

    List<ClassEX> selectdepart(String key1);

    List<ClassEX> selectclass(String key2);

    List<ClassEX> selectdepartclass(String key1, String key2);

    List<ClassEX> selectword(String word);

    List<ClassEX> findAllSurvey();
}
