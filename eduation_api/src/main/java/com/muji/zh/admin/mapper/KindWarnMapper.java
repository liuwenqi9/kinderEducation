package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.KindWarn;
import com.muji.zh.admin.model.KindWarnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KindWarnMapper {
    long countByExample(KindWarnExample example);

    int deleteByExample(KindWarnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KindWarn record);

    int insertSelective(KindWarn record);

    List<KindWarn> selectByExample(KindWarnExample example);

    KindWarn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KindWarn record, @Param("example") KindWarnExample example);

    int updateByExample(@Param("record") KindWarn record, @Param("example") KindWarnExample example);

    int updateByPrimaryKeySelective(KindWarn record);

    int updateByPrimaryKey(KindWarn record);
}