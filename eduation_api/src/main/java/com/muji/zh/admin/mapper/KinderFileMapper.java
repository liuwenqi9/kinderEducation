package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.KinderFile;
import com.muji.zh.admin.model.KinderFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KinderFileMapper {
    long countByExample(KinderFileExample example);

    int deleteByExample(KinderFileExample example);

    int deleteByPrimaryKey(Integer fId);

    int insert(KinderFile record);

    int insertSelective(KinderFile record);

    List<KinderFile> selectByExample(KinderFileExample example);

    KinderFile selectByPrimaryKey(Integer fId);

    int updateByExampleSelective(@Param("record") KinderFile record, @Param("example") KinderFileExample example);

    int updateByExample(@Param("record") KinderFile record, @Param("example") KinderFileExample example);

    int updateByPrimaryKeySelective(KinderFile record);

    int updateByPrimaryKey(KinderFile record);

    KinderFile selectFile(@Param("type") String type,@Param("kId")Integer kindId);
}