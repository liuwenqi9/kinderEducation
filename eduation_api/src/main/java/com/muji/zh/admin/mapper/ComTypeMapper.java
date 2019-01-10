package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.ComType;
import com.muji.zh.admin.model.ComTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComTypeMapper {
    long countByExample(ComTypeExample example);

    int deleteByExample(ComTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComType record);

    int insertSelective(ComType record);

    List<ComType> selectByExample(ComTypeExample example);

    ComType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ComType record, @Param("example") ComTypeExample example);

    int updateByExample(@Param("record") ComType record, @Param("example") ComTypeExample example);

    int updateByPrimaryKeySelective(ComType record);

    int updateByPrimaryKey(ComType record);










    //查询 所有的投诉类别 和
    List<ComType> selectAllComplaintType();
}