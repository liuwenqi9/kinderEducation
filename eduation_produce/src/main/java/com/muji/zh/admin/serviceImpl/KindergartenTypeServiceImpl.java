package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.KindergartenTypeMapper;
import com.muji.zh.admin.model.KindergartenType;
import com.muji.zh.admin.model.KindergartenTypeExample;
import com.muji.zh.admin.service.KindergrationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class KindergartenTypeServiceImpl implements KindergrationTypeService {
    @Autowired
    private KindergartenTypeMapper kindergartenTypeMapper;


    @Override
    public long countByExample(KindergartenTypeExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(KindergartenTypeExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer ktId) {
        return 0;
    }

    @Override
    public int insert(KindergartenType record) {
        return 0;
    }

    @Override
    public int insertSelective(KindergartenType record) {
        return kindergartenTypeMapper.insertSelective(record);
    }

    @Override
    public List<KindergartenType> selectByExample(KindergartenTypeExample example) {
        return null;
    }

    @Override
    public KindergartenType selectByPrimaryKey(Integer ktId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(KindergartenType record, KindergartenTypeExample example) {
        return 0;
    }

    @Override
    public int updateByExample(KindergartenType record, KindergartenTypeExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(KindergartenType record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(KindergartenType record) {
        return 0;
    }

    @Override
    public List<KindergartenType> distinct() {
        KindergartenTypeExample example=new KindergartenTypeExample();
        return kindergartenTypeMapper.selectByExample(example);
    }
}
