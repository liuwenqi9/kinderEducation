package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.ParentMapper;
import com.muji.zh.admin.model.Parent;
import com.muji.zh.admin.model.ParentExample;
import com.muji.zh.admin.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private ParentMapper parentMapper;

    @Override
    public int insert(Parent record) {
        return parentMapper.insert(record);
    }

    @Override
    public Parent selectByPrimaryKey(Integer id) {
        return parentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Parent record) {
        return parentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return parentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Parent login(Parent parent) {

        ParentExample example=new ParentExample();
        ParentExample.Criteria criteria=example.createCriteria();
        criteria.andPasswordEqualTo(parent.getPassword());
        criteria.andPhoneEqualTo(parent.getPhone());
        List<Parent> list= parentMapper.selectByExample(example);
        try{
            return list.get(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }

    }


}
