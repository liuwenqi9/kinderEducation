package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.ComTypeMapper;
import com.muji.zh.admin.model.ComType;
import com.muji.zh.admin.model.ComTypeExample;
import com.muji.zh.admin.service.ComTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ComTypeServiceImpl implements ComTypeService {
    @Autowired
    private ComTypeMapper comTypeMapper;


    @Override
    public List<ComType> findAll() {

        ComTypeExample comTypeExample=new ComTypeExample();
        ComTypeExample.Criteria criteria=comTypeExample.createCriteria();

        return comTypeMapper.selectByExample(comTypeExample);
    }

    @Override
    public ComType selectByPrimaryKey(Integer id) {
        return comTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ComType> selectAllComplaintType() {
        return comTypeMapper.selectAllComplaintType();
    }

}
