package com.muji.zh.admin.service;

import com.muji.zh.admin.model.KindWarn;
import com.muji.zh.admin.model.Warning;

import java.util.List;
import java.util.Map;

public interface KindWarnService {

    Map<String, Object> findWarnByArea(Integer areaId, List<Warning> warningList,Integer sign);



    Map<String,Object> findByKid(Integer kid, List<Warning> warningList);


    int deleteByPrimaryKey(Integer id);

    int insert(KindWarn record);

    int insertSelective(KindWarn record);
}
