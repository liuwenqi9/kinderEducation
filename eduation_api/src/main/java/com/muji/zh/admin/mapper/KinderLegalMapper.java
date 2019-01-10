package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.KinderLegal;
import com.muji.zh.admin.model.KinderLegalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KinderLegalMapper {
    long countByExample(KinderLegalExample example);

    int deleteByExample(KinderLegalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(KinderLegal record);

    int insertSelective(KinderLegal record);

    List<KinderLegal> selectByExample(KinderLegalExample example);

    KinderLegal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") KinderLegal record, @Param("example") KinderLegalExample example);

    int updateByExample(@Param("record") KinderLegal record, @Param("example") KinderLegalExample example);

    int updateByPrimaryKeySelective(KinderLegal record);

    int updateByPrimaryKey(KinderLegal record);

    KinderLegal selectByklnameAndpassword(@Param("id") Integer id,@Param("password") String password);


    List<KinderLegal> findAll();
}