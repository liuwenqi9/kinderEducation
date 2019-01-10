package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Kindergarten;
import com.muji.zh.admin.model.KindergartenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KindergartenMapper {
    long countByExample(KindergartenExample example);

    int deleteByExample(KindergartenExample example);

    int deleteByPrimaryKey(Integer kId);

    int insert(Kindergarten record);

    int insertSelective(Kindergarten record);

    List<Kindergarten> selectByExample(KindergartenExample example);

    Kindergarten selectByPrimaryKey(Integer kId);

    int updateByExampleSelective(@Param("record") Kindergarten record, @Param("example") KindergartenExample example);

    int updateByExample(@Param("record") Kindergarten record, @Param("example") KindergartenExample example);

    int updateByPrimaryKeySelective(Kindergarten record);

    int updateByPrimaryKey(Kindergarten record);
}