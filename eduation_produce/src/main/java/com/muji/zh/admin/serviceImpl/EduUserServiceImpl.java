package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.EduUserMapper;
import com.muji.zh.admin.model.EduUser;
import com.muji.zh.admin.model.EduUserExample;
import com.muji.zh.admin.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class EduUserServiceImpl implements EduUserService {
    @Autowired
    private EduUserMapper eduUserMapper;

    @Override
    public long countByExample(EduUserExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(EduUserExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer epId) {
        return 0;
    }

    @Override
    public int insert(EduUser record) {
        return 0;
    }

    @Override
    public int insertSelective(EduUser record) {
        return 0;
    }

    @Override
    public List<EduUser> selectByExample(EduUserExample example) {
        return null;
    }

    @Override
    public EduUser selectByPrimaryKey(Integer epId) {
        return null;
    }

    @Override
    public int updateByExampleSelective(EduUser record, EduUserExample example) {
        return 0;
    }

    @Override
    public int updateByExample(EduUser record, EduUserExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(EduUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(EduUser record) {
        return 0;
    }

    @Override
    public EduUser login(EduUser eduUser) {
        EduUserExample eduUserExample = new EduUserExample();
        EduUserExample.Criteria criteria = eduUserExample.createCriteria();
        criteria.andEpIdEqualTo(eduUser.getEpId());
        criteria.andPasswordEqualTo(eduUser.getPassword());
        List<EduUser> list = eduUserMapper.selectByExample(eduUserExample);
        try{
            return list.get(0);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
       return null;
    }
}
