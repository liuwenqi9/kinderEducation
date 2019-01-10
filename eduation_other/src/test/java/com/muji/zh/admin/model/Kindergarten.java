package com.muji.zh.admin.model;

import java.io.Serializable;
import java.util.Date;

public class Kindergarten implements Serializable {
    private Integer kId;

    private Integer ktId;

    private String address;

    private String kname;

    private String businessNature;

    private String licenseNumber;

    private Integer eduId;

    private Date createDate;

    private String phone;

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

    private String eduDepartment1;

    private String eduDepartment2;

    private String priceDepartment2;

    private String priceDepartment1;

    private String chargename2;

    private String officalname1;

    private String officalname2;

    private String firework;

    private String fireworkno;

    private String chargename1;

    private Integer areaId;

    private String flag1;

    private String flag2;

    private String flag3;

    private String flag4;

    private String flag5;

    private String flag6;

    private static final long serialVersionUID = 1L;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public String getEduDepartment1() {
        return eduDepartment1;
    }

    public void setEduDepartment1(String eduDepartment1) {
        this.eduDepartment1 = eduDepartment1 == null ? null : eduDepartment1.trim();
    }

    public String getEduDepartment2() {
        return eduDepartment2;
    }

    public void setEduDepartment2(String eduDepartment2) {
        this.eduDepartment2 = eduDepartment2 == null ? null : eduDepartment2.trim();
    }

    public String getPriceDepartment2() {
        return priceDepartment2;
    }

    public void setPriceDepartment2(String priceDepartment2) {
        this.priceDepartment2 = priceDepartment2 == null ? null : priceDepartment2.trim();
    }

    public String getPriceDepartment1() {
        return priceDepartment1;
    }

    public void setPriceDepartment1(String priceDepartment1) {
        this.priceDepartment1 = priceDepartment1 == null ? null : priceDepartment1.trim();
    }

    public String getChargename2() {
        return chargename2;
    }

    public void setChargename2(String chargename2) {
        this.chargename2 = chargename2 == null ? null : chargename2.trim();
    }

    public String getOfficalname1() {
        return officalname1;
    }

    public void setOfficalname1(String officalname1) {
        this.officalname1 = officalname1 == null ? null : officalname1.trim();
    }

    public String getOfficalname2() {
        return officalname2;
    }

    public void setOfficalname2(String officalname2) {
        this.officalname2 = officalname2 == null ? null : officalname2.trim();
    }

    public String getFirework() {
        return firework;
    }

    public void setFirework(String firework) {
        this.firework = firework == null ? null : firework.trim();
    }

    public String getFireworkno() {
        return fireworkno;
    }

    public void setFireworkno(String fireworkno) {
        this.fireworkno = fireworkno == null ? null : fireworkno.trim();
    }

    public String getChargename1() {
        return chargename1;
    }

    public void setChargename1(String chargename1) {
        this.chargename1 = chargename1 == null ? null : chargename1.trim();
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

    public String getFlag5() {
        return flag5;
    }

    public void setFlag5(String flag5) {
        this.flag5 = flag5 == null ? null : flag5.trim();
    }

    public String getFlag6() {
        return flag6;
    }

    public void setFlag6(String flag6) {
        this.flag6 = flag6 == null ? null : flag6.trim();
    }
}