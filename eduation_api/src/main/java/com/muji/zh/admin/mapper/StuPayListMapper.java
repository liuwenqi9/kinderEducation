package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.StuPayList;
import com.muji.zh.admin.model.StuPayListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuPayListMapper {
    long countByExample(StuPayListExample example);

    int deleteByExample(StuPayListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuPayList record);

    int insertSelective(StuPayList record);

    List<StuPayList> selectByExample(StuPayListExample example);

    StuPayList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuPayList record, @Param("example") StuPayListExample example);

    int updateByExample(@Param("record") StuPayList record, @Param("example") StuPayListExample example);

    int updateByPrimaryKeySelective(StuPayList record);

    int updateByPrimaryKey(StuPayList record);

    void updateList(@Param(value = "list")List<StuPayList> stuPayListList);
}