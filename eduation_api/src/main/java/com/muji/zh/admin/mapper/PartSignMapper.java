package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.PartSign;
import com.muji.zh.admin.model.PartSignExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartSignMapper {
    long countByExample(PartSignExample example);

    int deleteByExample(PartSignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartSign record);

    int insertSelective(PartSign record);

    List<PartSign> selectByExample(PartSignExample example);

    PartSign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartSign record, @Param("example") PartSignExample example);

    int updateByExample(@Param("record") PartSign record, @Param("example") PartSignExample example);

    int updateByPrimaryKeySelective(PartSign record);

    int updateByPrimaryKey(PartSign record);
}