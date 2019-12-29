package com.briup.school.service;

import com.briup.school.bean.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDepartmentService {
    void SaveOrUpdate(Department department) throws RuntimeException;
    List<Department> FindAll() throws RuntimeException;
    Department Find(int id) throws RuntimeException;
    void Delete(int id) throws RuntimeException;
    void DeleteAll() throws RuntimeException;
    List<Department> FindByCondition(String key);
}
