package com.muji.zh.admin.service;

import com.muji.zh.admin.model.ComType;
import com.muji.zh.admin.model.Complaint;
import com.muji.zh.admin.model.ComplaintExample;
import org.apache.ibatis.annotations.Param;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ComplaintService {
    long countByExample(ComplaintExample example);

    int deleteByExample(ComplaintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    List<Complaint> selectByExample(ComplaintExample example);

    Complaint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByExample(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKey(Complaint record);

    Map<String, Object> findBY(Integer areaId,Integer sign) throws ParseException;

    Map<String, Object> findByKid(Integer kid) throws ParseException;

    List<Complaint> findByPidBeOid(Integer id) throws ParseException;

    List<Complaint> findByFromWhoId(Integer id) throws ParseException;

    List<Complaint> findByFromWhoIdFlags(Integer pid, String flag1);



















    Map<String, List<Complaint>> findBY(Integer areaId);

    //查询历史投诉信息
    List<Complaint> selectHistoryComplaintInfo(Integer whoId);

    //删除 投诉 信息
    int deleteByIdAndWhoId(@Param("id") Integer id,@Param("whoId")Integer whoId);

    //查询 单个投诉信息
    Complaint selectByIdAndWhoId(@Param("id") Integer id,@Param("whoId") Integer whoId);


}
