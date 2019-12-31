package com.briup.school.service.Impl;

import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.ex.AllSurveyEXMapper;
import com.briup.school.service.IAllSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AllSurveyServiceImpl implements IAllSurveyService {
    @Autowired
    private AllSurveyEXMapper allSurveyEXMapper;

    @Override
    public List<SurveyEX> findall() {
        List<SurveyEX> list=allSurveyEXMapper.FindAll();
        return list;
    }

    @Override
    public List<SurveyEX> findByClassName(String ClassName) throws RuntimeException {
        List<SurveyEX> list=allSurveyEXMapper.findByClassName(ClassName);
        return list;
    }

    @Override
    public List<SurveyEX> findByAll(String Dname, String Clname, String Coname, String Qname,String word) throws RuntimeException {
        if (Dname==null||"".equals(Dname)){
            Dname="%%";
        }

        if (Clname==null||"".equals(Clname)){
            Clname="%%";
        }

        if (Coname==null||"".equals(Coname)){
            Coname="%%";
        }

        if (Qname==null||"".equals(Qname)){
            Qname="%%";
        }


        if (word==null){
            word="";
        }


        word="%"+word+"%";
        System.out.println(word);
        List<SurveyEX> list=allSurveyEXMapper.findByAll(Dname,Clname,Coname,Qname,word);

        return list;
    }
}
