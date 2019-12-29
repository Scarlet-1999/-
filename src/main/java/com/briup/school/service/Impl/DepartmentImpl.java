package com.briup.school.service.Impl;

import com.briup.school.bean.Department;
import com.briup.school.bean.DepartmentExample;
import com.briup.school.mapper.DepartmentMapper;
import com.briup.school.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentImpl implements IDepartmentService {


    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public void SaveOrUpdate(Department department) throws RuntimeException {
        if (department==null){
            throw new RuntimeException("参数为空");
        }
        if (department.getId()==null||"".equals(department.getId())){
            departmentMapper.insert(department);
        }else {
            departmentMapper.updateByPrimaryKey(department);
        }
    }

    @Override
    public List<Department> FindAll() throws RuntimeException {
        DepartmentExample departmentExample=new DepartmentExample();
        List<Department> list=departmentMapper.selectByExample(departmentExample);
        return list;
    }

    @Override
    public Department Find(int id) throws RuntimeException {
        Department department=departmentMapper.selectByPrimaryKey(id);
        return department;
    }

    @Override
    public void Delete(int id) throws RuntimeException {
        departmentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void DeleteAll() throws RuntimeException {

    }

    @Override
    public List<Department> FindByCondition(String key) {
        DepartmentExample departmentExample=new DepartmentExample();
        if (key==null||"".equals(key)){
            List<Department> list=departmentMapper.selectByExample(departmentExample);
            return list;
        }
        else {

            List<Department> list=departmentMapper.FindByCondition(key);
            return list;
        }

    }


}
