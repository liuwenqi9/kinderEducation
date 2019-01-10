package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Kindergarten;
import com.muji.zh.admin.model.KindergartenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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



    List<Kindergarten> findByLikeName(@Param("keyword") String keyword);


    Kindergarten selectByPrimaryKeyView(Integer id);

    String selectgarById(Integer kId);
}