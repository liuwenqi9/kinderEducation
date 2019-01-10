package com.muji.zh.admin.model;

import java.io.Serializable;
import java.util.Date;

public class StudentCopy implements Serializable {
    private Integer id;

    private Integer sid;

    private String sname;

    private String image;

    private String sex;

    private String birthday;

    private Integer nativePlace;

    private Integer stuId;

    private Integer kid;

    private Integer clasId;

    private Integer eduId;

    private Date createDate;

    private Integer icId;

    private Integer areaId;

    private Integer ubranId;

    private Integer tuition;

    private String flag1;

    private String falg2;

    private String flag3;

    private String flag4;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(Integer nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Integer getClasId() {
        return clasId;
    }

    public void setClasId(Integer clasId) {
        this.clasId = clasId;
    }

    public Integer getEduId() {
        return eduId;
    }

    public void setEduId(Integer eduId) {
        this.eduId = eduId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getIcId() {
        return icId;
    }

    public void setIcId(Integer icId) {
        this.icId = icId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getUbranId() {
        return ubranId;
    }

    public void setUbranId(Integer ubranId) {
        this.ubranId = ubranId;
    }

    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1 == null ? null : flag1.trim();
    }

    public String getFalg2() {
        return falg2;
    }

    public void setFalg2(String falg2) {
        this.falg2 = falg2 == null ? null : falg2.trim();
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
        return "StudentCopy{" +
                "id=" + id +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", image='" + image + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nativePlace=" + nativePlace +
                ", stuId=" + stuId +
                ", kid=" + kid +
                ", clasId=" + clasId +
                ", eduId=" + eduId +
                ", createDate=" + createDate +
                ", icId=" + icId +
                ", areaId=" + areaId +
                ", ubranId=" + ubranId +
                ", tuition=" + tuition +
                ", flag1='" + flag1 + '\'' +
                ", falg2='" + falg2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                ", flag4='" + flag4 + '\'' +
                '}';
    }
}