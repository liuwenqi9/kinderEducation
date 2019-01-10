package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.PartWarn;
import com.muji.zh.admin.model.PartWarnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartWarnMapper {
    long countByExample(PartWarnExample example);

    int deleteByExample(PartWarnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartWarn record);

    int insertSelective(PartWarn record);

    List<PartWarn> selectByExample(PartWarnExample example);

    PartWarn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartWarn record, @Param("example") PartWarnExample example);

    int updateByExample(@Param("record") PartWarn record, @Param("example") PartWarnExample example);

    int updateByPrimaryKeySelective(PartWarn record);

    int updateByPrimaryKey(PartWarn record);
}