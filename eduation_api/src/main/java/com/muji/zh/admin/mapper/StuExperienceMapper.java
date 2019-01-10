package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.StuExperience;
import com.muji.zh.admin.model.StuExperienceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuExperienceMapper {
    long countByExample(StuExperienceExample example);

    int deleteByExample(StuExperienceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StuExperience record);

    int insertSelective(StuExperience record);

    List<StuExperience> selectByExample(StuExperienceExample example);

    StuExperience selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StuExperience record, @Param("example") StuExperienceExample example);

    int updateByExample(@Param("record") StuExperience record, @Param("example") StuExperienceExample example);

    int updateByPrimaryKeySelective(StuExperience record);

    int updateByPrimaryKey(StuExperience record);
}