package com.muji.zh.admin.service;

import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.PaymentList;

import java.io.IOException;
import java.util.List;

public interface PaymentListService {


    PaymentList findBy(Integer sid, Integer id);


    PaymentList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PaymentList record);











    void insertImportPayList(List<PaymentList> list);

    PaymentList selectBySidAndSname(String pname, Integer sId);

    PageInfo<PaymentList> findAllByKinderName(String kName, int currentPage, int pageSize);

    List<PaymentList> fileUpload(String originalFilename, byte[] arr, String titles) throws IOException;

    PageInfo<PaymentList> choosePaymentList(Integer sId, String pname, String kindergartenName,int currentPage);


}
