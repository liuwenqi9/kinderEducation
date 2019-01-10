package com.muji.zh.admin.model;

import java.io.Serializable;
import java.util.Date;

public class KindergartenCopy implements Serializable {
    private Integer id;

    private Integer kId;

    private Integer ktId;

    private String address;

    private String kname;

    private String businessNature;

    private String licenseNumber;

    private Integer eduId;

    private Date createDate;

    private Integer phone;

    private Integer legalId;

    private Integer planClass;

    private Integer planPeople;

    private Integer planTeacher;

    private Integer governess;

    private Integer otherPeople;

    private Integer leavePeople;

    private Integer wages;

    private Integer grossProduction;

    private Integer areaCovered;

    private Integer annual;

    private Integer socialDonation;

    private Integer premiums;

    private Integer dayCare;

    private Integer fullCare;

    private Integer littleTob;

    private Integer rank;

    private Integer urbanId;

    private Integer areaId;

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

    public Integer getkId() {
        return kId;
    }

    public void setkId(Integer kId) {
        this.kId = kId;
    }

    public Integer getKtId() {
        return ktId;
    }

    public void setKtId(Integer ktId) {
        this.ktId = ktId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname == null ? null : kname.trim();
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature == null ? null : businessNature.trim();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber == null ? null : licenseNumber.trim();
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getLegalId() {
        return legalId;
    }

    public void setLegalId(Integer legalId) {
        this.legalId = legalId;
    }

    public Integer getPlanClass() {
        return planClass;
    }

    public void setPlanClass(Integer planClass) {
        this.planClass = planClass;
    }

    public Integer getPlanPeople() {
        return planPeople;
    }

    public void setPlanPeople(Integer planPeople) {
        this.planPeople = planPeople;
    }

    public Integer getPlanTeacher() {
        return planTeacher;
    }

    public void setPlanTeacher(Integer planTeacher) {
        this.planTeacher = planTeacher;
    }

    public Integer getGoverness() {
        return governess;
    }

    public void setGoverness(Integer governess) {
        this.governess = governess;
    }

    public Integer getOtherPeople() {
        return otherPeople;
    }

    public void setOtherPeople(Integer otherPeople) {
        this.otherPeople = otherPeople;
    }

    public Integer getLeavePeople() {
        return leavePeople;
    }

    public void setLeavePeople(Integer leavePeople) {
        this.leavePeople = leavePeople;
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    public Integer getGrossProduction() {
        return grossProduction;
    }

    public void setGrossProduction(Integer grossProduction) {
        this.grossProduction = grossProduction;
    }

    public Integer getAreaCovered() {
        return areaCovered;
    }

    public void setAreaCovered(Integer areaCovered) {
        this.areaCovered = areaCovered;
    }

    public Integer getAnnual() {
        return annual;
    }

    public void setAnnual(Integer annual) {
        this.annual = annual;
    }

    public Integer getSocialDonation() {
        return socialDonation;
    }

    public void setSocialDonation(Integer socialDonation) {
        this.socialDonation = socialDonation;
    }

    public Integer getPremiums() {
        return premiums;
    }

    public void setPremiums(Integer premiums) {
        this.premiums = premiums;
    }

    public Integer getDayCare() {
        return dayCare;
    }

    public void setDayCare(Integer dayCare) {
        this.dayCare = dayCare;
    }

    public Integer getFullCare() {
        return fullCare;
    }

    public void setFullCare(Integer fullCare) {
        this.fullCare = fullCare;
    }

    public Integer getLittleTob() {
        return littleTob;
    }

    public void setLittleTob(Integer littleTob) {
        this.littleTob = littleTob;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getUrbanId() {
        return urbanId;
    }

    public void setUrbanId(Integer urbanId) {
        this.urbanId = urbanId;
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

    public String getFlag4() {
        return flag4;
    }

    public void setFlag4(String flag4) {
        this.flag4 = flag4 == null ? null : flag4.trim();
    }

    @Override
    public String toString() {
        return "KindergartenCopy{" +
                "id=" + id +
                ", kId=" + kId +
                ", ktId=" + ktId +
                ", address='" + address + '\'' +
                ", kname='" + kname + '\'' +
                ", businessNature='" + businessNature + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", eduId=" + eduId +
                ", createDate=" + createDate +
                ", phone=" + phone +
                ", legalId=" + legalId +
                ", planClass=" + planClass +
                ", planPeople=" + planPeople +
                ", planTeacher=" + planTeacher +
                ", governess=" + governess +
                ", otherPeople=" + otherPeople +
                ", leavePeople=" + leavePeople +
                ", wages=" + wages +
                ", grossProduction=" + grossProduction +
                ", areaCovered=" + areaCovered +
                ", annual=" + annual +
                ", socialDonation=" + socialDonation +
                ", premiums=" + premiums +
                ", dayCare=" + dayCare +
                ", fullCare=" + fullCare +
                ", littleTob=" + littleTob +
                ", rank=" + rank +
                ", urbanId=" + urbanId +
                ", areaId=" + areaId +
                ", flag1='" + flag1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                ", flag4='" + flag4 + '\'' +
                '}';
    }
}