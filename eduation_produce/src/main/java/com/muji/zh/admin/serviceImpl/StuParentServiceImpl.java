package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.StuParentMapper;
import com.muji.zh.admin.mapper.StudentMapper;
import com.muji.zh.admin.model.ParentVo;
import com.muji.zh.admin.model.StuParent;
import com.muji.zh.admin.model.StuParentExample;
import com.muji.zh.admin.service.StuParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class StuParentServiceImpl implements StuParentService {
    @Autowired
    private StuParentMapper stuParentMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return stuParentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StuParent record) {
        return stuParentMapper.insert(record);
    }

    @Override
    public StuParent selectByPrimaryKey(Integer id) {
        return stuParentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(StuParent record) {
        return stuParentMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public StuParent findByStuId(Integer sid) {
        StuParentExample stuParentExample=new StuParentExample();
        StuParentExample.Criteria criteria=stuParentExample.createCriteria();
        criteria.andSidEqualTo(sid);
        return stuParentMapper.selectByExample(stuParentExample).get(0);
    }

    @Override
    public ParentVo ParentView(Integer sId) {
        return null;
    }

    @Override
    public List<StuParent> findBy(Integer id) {
        StuParentExample example=new StuParentExample();
        StuParentExample.Criteria criteria=example.createCriteria();
        criteria.andPidEqualTo(id);
        stuParentMapper.selectByExample(example);
        return  stuParentMapper.selectByExample(example);
    }

    @Override
    public int insertSelective(StuParent record) {
        return stuParentMapper.insertSelective(record);
    }

    @Override
    public StuParent findBySid_Pid(String sID) {
        System.out.println(sID);

        StuParentExample example=new StuParentExample();
        StuParentExample.Criteria criteria=example.createCriteria();
        criteria.andSidEqualTo(Integer.parseInt(sID));

        stuParentMapper.selectByExample(example);

        return  stuParentMapper.selectByExample(example).get(0);

    }
}
