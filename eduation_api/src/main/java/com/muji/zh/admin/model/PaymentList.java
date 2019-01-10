package com.muji.zh.admin.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class PaymentList implements Serializable {
    private Integer id;

    private Integer sId;

    private String pname;

    private String sex;

    private String kindName;

    private String className;

    private String gradeName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    private Float tuition;

    private String content;

    private Float actual;

    private Integer areaId;

    private String falg1;

    private String falg2;

    private String falg3;

    private Integer flag4;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName == null ? null : kindName.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName == null ? null : gradeName.trim();
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Float getTuition() {
        return tuition;
    }

    public void setTuition(Float tuition) {
        this.tuition = tuition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Float getActual() {
        return actual;
    }

    public void setActual(Float actual) {
        this.actual = actual;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getFlag4() {
        return flag4;
    }

    public void setFlag4(Integer flag4) {
        this.flag4 = flag4;
    }
}