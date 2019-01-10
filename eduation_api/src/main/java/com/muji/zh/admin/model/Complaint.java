package com.muji.zh.admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Complaint implements Serializable {
    private Integer id;

    private String cname;

    private String title;

    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date doDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createDate;

    private Integer tId;

    private String image;

    private String file;

    private Integer whoId;

    private String target;

    private Integer oId;

    private Integer ubarnId;

    private String areaId;

    private Integer sign;

    private String flag1;

    private String flag2;

    private String flag3;

    private String flag4;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDoDate() {
        return doDate;
    }

    public void setDoDate(Date doDate) {
        this.doDate = doDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Integer getWhoId() {
        return whoId;
    }

    public void setWhoId(Integer whoId) {
        this.whoId = whoId;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getUbarnId() {
        return ubarnId;
    }

    public void setUbarnId(Integer ubarnId) {
        this.ubarnId = ubarnId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
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
        return "Complaint{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", doDate=" + doDate +
                ", createDate=" + createDate +
                ", tId=" + tId +
                ", image='" + image + '\'' +
                ", file='" + file + '\'' +
                ", whoId=" + whoId +
                ", target='" + target + '\'' +
                ", oId=" + oId +
                ", ubarnId=" + ubarnId +
                ", areaId='" + areaId + '\'' +
                ", sign=" + sign +
                ", flag1='" + flag1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                ", flag4='" + flag4 + '\'' +
                '}';
    }
}