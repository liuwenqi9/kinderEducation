package com.muji.zh.admin.service;

import com.muji.zh.admin.model.StuExperience;
import com.muji.zh.admin.model.StuExperienceExample;

import java.util.List;

public interface StuExperienceService {
    List<StuExperience> findBySId(Integer id);

    int insertSelective(StuExperience record);

    int updateByPrimaryKeySelective(StuExperience record);

    List<StuExperience> selectByExample(StuExperienceExample example);

    List<StuExperience> findBySid(Integer id);

    int deleteByExample(StuExperienceExample example);

    int deleteByPrimaryKey(Integer id);
}
