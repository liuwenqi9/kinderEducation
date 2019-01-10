package com.muji.zh.admin.service;

import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.*;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PractitionerService {
    long countByExample(PractitionerExample example);

    int deleteByExample(PractitionerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(com.muji.zh.admin.model.Practitioner record);

    int insertSelective(com.muji.zh.admin.model.Practitioner record);

    List<com.muji.zh.admin.model.Practitioner> selectByExample(PractitionerExample example);

    com.muji.zh.admin.model.Practitioner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") com.muji.zh.admin.model.Practitioner record, @Param("example") PractitionerExample example);

    int updateByExample(@Param("record") com.muji.zh.admin.model.Practitioner record, @Param("example") PractitionerExample example);

    int updateByPrimaryKeySelective(com.muji.zh.admin.model.Practitioner record);

    int updateByPrimaryKey(com.muji.zh.admin.model.Practitioner record);

    Map<String, String> findByAreaIDToSex(Integer areaId, List<Station> list, String s,Integer sign);

    Map<String, String> findByAreaIDToSexTotal(Integer areaId, List<Station> list,Integer sign);

    int findCertificateYes(Integer areaId,int typeid,Integer sign);

    int findCertificateTotal(Integer areaId, int typeid,Integer sign);


    Map<String,Object> findByKid(Integer kid, String sex, List<Station> stationList);


    long findByQs(String flag1, Integer kid, String type);

    PageInfo<Practitioner> findByLikeName(String kinderName, String studentname, String phone, EduUser eduUser, Integer pn);

    List<Practitioner> findByKidToPract(Integer getkId);

    long countTotal(EduUser eduUser);

    Map<String, Long> findCountBY(Integer getkId, List<Station> stationList);

    List<Practitioner> findAll();

    Integer countByKid(Integer kid);

    Map<String, Object> findPart(Integer kid, List<Station> stationList);



























    List<ParentService> findByLikeName(String kinderName, Integer id, String studentnmae);




    Map<String, String> findByAreaIDToSex(Integer areaId, List<Station> list, String s);

    Map<String, String> findByAreaIDToSexTotal(Integer areaId, List<Station> list);

    int findCertificateYes(Integer areaId,int typeid);

    int findCertificateTotal(Integer areaId, int typeid);

    List<Practitioner> findPraList(Integer kindId);

    List<Practitioner> choosePra(String pname, String phone, Integer kindId);

    int fileupload(String originalFilename, byte[] arr, KinderLegal kinderLegal) throws IOException;

    PageInfo<PraVo> getPraVoList(Integer id, int currentPage, int pageSize);

    long getCount(Integer kindId);

    boolean deletePra(Integer id);

    Practitioner findById(Integer cId);

    boolean update(Practitioner practitioner);

    void praInster(Practitioner practitioner);

    PageInfo<PraVo> checkPra(Integer kindId, String pname, int currentPage);

    long checkCount(Integer id,String pname);


}
