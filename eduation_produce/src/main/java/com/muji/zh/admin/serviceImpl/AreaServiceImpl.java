package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.AreaMapper;
import com.muji.zh.admin.model.Area;
import com.muji.zh.admin.model.AreaExample;
import com.muji.zh.admin.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> dinstinctName(Integer id) {
        return areaMapper.dinstinctName(id);
    }

    @Override
    public List<Area> findAll() {
        AreaExample example = new AreaExample();
        AreaExample.Criteria criteria = example.createCriteria();
        return areaMapper.selectByExample(example);
    }
}
