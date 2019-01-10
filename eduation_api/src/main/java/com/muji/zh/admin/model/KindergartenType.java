package com.muji.zh.admin.model;

import java.io.Serializable;

public class KindergartenType implements Serializable {
    private Integer ktId;

    private String ktname;

    private String flag1;

    private String flag2;

    private static final long serialVersionUID = 1L;

    public Integer getKtId() {
        return ktId;
    }

    public void setKtId(Integer ktId) {
        this.ktId = ktId;
    }

    public String getKtname() {
        return ktname;
    }

    public void setKtname(String ktname) {
        this.ktname = ktname == null ? null : ktname.trim();
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

    @Override
    public String toString() {
        return "KindergartenType{" +
                "ktId=" + ktId +
                ", ktname='" + ktname + '\'' +
                ", flag1='" + flag1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                '}';
    }
}