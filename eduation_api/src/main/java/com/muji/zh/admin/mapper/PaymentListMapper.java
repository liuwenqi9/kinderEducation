package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.PaymentList;
import com.muji.zh.admin.model.PaymentListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentListMapper {
    long countByExample(PaymentListExample example);

    int deleteByExample(PaymentListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaymentList record);

    int insertSelective(PaymentList record);

    List<PaymentList> selectByExample(PaymentListExample example);

    PaymentList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaymentList record, @Param("example") PaymentListExample example);

    int updateByExample(@Param("record") PaymentList record, @Param("example") PaymentListExample example);

    int updateByPrimaryKeySelective(PaymentList record);

    int updateByPrimaryKey(PaymentList record);

    //void insertPayList(List<PaymentList> list);









    void insertImportPayList(List<PaymentList> list);

    List<PaymentList> selectPartView(@Param("kinderName") String kinderName);

    List<PaymentList> selectBypNameAndsId(@Param("pname") String pname,@Param("sId") Integer sId,@Param("kinderName") String kinderName);

}