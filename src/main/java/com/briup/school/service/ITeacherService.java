package com.briup.school.service;

import com.briup.school.bean.Teacher;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAll() throws RuntimeException;
    List<Teacher> findByNameGenden(String key,String word) throws  RuntimeException;

}
