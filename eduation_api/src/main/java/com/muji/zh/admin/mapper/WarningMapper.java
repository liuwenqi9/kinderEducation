package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Warning;
import com.muji.zh.admin.model.WarningExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarningMapper {
    long countByExample(WarningExample example);

    int deleteByExample(WarningExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Warning record);

    int insertSelective(Warning record);

    List<Warning> selectByExample(WarningExample example);

    Warning selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Warning record, @Param("example") WarningExample example);

    int updateByExample(@Param("record") Warning record, @Param("example") WarningExample example);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKey(Warning record);
}