package com.muji.zh.admin.service;

import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.Education;
import com.muji.zh.admin.model.EducationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationService {
    long countByExample(EducationExample example);

    int deleteByExample(EducationExample example);

    int deleteByPrimaryKey(Integer epId);

    int insert(Education record);

    int insertSelective(Education record);

    List<Education> selectByExample(EducationExample example);

    Education selectByPrimaryKey(Integer epId);

    int updateByExampleSelective(@Param("record") Education record, @Param("example") EducationExample example);

    int updateByExample(@Param("record") Education record, @Param("example") EducationExample example);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);



    Education findByAreaId(String area_id);



    public PageInfo<Education> findByUbranID(Integer pageNum, Integer pageSize, int id);

    List<Education> distinctName (Integer id);

    Education findById(Integer eduId);
}
