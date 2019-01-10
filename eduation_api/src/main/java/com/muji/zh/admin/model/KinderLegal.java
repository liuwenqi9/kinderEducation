package com.muji.zh.admin.model;

import java.io.Serializable;

public class KinderLegal implements Serializable {
    private Integer id;

    private String password;

    private String klname;

    private String sex;

    private Integer kindId;

    private String phone;

    private Integer icId;

    private String email;

    private String image;

    private String address;

    private Integer areaId;

    private String falg1;

    private String falg2;

    private String falg3;

    private String falg4;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getKlname() {
        return klname;
    }

    public void setKlname(String klname) {
        this.klname = klname == null ? null : klname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getIcId() {
        return icId;
    }

    public void setIcId(Integer icId) {
        this.icId = icId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getFalg4() {
        return falg4;
    }

    public void setFalg4(String falg4) {
        this.falg4 = falg4 == null ? null : falg4.trim();
    }
}