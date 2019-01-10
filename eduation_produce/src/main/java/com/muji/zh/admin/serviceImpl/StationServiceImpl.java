package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.StationMapper;
import com.muji.zh.admin.model.Station;
import com.muji.zh.admin.model.StationExample;
import com.muji.zh.admin.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationMapper stationMapper;
    @Override
    public List<Station> find() {
        StationExample  example=new StationExample();
        StationExample.Criteria criteria=example.createCriteria();
        stationMapper.selectByExample(example);
        return stationMapper.selectByExample(example);
    }

    @Override
    public int deleteByExample(StationExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer sId) {
        return stationMapper.deleteByPrimaryKey(sId);
    }

    @Override
    public int insert(Station record) {
        return stationMapper.insert(record);
    }

    @Override
    public int insertSelective(Station record) {
        return stationMapper.insertSelective(record);
    }

    @Override
    public Station selectByPrimaryKey(Integer sId) {
        return stationMapper.selectByPrimaryKey(sId);
    }


    @Override
    public List<Station> findAll() {
        return stationMapper.findAll();
    }


}
