package com.muji.zh.admin.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/12/29/029.
 */
public class ClassVo implements Serializable {
    private Integer c_id;
    private String cname;
    private String grade;
    private String aname;
    private String pname;

    public Integer getcId() {
        return c_id;
    }

    public void setcId(Integer cId) {
        this.c_id = cId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
