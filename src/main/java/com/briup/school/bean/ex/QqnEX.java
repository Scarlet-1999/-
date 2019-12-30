package com.briup.school.bean.ex;

import com.briup.school.bean.Questionnaire;

import java.util.List;

public class QqnEX {
    private Integer id;


    private Questionnaire questionnaire;
    private List<QuestionEX> questionExs;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public List<QuestionEX> getQuestionExs() {
        return questionExs;
    }

    public void setQuestionExs(List<QuestionEX> questionExs) {
        this.questionExs = questionExs;
    }

    @Override
    public String toString() {
        return "QqnEX{" +
                "id=" + id +
                ", questionnaire=" + questionnaire +
                ", questionExs=" + questionExs +
                '}';
    }
}
