package com.briup.school.service.Impl;

import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.Survey;
import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.mapper.*;
import com.briup.school.mapper.ex.SurveyEXMapper;
import com.briup.school.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SurveyServiceImpl implements ISurveyService {

    @Autowired
    private SurveyEXMapper surveyEXMapper;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private QuestionnaireMapper questionnaireMapper;


    @Override
    public List<SurveyEX> FindAll() throws RuntimeException {
        return surveyEXMapper.FindAll();
    }

    @Override
    public List<SurveyEX> FindByCondition(List<Questionnaire> list) throws RuntimeException {
        List<SurveyEX> l = new ArrayList<SurveyEX>();
        for (Questionnaire q : list) {
            l.addAll(surveyEXMapper.FindByCondition(q.getId()));
        }
        return l;


    }

    @Override
    public SurveyEX FindById(int id) throws RuntimeException {
        return surveyEXMapper.FindById(id);

    }

    @Override
    public char SaveOrUpdate(Survey survey) throws RuntimeException {


        boolean f1, f2, f3, f4, f5;
        char info='i';
        //设定true为存在id
        f1 = !(departmentMapper.selectByPrimaryKey(survey.getDepartmentId()) == null);
        f2 = !(courseMapper.selectByPrimaryKey(survey.getCourseId()) == null);
        f3 = !(classMapper.selectByPrimaryKey(survey.getClazzId()) == null);
        f4 = !(teacherMapper.selectByPrimaryKey(survey.getUserId()) == null);
        f5 = !(questionnaireMapper.selectByPrimaryKey(survey.getQuestionnaireId()) == null);


        System.out.println(info);
        if (!f1) info='1';
        if (!f2) info='2';
        if (!f3) info='3';
        if (!f4) info='4';
        if (!f5) info='5';

        System.out.println(info);

        //id不为空为更新操作
        if (survey.getId() != null || "".equals(survey.getId())) {

            //不为空开始判断外键存在问题
            if (f1&&f2&&f3&&f4&&f5) {
                info ='s';
                surveyMapper.updateByPrimaryKey(survey);

            }
            if ("开启".equals(survey.getStatus())){
                System.out.println(123);
                int code=(int)Math.round((Math.random()+1) * System.currentTimeMillis());
                code=code%10000;
                survey.setCode(Math.abs(code));
                surveyMapper.updateByPrimaryKey(survey);
            }

            return info;

        } else {
            survey.setSurveyday(new Date());
            if (f1&&f2&&f3&&f4&&f5) {
                surveyMapper.insert(survey);
                info ='s';
            }

            System.out.println(123);
           // System.out.println("开启".equals(survey.getStatus()));
            if ("开启".equals(survey.getStatus())){
                int code=(int)Math.round((Math.random()+1) * System.currentTimeMillis());

                //取尾
                code=code%10000;

                survey.setCode(Math.abs(code));
                System.out.println(survey.getCode());
                System.out.println("已修改");
                surveyMapper.insert(survey);
            }

            return info;
          }
    }

    @Override
    public void DeleteById(int id) throws RuntimeException {
        surveyMapper.deleteByPrimaryKey(id);
    }
}
