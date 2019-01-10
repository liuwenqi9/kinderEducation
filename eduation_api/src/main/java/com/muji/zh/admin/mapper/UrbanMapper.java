package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Urban;
import com.muji.zh.admin.model.UrbanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UrbanMapper {
    long countByExample(UrbanExample example);

    int deleteByExample(UrbanExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Urban record);

    int insertSelective(Urban record);

    List<Urban> selectByExample(UrbanExample example);

    Urban selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Urban record, @Param("example") UrbanExample example);

    int updateByExample(@Param("record") Urban record, @Param("example") UrbanExample example);

    int updateByPrimaryKeySelective(Urban record);

    int updateByPrimaryKey(Urban record);
}