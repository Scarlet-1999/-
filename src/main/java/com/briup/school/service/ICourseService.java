package com.briup.school.service;

import com.briup.school.bean.Course;

import java.util.List;

public interface ICourseService {
    List<Course> selectAll() throws  RuntimeException;
    void deleteById(int id) throws  RuntimeException;
    void saveOrUpdate(Course course) throws  RuntimeException;
    void batchDelete(List<Course> courses)throws  RuntimeException;
}
