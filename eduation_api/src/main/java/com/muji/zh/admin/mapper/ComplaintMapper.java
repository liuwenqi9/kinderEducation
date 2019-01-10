package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Complaint;
import com.muji.zh.admin.model.ComplaintExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplaintMapper {




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




    List<Complaint> findBy(Integer areaId);
    List<Complaint> findByAreaId(Integer areaId);
    List<Complaint> findByPartCom(Integer areaId);
    List<Complaint> findByPartComAreaId(@Param("area_id")Integer areaId);



    List<Complaint> findByKidToParent(@Param("kid")Integer kid) ;
    List<Complaint> findByKidToPractioner(@Param("kid")Integer kid) ;










    //查询历史投诉信息
    List<Complaint> selectHistoryComplaintInfo(Integer whoId);

    //删除 投诉 信息
    int deleteByIdAndWhoId(@Param("id") Integer id,@Param("whoId")Integer whoId);

    //查询 单个投诉信息
    Complaint selectByIdAndWhoId(@Param("id") Integer id,@Param("whoId") Integer whoId);
}