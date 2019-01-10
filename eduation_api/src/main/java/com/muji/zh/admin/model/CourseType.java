package com.muji.zh.admin.model;

import java.io.Serializable;
import java.util.Date;

public class CourseType implements Serializable {
    private Integer id;

    private String typename;

    private Date createDate;

    private Integer creId;

    private String falg1;

    private String flag2;

    private String flag3;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreId() {
        return creId;
    }

    public void setCreId(Integer creId) {
        this.creId = creId;
    }

    public String getFalg1() {
        return falg1;
    }

    public void setFalg1(String falg1) {
        this.falg1 = falg1 == null ? null : falg1.trim();
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
        return "CourseType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                ", createDate=" + createDate +
                ", creId=" + creId +
                ", falg1='" + falg1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                '}';
    }
}