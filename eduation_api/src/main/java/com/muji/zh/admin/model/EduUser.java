package com.muji.zh.admin.model;

import java.io.Serializable;

public class EduUser implements Serializable {
    private Integer epId;

    private String password;

    @Override
    public String toString() {
        return "EduUser{" +
                "epId=" + epId +
                ", password='" + password + '\'' +
                ", nname='" + nname + '\'' +
                ", sex='" + sex + '\'' +
                ", eduId=" + eduId +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sign=" + sign +
                ", areaId=" + areaId +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                ", flag1='" + flag1 + '\'' +
                '}';
    }

    private String nname;

    private String sex;

    private Integer eduId;

    private String phone;

    private String email;

    private Integer sign;

    private Integer areaId;

    private String flag2;

    private String flag3;

    private String flag1;

    private static final long serialVersionUID = 1L;

    public Integer getEpId() {
        return epId;
    }

    public void setEpId(Integer epId) {
        this.epId = epId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname == null ? null : nname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getEduId() {
        return eduId;
    }

    public void setEduId(Integer eduId) {
        this.eduId = eduId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1 == null ? null : flag1.trim();
    }
}