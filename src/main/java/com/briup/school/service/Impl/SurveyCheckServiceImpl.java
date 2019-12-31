package com.briup.school.service.Impl;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.QuestionnaireExample;
import com.briup.school.bean.SurveyExample;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.QuestionnaireMapper;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.mapper.ex.SurveyEXMapper;
import com.briup.school.service.ISurveyCheckService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SurveyCheckServiceImpl implements ISurveyCheckService {
    @Autowired
    private SurveyEXMapper surveyEXMapper;

    @Autowired
    private QuestionnaireMapper questionnaireMapper;

    private SurveyMapper surveyMapper;
    public List<SurveyEX> selectAll() throws RuntimeException{
        return surveyEXMapper.FindAll();
    }

    @Override
    public List<SurveyEX> searchByName(String word) throws RuntimeException {
        //根据名字在Questionnaire表中查id
        QuestionnaireExample example = new QuestionnaireExample();
        example.createCriteria().andNameLike(word);
        List<Questionnaire> list=questionnaireMapper.selectByExample(example);
        for(Questionnaire questionnaire:list){

            SurveyExample surveyExample = new SurveyExample();
            surveyExample.createCriteria().andQuestionnaireIdEqualTo(questionnaire.getId());
            surveyMapper.selectByExample(surveyExample);
        }

        return null;
    }
}
