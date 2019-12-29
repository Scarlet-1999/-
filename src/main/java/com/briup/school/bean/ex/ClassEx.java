package com.briup.school.bean.ex;

import com.briup.school.bean.Department;
import com.briup.school.bean.Teacher;

public class ClassEx {
    private Integer id;

    private String name;

    private Integer serveNumber;

    private Integer studentNumber;

    private String description;

    private Teacher teacher;

    private Department department;

    private static final long serialVersionUID = 1L;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ClassEx{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serveNumber=" + serveNumber +
                ", studentNumber=" + studentNumber +
                ", description='" + description + '\'' +
                ", teacher=" + teacher +
                ", department=" + department +
                '}';
    }
}
