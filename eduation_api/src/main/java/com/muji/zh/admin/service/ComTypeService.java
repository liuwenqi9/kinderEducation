package com.muji.zh.admin.service;

import com.muji.zh.admin.model.ComType;

import java.util.List;

public interface ComTypeService {

    List<ComType> findAll();
    ComType selectByPrimaryKey(Integer id);






    //查询 所有的投诉类别 和
    List<ComType> selectAllComplaintType();


}
