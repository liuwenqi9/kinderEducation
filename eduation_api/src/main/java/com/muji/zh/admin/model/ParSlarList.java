package com.muji.zh.admin.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ParSlarList implements Serializable {
    private Integer id;

    private String pname;

    private Integer sId;

    private Integer pId;

    private Integer sign;

    private Integer state;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Override
    public String toString() {
        return "ParSlarList{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", sId=" + sId +
                ", pId=" + pId +
                ", sign=" + sign +
                ", state=" + state +
                ", createDate=" + createDate +
                ", endDate=" + endDate +
                ", content='" + content + '\'' +
                ", realWages=" + realWages +
                ", falg1='" + falg1 + '\'' +
                ", falg2='" + falg2 + '\'' +
                ", falg3='" + falg3 + '\'' +
                '}';
    }

    private String content;

    private Float realWages;

    private String falg1;

    private String falg2;

    private String falg3;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Float getRealWages() {
        return realWages;
    }

    public void setRealWages(Float realWages) {
        this.realWages = realWages;
    }

    public String getFalg1() {
        return falg1;
    }

    public void setFalg1(String falg1) {
        this.falg1 = falg1 == null ? null : falg1.trim();
    }

    public String getFalg2() {
        return falg2;
    }

    public void setFalg2(String falg2) {
        this.falg2 = falg2 == null ? null : falg2.trim();
    }

    public String getFalg3() {
        return falg3;
    }

    public void setFalg3(String falg3) {
        this.falg3 = falg3 == null ? null : falg3.trim();
    }
}