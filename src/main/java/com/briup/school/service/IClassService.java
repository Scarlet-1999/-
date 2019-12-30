package com.briup.school.service;

import com.briup.school.bean.Class;

import java.util.List;

public interface IClassService {
    List<Class> selectAll() throws RuntimeException;
    Class selectById(int id)throws RuntimeException;
    void deleteById(int id)throws RuntimeException;
    void addOrUpadate(Class cla)throws RuntimeException;
    List<Class> search(String key,String word) throws RuntimeException;
}
