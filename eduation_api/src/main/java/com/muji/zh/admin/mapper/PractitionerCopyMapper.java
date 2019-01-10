package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.PractitionerCopy;
import com.muji.zh.admin.model.PractitionerCopyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PractitionerCopyMapper {
    long countByExample(PractitionerCopyExample example);

    int deleteByExample(PractitionerCopyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PractitionerCopy record);

    int insertSelective(PractitionerCopy record);

    List<PractitionerCopy> selectByExample(PractitionerCopyExample example);

    PractitionerCopy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PractitionerCopy record, @Param("example") PractitionerCopyExample example);

    int updateByExample(@Param("record") PractitionerCopy record, @Param("example") PractitionerCopyExample example);

    int updateByPrimaryKeySelective(PractitionerCopy record);

    int updateByPrimaryKey(PractitionerCopy record);
}