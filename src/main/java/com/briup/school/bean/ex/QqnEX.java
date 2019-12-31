package com.briup.school.bean.ex;

import java.io.Serializable;

public class QqnEX implements Serializable {
    private Integer id;

    private QuestionEX questionEX;

    private Integer questionnaireId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuestionEX getQuestionEX() {
        return questionEX;
    }

    public void setQuestionEX(QuestionEX questionEX) {
        this.questionEX = questionEX;
    }

    public Integer getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(Integer questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    private static final long serialVersionUID = 1L;
}
