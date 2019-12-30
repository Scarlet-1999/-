package com.briup.school.service.Impl;

import com.briup.school.bean.QqnExample;
import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.QuestionnaireExample;
import com.briup.school.bean.SurveyExample;
import com.briup.school.mapper.QqnMapper;
import com.briup.school.mapper.QuestionnaireMapper;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.service.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QqnMapper qqnMapper;
    @Autowired
    private SurveyMapper surveyMapper;

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
    public List<Questionnaire> selectByName(String name,String description) throws RuntimeException {
        if (name==null){
            name="";
        }
        if ((name==null||"".equals(name))&&(description==null||"".equals(description))){
            QuestionnaireExample questionnaireExample=new QuestionnaireExample();
            List<Questionnaire> questionnaireList=
                    questionnaireMapper.selectByExample(questionnaireExample);
            return questionnaireList;
        }
        if (description==null){








        }



        return null;
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

    }
}
