package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.ParExperience;
import com.muji.zh.admin.model.ParExperienceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParExperienceMapper {
    long countByExample(ParExperienceExample example);

    int deleteByExample(ParExperienceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParExperience record);

    int insertSelective(ParExperience record);

    List<ParExperience> selectByExample(ParExperienceExample example);

    ParExperience selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParExperience record, @Param("example") ParExperienceExample example);

    int updateByExample(@Param("record") ParExperience record, @Param("example") ParExperienceExample example);

    int updateByPrimaryKeySelective(ParExperience record);

    int updateByPrimaryKey(ParExperience record);














    //从业者删除工作履历
    int deleteByIdAndPid(@Param("id")Integer id,@Param("pId")Integer pId);

    //从业者 查询 工作履历
    List<ParExperience> selectByPid(Integer pId);

    //修改从业者 工作履历
    int updateByIdAndPid(ParExperience parExperience);
}