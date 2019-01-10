package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.PartWinRecordMapper;
import com.muji.zh.admin.model.PartWinRecordExample;
import com.muji.zh.admin.service.PartWinRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class PartWinRecordImpl  implements PartWinRecord {
    @Autowired
    private PartWinRecordMapper partWinRecordMapper;

    @Override
    public long countByExample(PartWinRecordExample example) {
        return partWinRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PartWinRecordExample example) {
        return partWinRecordMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return partWinRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(com.muji.zh.admin.model.PartWinRecord record) {
        return partWinRecordMapper.insert(record);
    }

    @Override
    public int insertSelective(com.muji.zh.admin.model.PartWinRecord record) {
        return partWinRecordMapper.insertSelective(record);
    }

    @Override
    public List<com.muji.zh.admin.model.PartWinRecord> selectByExample(PartWinRecordExample example) {
        return partWinRecordMapper.selectByExample(example);
    }

    @Override
    public com.muji.zh.admin.model.PartWinRecord selectByPrimaryKey(Integer id) {
        return partWinRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(com.muji.zh.admin.model.PartWinRecord record, PartWinRecordExample example) {
        return partWinRecordMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(com.muji.zh.admin.model.PartWinRecord record, PartWinRecordExample example) {
        return partWinRecordMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(com.muji.zh.admin.model.PartWinRecord record) {
        return partWinRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(com.muji.zh.admin.model.PartWinRecord record) {
        return partWinRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByIdAndPid(Integer id, Integer pId) {
        return partWinRecordMapper.deleteByIdAndPid(id,pId);
    }

    @Override
    public List<com.muji.zh.admin.model.PartWinRecord> selectByPid(Integer pId) {
        return partWinRecordMapper.selectByPid(pId);
    }

    @Override
    public com.muji.zh.admin.model.PartWinRecord selectByPidAndId(Integer id,Integer pId) {
        return partWinRecordMapper.selectByPidAndId(id,pId);
    }
}
