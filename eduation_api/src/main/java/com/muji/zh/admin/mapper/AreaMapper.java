package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Area;
import com.muji.zh.admin.model.AreaExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    long countByExample(AreaExample example);

    int deleteByExample(AreaExample example);

    int deleteByPrimaryKey(Integer aId);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample(AreaExample example);

    Area selectByPrimaryKey(Integer aId);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);


    //根据市级id 查询县级去重
    List<Area> dinstinctName(Integer ubranId);

}