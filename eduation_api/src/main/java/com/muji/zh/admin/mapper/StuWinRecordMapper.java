package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.StuWinRecord;
import com.muji.zh.admin.model.StuWinRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuWinRecordMapper {
    long countByExample(StuWinRecordExample example);

    int deleteByExample(StuWinRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuWinRecord record);

    int insertSelective(StuWinRecord record);

    List<StuWinRecord> selectByExample(StuWinRecordExample example);

    StuWinRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuWinRecord record, @Param("example") StuWinRecordExample example);

    int updateByExample(@Param("record") StuWinRecord record, @Param("example") StuWinRecordExample example);

    int updateByPrimaryKeySelective(StuWinRecord record);

    int updateByPrimaryKey(StuWinRecord record);
}