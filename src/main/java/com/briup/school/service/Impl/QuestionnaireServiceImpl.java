package com.briup.school.service.Impl;

import com.briup.school.bean.*;
import com.briup.school.bean.ex.QuestionEX;
import com.briup.school.mapper.QqnMapper;
import com.briup.school.mapper.QuestionnaireMapper;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.mapper.ex.QuestionEXMapper;
import com.briup.school.service.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QqnMapper qqnMapper;
    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private QuestionEXMapper questionEXMapper;

    @Override
    public List<Questionnaire> findAll() throws RuntimeException {
        QuestionnaireExample questionnaireExample= new QuestionnaireExample();
        List<Questionnaire> questionnaires =
                questionnaireMapper.selectByExample(questionnaireExample);
        return questionnaires;
    }

    @Override
    public Questionnaire findByid(int id) throws RuntimeException {
        Questionnaire questionnaire=questionnaireMapper.selectByPrimaryKey(id);
        return questionnaire;
    }


    @Override
    public List<Questionnaire> selectByName(String name) throws RuntimeException {
        if (name==null){
            name="";
        }
        name="%"+name+"%";
        QuestionnaireExample example=new QuestionnaireExample();
        example.createCriteria().andNameLike(name);
        List<Questionnaire> list=questionnaireMapper.selectByExample(example);





        return list;
    }

    @Override
    public void deleteByid(int id) throws RuntimeException {
        QqnExample example=new QqnExample();
        example.createCriteria().andQuestionnaireIdEqualTo(id);
        qqnMapper.deleteByExample(example);

        SurveyExample surveyExample=new SurveyExample();
        surveyExample.createCriteria().andQuestionnaireIdEqualTo(id);
        surveyMapper.deleteByExample(surveyExample);

        questionnaireMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deletesome(int[] ids) throws RuntimeException {
        for (int id:ids){
            QqnExample example1=new QqnExample();
            example1.createCriteria().andQuestionnaireIdEqualTo(id);
            qqnMapper.deleteByExample(example1);

            SurveyExample surveyExample1=new SurveyExample();
            surveyExample1.createCriteria().andQuestionnaireIdEqualTo(id);
            surveyMapper.deleteByExample(surveyExample1);

            questionnaireMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void addOrUpdate(Questionnaire questionnaire, int[] Qids) throws RuntimeException {
        if(questionnaire==null){
            throw new RuntimeException("参数为空");
        }
        if (questionnaire.getId()==null){
            questionnaireMapper.insert(questionnaire);
            for (int id:Qids){
                Qqn qqn=new Qqn();
                qqn.setQuestionnaireId(questionnaire.getId());
                qqn.setQuestionId(id);
                qqnMapper.insert(qqn);
            }
        }else {
            questionnaireMapper.updateByPrimaryKey(questionnaire);
            //删除该问卷的桥表
            QqnExample example=new QqnExample();
            example.createCriteria().andQuestionnaireIdEqualTo(questionnaire.getId());
            qqnMapper.deleteByExample(example);
            //添加桥表
            for (int id:Qids){
                Qqn qqn=new Qqn();
                qqn.setQuestionnaireId(questionnaire.getId());
                qqn.setQuestionId(id);
                qqnMapper.insert(qqn);
            }

        }
    }

    @Override
    public List<QuestionEX> seeQuestionByid(int id) throws RuntimeException {
        QqnExample example=new QqnExample();
        example.createCriteria().andQuestionnaireIdEqualTo(id);
        List<Qqn> qqnList=qqnMapper.selectByExample(example);
        List<QuestionEX> questionEXList=new ArrayList<>();
        for (Qqn qqn:qqnList){
            questionEXList.add(questionEXMapper.selectById(qqn.getQuestionId()));


        }
        return questionEXList;
    }


    public void  deleteInManyTable(int id){
        QqnExample qqnExample = new QqnExample();
        qqnExample.createCriteria().andQuestionnaireIdEqualTo(id);
        qqnMapper.deleteByExample(qqnExample);

        SurveyExample surveyExample = new SurveyExample();
        surveyExample.createCriteria().andQuestionnaireIdEqualTo(id);
        surveyMapper.deleteByExample(surveyExample);

        questionnaireMapper.deleteByPrimaryKey(id);

    }


}
