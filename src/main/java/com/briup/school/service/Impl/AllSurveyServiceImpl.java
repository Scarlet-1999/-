package com.briup.school.service.Impl;

import com.briup.school.bean.AnswerExample;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.AnswerMapper;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.mapper.ex.AllSurveyEXMapper;
import com.briup.school.mapper.ex.SurveyEXMapper;
import com.briup.school.service.IAllSurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AllSurveyServiceImpl implements IAllSurveyService {
    @Autowired
    private AllSurveyEXMapper allSurveyEXMapper;
    @Autowired
    private SurveyMapper surveyMapper;
    @Autowired
    private SurveyEXMapper surveyEXMapper;
    @Autowired
    private AnswerMapper answerMapper;

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
        //System.out.println(word);
        List<SurveyEX> list=allSurveyEXMapper.findByAll(Dname,Clname,Coname,Qname,word);

        return list;
    }

    @Override
    public SurveyEX seeById(int id) throws RuntimeException {
        String statu = surveyMapper.selectByPrimaryKey(id).getStatus();

        //查询答案列表并赋值给查询到的surveyEX的answers
        AnswerExample answerExample = new AnswerExample();
        answerExample.createCriteria().andSurveyIdEqualTo(id);
        SurveyEX surveyEX = surveyEXMapper.FindById(id);
        surveyEX.setAnswers(answerMapper.selectByExample(answerExample));

        //展示包括平均分及问题列表的界面
        return surveyEX;



    }
}
