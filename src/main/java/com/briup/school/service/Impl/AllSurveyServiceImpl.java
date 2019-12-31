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
}
