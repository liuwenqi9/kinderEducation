package com.muji.zh.admin.service;

import com.muji.zh.admin.model.ParentVo;
import com.muji.zh.admin.model.StuParent;
import com.muji.zh.admin.model.Student;

import java.util.List;

public interface StuParentService {
    int deleteByPrimaryKey(Integer id);

    int insert(StuParent record);

    StuParent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuParent record);

    ParentVo ParentView(Integer sId);

    StuParent findByStuId(Integer sid);

    List<StuParent> findBy(Integer id);


    int insertSelective(StuParent record);


    StuParent findBySid_Pid(String sID);

}
