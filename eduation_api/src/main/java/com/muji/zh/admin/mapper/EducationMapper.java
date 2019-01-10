package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Education;
import com.muji.zh.admin.model.EducationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EducationMapper {
    long countByExample(EducationExample example);

    int deleteByExample(EducationExample example);

    int deleteByPrimaryKey(Integer eId);

    int insert(Education record);

    int insertSelective(Education record);

    List<Education> selectByExample(EducationExample example);

    Education selectByPrimaryKey(Integer eId);

    int updateByExampleSelective(@Param("record") Education record, @Param("example") EducationExample example);

    int updateByExample(@Param("record") Education record, @Param("example") EducationExample example);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);
    //根据市 级id 查询下级教育平台
    List<Education> distinctName (Integer id);










    Education selectByName(@Param("ename") String ename);
}