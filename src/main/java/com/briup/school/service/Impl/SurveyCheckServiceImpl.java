package com.briup.school.service.Impl;

import com.briup.school.bean.AnswerExample;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.AnswerMapper;
import com.briup.school.mapper.QuestionnaireMapper;
import com.briup.school.mapper.SurveyMapper;
import com.briup.school.mapper.ex.SurveyEXMapper;
import com.briup.school.service.ISurveyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SurveyCheckServiceImpl implements ISurveyCheckService {
    @Autowired
    private SurveyEXMapper surveyEXMapper;

    @Autowired
    private SurveyMapper surveyMapper;

    public List<SurveyEX> selectAll() throws RuntimeException{
        return surveyEXMapper.FindAll();
    }

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public SurveyEX check(int id) throws RuntimeException {
        String statu = surveyMapper.selectByPrimaryKey(id).getStatus();
        if ("未审核".equals(statu)){
            //查询答案列表并赋值给查询到的surveyEX的answers
            AnswerExample answerExample = new AnswerExample();
            answerExample.createCriteria().andSurveyIdEqualTo(id);
            SurveyEX surveyEX = surveyEXMapper.FindById(id);
            surveyEX.setAnswers(answerMapper.selectByExample(answerExample));
            return surveyEX;
            //展示包括平均分及问题列表的界面
        }else{
            new RuntimeException("当前课调未开启或已审核");
            return null;
        }
    }
}
