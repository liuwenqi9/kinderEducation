package com.muji.zh.admin.model;

import java.io.Serializable;

public class Urban implements Serializable {
    private Integer uid;

    private String uname;

    private String flag1;

    private String flag2;

    private String flag3;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
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
        return "Urban{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", flag1='" + flag1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                '}';
    }
}