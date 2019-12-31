package com.briup.school.bean.ex;

import com.briup.school.bean.Course;
import com.briup.school.bean.Department;
import com.briup.school.bean.Questionnaire;
import com.briup.school.bean.Teacher;
import com.briup.school.bean.Class;

import java.io.Serializable;
import java.util.Date;

public class SurveyEX implements Serializable {
    private Integer id;

    private String status;

    private Integer code;

    private Date surveyday;

//    private Integer departmentId;
//
//    private Integer courseId;
//
//    private Integer clazzId;
//
//    private Integer userId;
//
//    private Integer questionnaireId;

    private Double average;
    private Class aClass;

    private Course course;

    private Department department;

    private Teacher user;

    private QuestionnaireEX questionnaireEX;

    private Questionnaire questionnaire;

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public void setSurveyday(Date surveyday) {
        this.surveyday = surveyday;
    }

    public QuestionnaireEX getQuestionnaireEX() {
        return questionnaireEX;
    }

    public void setQuestionnaireEX(QuestionnaireEX questionnaireEX) {
        this.questionnaireEX = questionnaireEX;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getSurveyday() {
        return surveyday;
    }

//    public void setSurveyday(Date surveyday) {
//        this.surveyday = surveyday;
//    }
//
//    public Integer getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Integer departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    public Integer getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Integer courseId) {
//        this.courseId = courseId;
//    }
//
//    public Integer getClazzId() {
//        return clazzId;
//    }
//
//    public void setClazzId(Integer clazzId) {
//        this.clazzId = clazzId;
//    }
//
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer getQuestionnaireId() {
//        return questionnaireId;
//    }

//    public void setQuestionnaireId(Integer questionnaireId) {
//        this.questionnaireId = questionnaireId;
//    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Teacher getUser() {
        return user;
    }

    public void setUser(Teacher user) {
        this.user = user;
    }
}