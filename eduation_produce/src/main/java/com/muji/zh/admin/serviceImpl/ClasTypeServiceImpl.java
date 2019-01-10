package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.ClassTypeMapper;
import com.muji.zh.admin.model.ClassType;
import com.muji.zh.admin.model.ClassTypeExample;
import com.muji.zh.admin.service.ClasTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ClasTypeServiceImpl implements ClasTypeService {
    @Autowired
    private ClassTypeMapper classTypeMapper;
    @Override
    public List<ClassType> finds() {
        ClassTypeExample example =new ClassTypeExample();
        ClassTypeExample.Criteria criteria=example.createCriteria();

        return classTypeMapper.selectByExample(example);
    }
}
