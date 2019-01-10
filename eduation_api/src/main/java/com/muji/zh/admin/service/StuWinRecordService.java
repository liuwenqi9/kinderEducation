package com.muji.zh.admin.service;

import com.muji.zh.admin.model.StuWinRecord;
import com.muji.zh.admin.model.StuWinRecordExample;

import java.util.List;

public interface StuWinRecordService {
    List<StuWinRecord> findBySid(Integer id);


    long countByExample(StuWinRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(StuWinRecord record);

    List<StuWinRecord> selectByExample(StuWinRecordExample example);

    int updateByPrimaryKeySelective(StuWinRecord record);
}
