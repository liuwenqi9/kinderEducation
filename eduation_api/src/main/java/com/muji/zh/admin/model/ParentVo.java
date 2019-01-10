package com.muji.zh.admin.model;

/**
 * Created by Administrator on 2018/11/14/014.
 */
public class ParentVo {
    private Integer id;
    private String password;

    private String icId;

    private String pname;

    private String address;

    private String sex;

    private String phone;

    private String email;

    private String image;

    private String relation;

    private String relationname;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcId() {
        return icId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIcId(String icId) {
        this.icId = icId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelationname() {
        return relationname;
    }

    public void setRelationname(String relationname) {
        this.relationname = relationname;
    }

    @Override
    public String toString() {
        return "ParentVo{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", icId='" + icId + '\'' +
                ", pname='" + pname + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                ", relation='" + relation + '\'' +
                ", relationname='" + relationname + '\'' +
                '}';
    }
}
