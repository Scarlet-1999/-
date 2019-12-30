package com.briup.school.service.Impl;

import com.briup.school.bean.*;
import com.briup.school.bean.ex.QuestionEX;
import com.briup.school.mapper.OptionsMapper;
import com.briup.school.mapper.QqnMapper;
import com.briup.school.mapper.QuestionMapper;
import com.briup.school.mapper.ex.QuestionEXMapper;
import com.briup.school.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionEXMapper questionEXMapper;
    @Autowired
    private OptionsMapper optionsMapper;
    @Autowired
    private QqnMapper qqnMapper;

    @Override
    public List<QuestionEX> selectAll() throws RuntimeException {
        return questionEXMapper.selectAll();
    }

    @Override
    public void addOrUpdate(Question question,List<Options> options) throws RuntimeException {
        if(question.getId() == null){
            questionEXMapper.insertQuestion(question);
            if (options != null){
                for (Options option:options){
                    option.setQuestionId(question.getId());
                    optionsMapper.insert(option);
                }
            }
        }else{
            questionMapper.updateByPrimaryKey(question);
            if (options != null){
                for(Options option:options){
                    optionsMapper.deleteByPrimaryKey(option.getId());
                }
            }
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        //删除级联表options中的数据
        OptionsExample optionsExample = new OptionsExample();
        optionsExample.createCriteria().andQuestionIdEqualTo(id);
        optionsMapper.deleteByExample(optionsExample);
        //删除级联表qqn中的数据
        QqnExample qqnExample = new QqnExample();
        qqnExample.createCriteria().andQuestionIdEqualTo(id);
        qqnMapper.deleteByExample(qqnExample);

        questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<QuestionEX> selectByName(String word) throws RuntimeException {
        if ("".equals(word)||word==null){
            return questionEXMapper.selectAll();
        }else {
            //模糊查询
            word = "%" + word +"%";
            return questionEXMapper.selectByName(word);
        }


    }


}
