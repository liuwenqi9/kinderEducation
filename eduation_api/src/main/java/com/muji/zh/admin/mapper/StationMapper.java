package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Station;
import com.muji.zh.admin.model.StationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StationMapper {
    long countByExample(StationExample example);

    int deleteByExample(StationExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(Station record);

    int insertSelective(Station record);

    List<Station> selectByExampleWithBLOBs(StationExample example);

    List<Station> selectByExample(StationExample example);

    Station selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") Station record, @Param("example") StationExample example);

    int updateByExampleWithBLOBs(@Param("record") Station record, @Param("example") StationExample example);

    int updateByExample(@Param("record") Station record, @Param("example") StationExample example);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKeyWithBLOBs(Station record);

    int updateByPrimaryKey(Station record);






    List<Station> findAll();

    Integer getSid(@Param("pname") String pname);
}