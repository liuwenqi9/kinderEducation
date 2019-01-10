package com.muji.zh.admin.model;

import java.io.Serializable;

public class Education implements Serializable {
    private Integer eId;

    private String ename;

    private Integer ubranId;

    private Integer areaId;

    private String flag1;

    private String flag2;

    private String flag3;

    private static final long serialVersionUID = 1L;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public Integer getUbranId() {
        return ubranId;
    }

    public void setUbranId(Integer ubranId) {
        this.ubranId = ubranId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    @Override
    public String toString() {
        return "Education{" +
                "eId=" + eId +
                ", ename='" + ename + '\'' +
                ", ubranId=" + ubranId +
                ", areaId=" + areaId +
                ", flag1='" + flag1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                '}';
    }
}