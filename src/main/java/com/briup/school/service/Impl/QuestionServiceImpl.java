package com.briup.school.service.Impl;

import com.briup.school.bean.Question;
import com.briup.school.bean.QuestionExample;
import com.briup.school.mapper.QuestionMapper;
import com.briup.school.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Override
    public List<Question> selectAll() throws RuntimeException {
        QuestionExample questionExample = new QuestionExample();
        return questionMapper.selectByExample(questionExample);
    }

    @Override
    public void add(Question question) throws RuntimeException {
        questionMapper.insert(question);

    }
}
