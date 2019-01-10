package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.ClassType;
import com.muji.zh.admin.model.ClassTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassTypeMapper {
    long countByExample(ClassTypeExample example);

    int deleteByExample(ClassTypeExample example);

    int deleteByPrimaryKey(Integer ctId);

    int insert(ClassType record);

    int insertSelective(ClassType record);

    List<ClassType> selectByExample(ClassTypeExample example);

    ClassType selectByPrimaryKey(Integer ctId);

    int updateByExampleSelective(@Param("record") ClassType record, @Param("example") ClassTypeExample example);

    int updateByExample(@Param("record") ClassType record, @Param("example") ClassTypeExample example);

    int updateByPrimaryKeySelective(ClassType record);

    int updateByPrimaryKey(ClassType record);

    List<ClassType> findAll();
}