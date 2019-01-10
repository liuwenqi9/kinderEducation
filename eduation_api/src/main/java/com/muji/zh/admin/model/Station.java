package com.muji.zh.admin.model;

import java.io.Serializable;

public class Station implements Serializable {
    private Integer sId;

    private String sname;

    private String professionalTitle;

    private String flag1;

    private byte[] flag2;

    private static final long serialVersionUID = 1L;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle == null ? null : professionalTitle.trim();
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1 == null ? null : flag1.trim();
    }

    public byte[] getFlag2() {
        return flag2;
    }

    public void setFlag2(byte[] flag2) {
        this.flag2 = flag2;
    }
}