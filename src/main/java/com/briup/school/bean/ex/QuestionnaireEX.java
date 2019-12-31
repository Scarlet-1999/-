package com.briup.school.bean.ex;

import java.util.Date;
import java.util.List;
import com.briup.school.bean.ex.QqnEX;

public class QuestionnaireEX {
    private Integer id;

    private String name;

    private Date date;

    private String description;

    private static final long serialVersionUID = 1L;

    private List<QqnEX> qqnEXs;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<QqnEX> getQqnEXs() {
        return qqnEXs;
    }

    public void setQqnEXs(List<QqnEX> qqnEXs) {
        this.qqnEXs = qqnEXs;
    }

    @Override
    public String toString() {
        return "QuestionnaireEX{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", qqnEXs=" + qqnEXs +
                '}';
    }
}
