package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.KindergartenType;
import com.muji.zh.admin.model.KindergartenTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KindergartenTypeMapper {
    long countByExample(KindergartenTypeExample example);

    int deleteByExample(KindergartenTypeExample example);

    int deleteByPrimaryKey(Integer ktId);

    int insert(KindergartenType record);

    int insertSelective(KindergartenType record);

    List<KindergartenType> selectByExample(KindergartenTypeExample example);

    KindergartenType selectByPrimaryKey(Integer ktId);

    int updateByExampleSelective(@Param("record") KindergartenType record, @Param("example") KindergartenTypeExample example);

    int updateByExample(@Param("record") KindergartenType record, @Param("example") KindergartenTypeExample example);

    int updateByPrimaryKeySelective(KindergartenType record);

    int updateByPrimaryKey(KindergartenType record);
}