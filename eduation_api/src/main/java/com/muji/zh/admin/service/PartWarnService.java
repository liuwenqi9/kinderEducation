package com.muji.zh.admin.service;

import com.muji.zh.admin.model.KindWarn;
import com.muji.zh.admin.model.PartWarn;
import com.muji.zh.admin.model.PartWarnExample;
import com.muji.zh.admin.model.Warning;

import java.util.List;
import java.util.Map;

public interface PartWarnService {
    Map<String, Object>findWarnByArea(Integer areaId, List<Warning> warningList,Integer sign);


    int deleteByExample(PartWarnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartWarn record);

    int insertSelective(PartWarn record);


    List<PartWarn> findBySid(Integer id);
}
