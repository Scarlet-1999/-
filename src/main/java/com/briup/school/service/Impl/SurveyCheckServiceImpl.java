package com.briup.school.service.Impl;

import com.briup.school.bean.Answer;
import com.briup.school.bean.AnswerExample;
import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.AnswerMapper;
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
    public SurveyEX showDetail(int id) throws RuntimeException {
        String statu = surveyMapper.selectByPrimaryKey(id).getStatus();
        if ("未审核".equals(statu)){
            //查询答案列表并赋值给查询到的surveyEX的answers
            AnswerExample answerExample = new AnswerExample();
            answerExample.createCriteria().andSurveyIdEqualTo(id);
            SurveyEX surveyEX = surveyEXMapper.FindById(id);
            surveyEX.setAnswers(answerMapper.selectByExample(answerExample));

            //展示包括平均分及问题列表的界面
            return surveyEX;
        }else{
            throw new RuntimeException("操作有误");
        }
    }

    @Override
    public void updateAnswer(Answer answer) throws RuntimeException {
        Answer answerPre= answerMapper.selectByPrimaryKey(answer.getId());
        answer.setSurveyId(answerPre.getSurveyId());
        answerMapper.updateByPrimaryKey(answer);
    }

    @Override
    public void deleteAnswer(int id) throws RuntimeException {
        answerMapper.deleteByPrimaryKey(id);
    }

    //该方法无需判断状态 因为在显示具体信息时已判断
    @Override
    public void check(int key, int id) throws RuntimeException {
        Survey survey = surveyMapper.selectByPrimaryKey(id);
        if(key == 1){
            survey.setStatus("审核通过");
            surveyMapper.updateByPrimaryKey(survey);
        }else if(key == 2){
            survey.setStatus("审核不通过");
            surveyMapper.updateByPrimaryKey(survey);
        }else{
            throw new RuntimeException("操作有误");
        }
    }
}
