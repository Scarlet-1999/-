package com.briup.school.bean.ex;

import com.briup.school.bean.Survey;

import java.io.Serializable;
import java.util.List;

public class ClassEX implements Serializable {


    private String name;
    private  String average;

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

   /* private Integer serveNumber;

    private Integer studentNumber;

    private Integer departmentId;

    private Integer teacherId;

    private String description;*/





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public Integer getServeNumber() {
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
*/

}
