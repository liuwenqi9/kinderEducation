package com.muji.zh.admin.model;

import java.util.List;

/**
 * Created by Administrator on 2018/12/20/020.
 */
public class allPaymentList {
    List<PaymentList> paymentListList;
    String titles;
    Integer status;
    public List<PaymentList> getPaymentListList() {
        return paymentListList;
    }

    public void setPaymentListList(List<PaymentList> paymentListList) {
        this.paymentListList = paymentListList;
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
