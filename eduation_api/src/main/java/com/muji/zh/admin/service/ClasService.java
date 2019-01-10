package com.muji.zh.admin.service;

import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ClasService {

    long countByExample(ClasExample example);

    int deleteByExample(ClasExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(Clas record);

    int insertSelective(Clas record);

    List<Clas> selectByExample(ClasExample example);

    Clas selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") Clas record, @Param("example") ClasExample example);

    int updateByExample(@Param("record") Clas record, @Param("example") ClasExample example);

    int updateByPrimaryKeySelective(Clas record);

    int updateByPrimaryKey(Clas record);





    List<List<Clas>>findBy(Integer areaId, List<ClassType> typeList,Integer sign);



    Map<String, String> findBySex(Integer areaId, List<ClassType> typeList, String sex);


    List<Clas> findByToKid(int parseInt);

    Long countToClas(Integer getkId);






















    List<List<Clas>>findBy(Integer areaId, List<ClassType> typeList);

    //Map<String, String> findBySex(Integer areaId, List<ClassType> typeList, String sex);


    long selectCount(Integer kindId);

    boolean deleteClass(Integer id);

    Clas findById(Integer cId);

    List<ClassType> getClassType();

    List<Practitioner> findPractitionerList(Integer kid);

    int update(Clas clas);

    int insterClass(Clas clas);

    PageInfo<ClassVo> selectClassByName(Integer kindId, String cname, int currentPage);

    long checkCount(Integer kindId, String cname);

    PageInfo<ClassVo> selectClass(Integer kindId, int currentPage, int pageSize);



}

