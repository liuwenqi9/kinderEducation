package com.muji.zh.admin.serviceImpl;
import com.muji.zh.admin.mapper.PartLoginMapper;
import com.muji.zh.admin.model.PartLogin;
import com.muji.zh.admin.model.PartLoginExample;
import  com.muji.zh.admin.service.PartLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class PartLoginServiceImpl implements PartLoginService {
    @Autowired
    private PartLoginMapper partLoginMapper;

    @Override
    public long countByExample(PartLoginExample example) {
        return partLoginMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PartLoginExample example) {
        return partLoginMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return partLoginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PartLogin record) {
        return partLoginMapper.insert(record);
    }

    @Override
    public int insertSelective(PartLogin record) {
        return partLoginMapper.insertSelective(record);
    }

    @Override
    public List<PartLogin> selectByExample(PartLoginExample example) {
        return partLoginMapper.selectByExample(example);
    }

    @Override
    public PartLogin selectByPrimaryKey(Integer id) {
        return partLoginMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(PartLogin record, PartLoginExample example) {
        return partLoginMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(PartLogin record, PartLoginExample example) {
        return partLoginMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(PartLogin record) {
        return partLoginMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKey(PartLogin record) {
        return partLoginMapper.updateByPrimaryKey(record);
    }

    @Override
    public Integer selectByIdAndPassword(Integer id, String password) {
        return partLoginMapper.selectByIdAndPassword(id,password);
    }

    @Override
    public String selectImageById(Integer id) {
        return partLoginMapper.selectImageById(id);
    }
}
