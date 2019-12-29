package com.briup.school.service;

import com.briup.school.bean.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll() throws RuntimeException;
    List<Teacher> findByNameGenden(String key,String word) throws  RuntimeException;
    void deleteByid(int id) throws RuntimeException;
    void delelteByids(List<Integer> list) throws RuntimeException;
    void addOrUpdate(Teacher teacher)throws RuntimeException;

}
