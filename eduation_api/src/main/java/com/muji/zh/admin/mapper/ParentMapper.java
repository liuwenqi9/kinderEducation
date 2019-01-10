package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Parent;
import com.muji.zh.admin.model.ParentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParentMapper {
    long countByExample(ParentExample example);

    int deleteByExample(ParentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Parent record);

    int insertSelective(Parent record);

    List<Parent> selectByExample(ParentExample example);

    Parent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Parent record, @Param("example") ParentExample example);

    int updateByExample(@Param("record") Parent record, @Param("example") ParentExample example);

    int updateByPrimaryKeySelective(Parent record);

    int updateByPrimaryKey(Parent record);
}