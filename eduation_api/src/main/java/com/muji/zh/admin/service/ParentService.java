package com.muji.zh.admin.service;

import com.muji.zh.admin.model.Parent;

public interface ParentService {
    int insert(Parent record);

    Parent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parent record);

    int deleteByPrimaryKey(Integer id);


    Parent login(Parent parent);

   // Parent findBySid(String sID);
}
