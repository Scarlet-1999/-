package com.briup.school.bean.ex;

import com.briup.school.bean.Survey;

import java.util.List;

public class ClassEX {
    private Integer id;

    private String name;

    private Integer serveNumber;

    private Integer studentNumber;

    private Integer departmentId;

    private Integer teacherId;

    private String description;

    private List<Survey> survry;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getServeNumber() {
        return serveNumber;
    }

    public void setServeNumber(Integer serveNumber) {
        this.serveNumber = serveNumber;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Survey> getSurvry() {
        return survry;
    }

    public void setSurvry(List<Survey> survry) {
        this.survry = survry;
    }
}
