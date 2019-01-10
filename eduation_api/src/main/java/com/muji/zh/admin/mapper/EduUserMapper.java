package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.EduUser;
import com.muji.zh.admin.model.EduUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EduUserMapper {
    long countByExample(EduUserExample example);

    int deleteByExample(EduUserExample example);

    int deleteByPrimaryKey(Integer epId);

    int insert(EduUser record);

    int insertSelective(EduUser record);

    List<EduUser> selectByExample(EduUserExample example);

    EduUser selectByPrimaryKey(Integer epId);

    int updateByExampleSelective(@Param("record") EduUser record, @Param("example") EduUserExample example);

    int updateByExample(@Param("record") EduUser record, @Param("example") EduUserExample example);

    int updateByPrimaryKeySelective(EduUser record);

    int updateByPrimaryKey(EduUser record);
}