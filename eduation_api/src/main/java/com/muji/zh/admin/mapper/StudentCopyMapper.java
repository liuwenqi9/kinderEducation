package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.StudentCopy;
import com.muji.zh.admin.model.StudentCopyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCopyMapper {
    long countByExample(StudentCopyExample example);

    int deleteByExample(StudentCopyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentCopy record);

    int insertSelective(StudentCopy record);

    List<StudentCopy> selectByExample(StudentCopyExample example);

    StudentCopy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentCopy record, @Param("example") StudentCopyExample example);

    int updateByExample(@Param("record") StudentCopy record, @Param("example") StudentCopyExample example);

    int updateByPrimaryKeySelective(StudentCopy record);

    int updateByPrimaryKey(StudentCopy record);
}