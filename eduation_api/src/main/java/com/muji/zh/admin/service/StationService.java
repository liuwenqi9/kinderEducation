package com.muji.zh.admin.service;

import com.muji.zh.admin.model.ClassType;
import com.muji.zh.admin.model.EduUser;
import com.muji.zh.admin.model.Station;
import com.muji.zh.admin.model.StationExample;

import java.util.List;
import java.util.Map;

public interface StationService {
    List<Station> find();


    int deleteByExample(StationExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(Station record);

    int insertSelective(Station record);


    Station selectByPrimaryKey(Integer sId);





    List<Station> findAll();

}
