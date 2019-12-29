package com.briup.school.service.Impl;

import com.briup.school.bean.Class;
import com.briup.school.bean.ClassExample;
import com.briup.school.bean.ex.ClassEx;
import com.briup.school.mapper.ClassMapper;
import com.briup.school.mapper.ex.ClassEXMapper;
import com.briup.school.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private ClassEXMapper classEXMapper;

    @Autowired
    private ClassMapper classMapper;


    @Override
    public List<ClassEx> selectAll() throws RuntimeException {
        return classEXMapper.selectAll();
    }

    @Override
    public Class selectById(int id) throws RuntimeException {
        return classMapper.selectByPrimaryKey(id);
    }


    @Override
    public void deleteById(int id) throws RuntimeException {
        classMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addOrUpadate(Class cla) throws RuntimeException {
        if (cla.getId() == null){
            classMapper.insert(cla);
        }else{
            classMapper.updateByPrimaryKey(cla);
        }
    }

    @Override
    public List<ClassEx> search(String key, String word) throws RuntimeException {
        word = word == null ? "":word;
        if((key==null||"".equals(key))&&(word==null||"".equals(word))){
            return classEXMapper.selectAll();
//        key为空 word不为空
        }else if((key==null||"".equals(key))&&!"".equals(word)){
            word = "%" + word +"%";
            return classEXMapper.selectByNameOrDescription(word);
        }else if (("name".equals(key))){
            word = "%" + word +"%";
            return classEXMapper.selectByName(word);
        }else if ("description".equals(key)){
            word = "%" + word +"%";
            return classEXMapper.selectByDescription(word);
        }
        return null;
    }


}
