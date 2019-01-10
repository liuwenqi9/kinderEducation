package com.muji.zh.admin.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/12/30/030.
 */
public class PraVo implements Serializable {
    private Integer id;
    private Integer kinder_id;
    private String pname;
    private String sex;
    private String legal_person;
    private String legal_parson_name;
    private String legal_parson_phone;
    private Integer clas_director;
    private String sname;
    private Integer wages;
    private String phone;
    private String id_card;
    private String bank_card_number;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKinder_id() {
        return kinder_id;
    }

    public void setKinder_id(Integer kinder_id) {
        this.kinder_id = kinder_id;
    }

    public String getLegal_person() {
        return legal_person;
    }

    public void setLegal_person(String legal_person) {
        this.legal_person = legal_person;
    }

    public String getLegal_parson_name() {
        return legal_parson_name;
    }

    public void setLegal_parson_name(String legal_parson_name) {
        this.legal_parson_name = legal_parson_name;
    }

    public String getLegal_parson_phone() {
        return legal_parson_phone;
    }

    public void setLegal_parson_phone(String legal_parson_phone) {
        this.legal_parson_phone = legal_parson_phone;
    }

    public Integer getClas_director() {
        return clas_director;
    }

    public void setClas_director(Integer clas_director) {
        this.clas_director = clas_director;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getWages() {
        return wages;
    }

    public void setWages(Integer wages) {
        this.wages = wages;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getBank_card_number() {
        return bank_card_number;
    }

    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number;
    }
}
