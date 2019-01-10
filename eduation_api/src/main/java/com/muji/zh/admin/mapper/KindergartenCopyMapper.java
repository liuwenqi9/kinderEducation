package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.KindergartenCopy;
import com.muji.zh.admin.model.KindergartenCopyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KindergartenCopyMapper {
    long countByExample(KindergartenCopyExample example);

    int deleteByExample(KindergartenCopyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KindergartenCopy record);

    int insertSelective(KindergartenCopy record);

    List<KindergartenCopy> selectByExample(KindergartenCopyExample example);

    KindergartenCopy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KindergartenCopy record, @Param("example") KindergartenCopyExample example);

    int updateByExample(@Param("record") KindergartenCopy record, @Param("example") KindergartenCopyExample example);

    int updateByPrimaryKeySelective(KindergartenCopy record);

    int updateByPrimaryKey(KindergartenCopy record);
}