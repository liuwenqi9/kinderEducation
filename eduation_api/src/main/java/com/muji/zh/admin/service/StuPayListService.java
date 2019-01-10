package com.muji.zh.admin.service;

import com.muji.zh.admin.model.StuPayList;
import com.muji.zh.admin.model.StuPayListExample;

import java.util.List;

public interface StuPayListService {

    List<StuPayList> selectByExample(StuPayListExample example);

    List <StuPayList> findBySidStatus(Integer sid, int i);

    void updateList(List<StuPayList> stuPayListList);

    //List<StuPayList> selectByExample(StuPayListExample example);

    StuPayList selectByPrimaryKey(Integer id);

    List<StuPayList> findByPidStatus(int s, int i);
}
