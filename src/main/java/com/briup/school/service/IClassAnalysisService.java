package com.briup.school.service;

import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.ClassEX;

import java.util.List;

public interface IClassAnalysisService {
    List<ClassEX> selectById(int id) throws  RuntimeException;
    List<ClassEX> selectAll() throws  RuntimeException;
    List<ClassEX> findAll() throws  RuntimeException;
    Survey selectById1(int id) throws  RuntimeException;
    List<ClassEX> selectByName(String name) throws  RuntimeException;
    List<ClassEX> selectAverage() throws  RuntimeException;
    List<ClassEX> selectNameAndAverage(String key1, String key2, String word) throws  RuntimeException;
    //List<ClassEX> fingword(String key1, String key2, String word) throws RuntimeException;
}
