package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.StuParent;
import com.muji.zh.admin.model.StuParentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuParentMapper {
    long countByExample(StuParentExample example);

    int deleteByExample(StuParentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuParent record);

    int insertSelective(StuParent record);

    List<StuParent> selectByExample(StuParentExample example);

    StuParent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuParent record, @Param("example") StuParentExample example);

    int updateByExample(@Param("record") StuParent record, @Param("example") StuParentExample example);

    int updateByPrimaryKeySelective(StuParent record);

    int updateByPrimaryKey(StuParent record);
}