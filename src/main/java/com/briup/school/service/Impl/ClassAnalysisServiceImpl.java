package com.briup.school.service.Impl;

import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.ClassEX;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.mapper.ex.ClassEXMapper;
import com.briup.school.service.IClassAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassAnalysisServiceImpl implements IClassAnalysisService {
    @Autowired
    private ClassEXMapper classEXMapper;
    @Autowired
    private SurveyMapper  surveyMapper;
    @Override
    public List<ClassEX> selectById(int id) throws RuntimeException {
        return classEXMapper.selectById(id);
    }

    @Override
    public List<ClassEX> selectAll() throws RuntimeException {
       return classEXMapper.selectAll();
    }

    @Override
    public List<ClassEX> findAll() throws RuntimeException {
        List<ClassEX> classEXES=classEXMapper.findAllSurvey();
        return classEXES;
    }

    @Override
    public Survey selectById1(int id) throws RuntimeException {
        Survey survey=new Survey();

       return survey;
   }

    @Override
    public List<ClassEX> selectByName(String name) throws RuntimeException {
        return classEXMapper.selectByName(name);
    }

    @Override
    public List<ClassEX> selectAverage() throws RuntimeException {
        return classEXMapper.selectAverage();
    }

    @Override
    public List<ClassEX> selectNameAndAverage(String key1, String key2, String word) throws RuntimeException {
        return classEXMapper.selectNameAndAverage(key1,key2,word);
    }

    /*@Override
    public List<ClassEX> fingword(String key1, String key2, String word) throws RuntimeException {
        word = word == null ? "" : word;
        key1 = key1 == null ? "" : key1;
        key2 = key2 == null ? "" : key2;
        if ((key1 == null || "".equals(key1)) &&(key2 == null || "".equals(key2))&& (word == null || "".equals(word))) {
            System.out.println(".......");
            return findAll();

        }else if ((key1 == null || "".equals(key1)) && (key2 == null || "".equals(key2))&& !"".equals(word)){
            //前面下拉框为空，后面不为空

            word = "%" + word  + "%";
            List<ClassEX> classEXES=classEXMapper.selectword(word);
            return classEXES;

        }else if(!"".equals(key1) && (key2 == null || "".equals(key2))&& !"".equals(word)){
            word = "%" + word  + "%";
            key1 = "%" + key1  + "%";
            List<ClassEX> resultExes1=classEXMapper.selectdepartword(key1,word);
            return resultExes1;

        }else if(!"".equals(key2) && (key1 == null || "".equals(key1))&& !"".equals(word)){
            word = "%" + word  + "%";
            key2 = "%" + key2  + "%";
            System.out.println(word);
            List<ClassEX> resultExes2=classEXMapper.selectclassword(key2,word);
            return resultExes2;
        }else if(!"".equals(key1) && (key2 == null || "".equals(key2))&& (word == null || "".equals(word))){
            key1 = "%" + key1  + "%";
            List<ClassEX> resultExes3 = classEXMapper.selectdepart(key1);
            return resultExes3;

        }else if(!"".equals(key2) && (key1 == null || "".equals(key1))&& (word == null || "".equals(word))) {
            key2 = "%" + key2  + "%";
            List<ClassEX> resultExes4 = classEXMapper.selectclass(key2);
            return resultExes4;

        }else if(!"".equals(key1) && !"".equals(key2) && (word == null || "".equals(word))){
            key1 = "%" + key1  + "%";
            key2 = "%" + key2  + "%";
            List<ClassEX> resultExes4 = classEXMapper.selectdepartclass(key1,key2);
            return resultExes4;
        }
        return null;
    }*/


}
