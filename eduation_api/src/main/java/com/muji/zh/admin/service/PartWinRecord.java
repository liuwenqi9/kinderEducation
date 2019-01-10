package com.muji.zh.admin.service;

import com.muji.zh.admin.model.PartWinRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartWinRecord {
    long countByExample(PartWinRecordExample example);

    int deleteByExample(PartWinRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(com.muji.zh.admin.model.PartWinRecord record);

    int insertSelective(com.muji.zh.admin.model.PartWinRecord record);

    List<com.muji.zh.admin.model.PartWinRecord> selectByExample(PartWinRecordExample example);

    com.muji.zh.admin.model.PartWinRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") com.muji.zh.admin.model.PartWinRecord record, @Param("example") PartWinRecordExample example);

    int updateByExample(@Param("record") com.muji.zh.admin.model.PartWinRecord record, @Param("example") PartWinRecordExample example);

    int updateByPrimaryKeySelective(com.muji.zh.admin.model.PartWinRecord record);

    int updateByPrimaryKey(com.muji.zh.admin.model.PartWinRecord record);

    ///从业者删除 获奖记录
    int deleteByIdAndPid(@Param("id") Integer id, @Param("pId") Integer pId);

    //查询  从业者所有得获奖记录
    List<com.muji.zh.admin.model.PartWinRecord> selectByPid(Integer pId);

    //从业者查询单个 获奖记录
    com.muji.zh.admin.model.PartWinRecord selectByPidAndId(@Param("id") Integer id, @Param("pId") Integer pId);
}
