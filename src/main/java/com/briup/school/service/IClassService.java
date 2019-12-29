package com.briup.school.service;

import com.briup.school.bean.Class;
import com.briup.school.bean.ex.ClassEx;

import java.util.List;

public interface IClassService {
    List<ClassEx> selectAll() throws RuntimeException;
    Class selectById(int id)throws RuntimeException;
    void deleteById(int id)throws RuntimeException;
    void addOrUpadate(Class cla)throws RuntimeException;
    List<ClassEx> search(String key,String word) throws RuntimeException;

}
