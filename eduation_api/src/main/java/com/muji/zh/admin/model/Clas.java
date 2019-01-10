package com.muji.zh.admin.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Clas implements Serializable {
    private Integer cId;

    private String cname;

    private String grade;

    private Integer cType;

    private Integer pId;

    private Integer kid;

    private String flag1;

    private String flag2;

    private String flag3;

    private String flag4;

    private static final long serialVersionUID = 1L;
    @JSONField(name="cId")
    public Integer getcId() {
        return cId;
    }
    @JSONField(name="cId")
    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }
    @JSONField(name="kId")
    public Integer getKid() {
        return kid;
    }
    @JSONField(name="kId")
    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1 == null ? null : flag1.trim();
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2 == null ? null : flag2.trim();
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3 == null ? null : flag3.trim();
    }

    public String getFlag4() {
        return flag4;
    }

    public void setFlag4(String flag4) {
        this.flag4 = flag4 == null ? null : flag4.trim();
    }

    @Override
    public String toString() {
        return "Clas{" +
                "cId=" + cId +
                ", cname='" + cname + '\'' +
                ", grade='" + grade + '\'' +
                ", cType=" + cType +
                ", pId=" + pId +
                ", kid=" + kid +
                ", flag1='" + flag1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                ", flag4='" + flag4 + '\'' +
                '}';
    }
}