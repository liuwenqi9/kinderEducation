package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.PartWinRecord;
import com.muji.zh.admin.model.PartWinRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartWinRecordMapper {
    long countByExample(PartWinRecordExample example);

    int deleteByExample(PartWinRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartWinRecord record);

    int insertSelective(PartWinRecord record);

    List<PartWinRecord> selectByExample(PartWinRecordExample example);

    PartWinRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartWinRecord record, @Param("example") PartWinRecordExample example);

    int updateByExample(@Param("record") PartWinRecord record, @Param("example") PartWinRecordExample example);

    int updateByPrimaryKeySelective(PartWinRecord record);

    int updateByPrimaryKey(PartWinRecord record);






    ///从业者删除 获奖记录
    int deleteByIdAndPid(@Param("id")Integer id,@Param("pId")Integer pId);

    //查询  从业者所有得获奖记录
    List<PartWinRecord> selectByPid(Integer pId);

    //从业者查询单个 获奖记录
    PartWinRecord selectByPidAndId(@Param("id") Integer id,@Param("pId") Integer pId);
}