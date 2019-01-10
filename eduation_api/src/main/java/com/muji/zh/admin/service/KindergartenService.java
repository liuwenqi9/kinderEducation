package com.muji.zh.admin.service;

import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.*;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface KindergartenService {
    int insertSelective(Kindergarten record);
    //根据地区查询公办幼儿园个数
    int findByAreaIdToType(Integer areaId, Integer typeID,Integer sign);
    //统计这个地区的幼儿园个数
    int sumKinder(Integer areaId,Integer sign);

    SalaryListVo chooseSalaryList(Integer pId, String sname);

//    List<Kindergarten> findById(Integer kindId);
//Kindergarten findById(Integer kindId);


    int deleteByPrimaryKey(Integer kId);

    int insert(Kindergarten record);



    List<Kindergarten> selectByExample(KindergartenExample example);

    Kindergarten selectByPrimaryKey(Integer kId);


    int updateByPrimaryKeySelective(Kindergarten record);

    int updateByPrimaryKey(Kindergarten record);


    List<Kindergarten> findByareaID(String area_id);

    Long  countTotal(EduUser eduUser);

    List<Kindergarten> findAll();
    List<Kindergarten> sel();





















    int insertSelective(Kindergarten record, String date, String eduname, String legalName, Integer id);
    //根据地区查询公办幼儿园个数
    int findByAreaIdToType(Integer areaId, Integer typeID);
    //统计这个地区的幼儿园个数
    int sumKinder(Integer areaId);
    PageInfo<SalaryList> findAllByKinderName(String kinderName, int currentPage, int pageSize);
    PageInfo<SalaryList> chooseSalaryList(Integer pId, String sname,String kindergartenName,int currentPage);
    List<SalaryList> fileupload(String fileName, byte[] arr) throws IOException;
    Kindergarten findById(Integer kindId);

    String fileDownload(String fileName);

    String getKname(Integer kindId);

    int editKinder(Kindergarten kindergarten, String date, String eduname, String legalName, Integer id);

    void Upload(byte[] arr, long size, String fileType);


}
