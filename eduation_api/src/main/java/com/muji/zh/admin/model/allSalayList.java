package com.muji.zh.admin.model;

import java.util.List;

/**
 * Created by Administrator on 2018/12/13/013.
 */
public class allSalayList {
    List<SalaryList> salaryListList;
    String titles;
    Integer status;
    public List<SalaryList> getSalaryListList() {
        return salaryListList;
    }

    public void setSalaryListList(List<SalaryList> salaryListList) {
        this.salaryListList = salaryListList;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
