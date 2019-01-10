package com.muji.zh.admin.model;

import java.io.Serializable;

public class Practitioner implements Serializable {
    private Integer id;

    private String pname;

    private String sex;

    private String birthday;

    private Integer age;

    @Override
    public String toString() {
        return "Practitioner{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                ", bankCardNumber='" + bankCardNumber + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", arrderss='" + arrderss + '\'' +
                ", idCard='" + idCard + '\'' +
                ", graduation='" + graduation + '\'' +
                ", certificate='" + certificate + '\'' +
                ", isussingDeartment='" + isussingDeartment + '\'' +
                ", kinderId=" + kinderId +
                ", legalPerson='" + legalPerson + '\'' +
                ", legalParsonName='" + legalParsonName + '\'' +
                ", legalParsonPhone='" + legalParsonPhone + '\'' +
                ", wages=" + wages +
                ", socialSecurity='" + socialSecurity + '\'' +
                ", pId=" + pId +
                ", positionalTitles='" + positionalTitles + '\'' +
                ", mentalImage='" + mentalImage + '\'' +
                ", mentalHealth='" + mentalHealth + '\'' +
                ", physicalImage='" + physicalImage + '\'' +
                ", physicalHealth='" + physicalHealth + '\'' +
                ", image='" + image + '\'' +
                ", ubranId=" + ubranId +
                ", areaId=" + areaId +
                ", clasDirector=" + clasDirector +
                ", sign=" + sign +
                ", falg1='" + falg1 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", flag3='" + flag3 + '\'' +
                ", flag4='" + flag4 + '\'' +
                '}';
    }

    private String bankCardNumber;

    private String nativePlace;

    private String phone;

    private String email;

    private String arrderss;

    private String idCard;
    //id_card

    private String graduation;

    private String certificate;

    private String isussingDeartment;

    private Integer kinderId;

    private String legalPerson;

    private String legalParsonName;

    private String legalParsonPhone;

    private Integer wages;

    private String socialSecurity;

    private Integer pId;

    private String positionalTitles;

    private String mentalImage;

    private String mentalHealth;

    private String physicalImage;

    private String physicalHealth;

    private String image;

    private Integer ubranId;

    private Integer areaId;

    private Integer clasDirector;

    private Integer sign;

    private String falg1;

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

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber == null ? null : bankCardNumber.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
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

    public String getArrderss() {
        return arrderss;
    }

    public void setArrderss(String arrderss) {
        this.arrderss = arrderss == null ? null : arrderss.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation == null ? null : graduation.trim();
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate == null ? null : certificate.trim();
    }

    public String getIsussingDeartment() {
        return isussingDeartment;
    }

    public void setIsussingDeartment(String isussingDeartment) {
        this.isussingDeartment = isussingDeartment == null ? null : isussingDeartment.trim();
    }

    public Integer getKinderId() {
        return kinderId;
    }

    public void setKinderId(Integer kinderId) {
        this.kinderId = kinderId;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public String getLegalParsonName() {
        return legalParsonName;
    }

    public void setLegalParsonName(String legalParsonName) {
        this.legalParsonName = legalParsonName == null ? null : legalParsonName.trim();
    }

    public String getLegalParsonPhone() {
        return legalParsonPhone;
    }

    public void setLegalParsonPhone(String legalParsonPhone) {
        this.legalParsonPhone = legalParsonPhone == null ? null : legalParsonPhone.trim();
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity == null ? null : socialSecurity.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getPositionalTitles() {
        return positionalTitles;
    }

    public void setPositionalTitles(String positionalTitles) {
        this.positionalTitles = positionalTitles == null ? null : positionalTitles.trim();
    }

    public String getMentalImage() {
        return mentalImage;
    }

    public void setMentalImage(String mentalImage) {
        this.mentalImage = mentalImage == null ? null : mentalImage.trim();
    }

    public String getMentalHealth() {
        return mentalHealth;
    }

    public void setMentalHealth(String mentalHealth) {
        this.mentalHealth = mentalHealth == null ? null : mentalHealth.trim();
    }

    public String getPhysicalImage() {
        return physicalImage;
    }

    public void setPhysicalImage(String physicalImage) {
        this.physicalImage = physicalImage == null ? null : physicalImage.trim();
    }

    public String getPhysicalHealth() {
        return physicalHealth;
    }

    public void setPhysicalHealth(String physicalHealth) {
        this.physicalHealth = physicalHealth == null ? null : physicalHealth.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getUbranId() {
        return ubranId;
    }

    public void setUbranId(Integer ubranId) {
        this.ubranId = ubranId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getClasDirector() {
        return clasDirector;
    }

    public void setClasDirector(Integer clasDirector) {
        this.clasDirector = clasDirector;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
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

    public String getFlag4() {
        return flag4;
    }

    public void setFlag4(String flag4) {
        this.flag4 = flag4 == null ? null : flag4.trim();
    }
}