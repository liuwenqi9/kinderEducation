package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.CourseType;
import com.muji.zh.admin.model.CourseTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseTypeMapper {
    long countByExample(CourseTypeExample example);

    int deleteByExample(CourseTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseType record);

    int insertSelective(CourseType record);

    List<CourseType> selectByExample(CourseTypeExample example);

    CourseType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseType record, @Param("example") CourseTypeExample example);

    int updateByExample(@Param("record") CourseType record, @Param("example") CourseTypeExample example);

    int updateByPrimaryKeySelective(CourseType record);

    int updateByPrimaryKey(CourseType record);
}