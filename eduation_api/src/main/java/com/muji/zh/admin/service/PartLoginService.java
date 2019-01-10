package com.muji.zh.admin.service;

import com.muji.zh.admin.model.Admin;
import com.muji.zh.admin.model.PartLogin;
import com.muji.zh.admin.model.PartLoginExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartLoginService {
    int insertSelective(PartLogin record);

    long countByExample(PartLoginExample example);

    int deleteByExample(PartLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartLogin record);

    //int insertSelective(PartLogin record);

    List<PartLogin> selectByExample(PartLoginExample example);

    PartLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartLogin record, @Param("example") PartLoginExample example);

    int updateByExample(@Param("record") PartLogin record, @Param("example") PartLoginExample example);

    int updateByPrimaryKeySelective(PartLogin record);

    int updateByPrimaryKey(PartLogin record);

    //用户名密码 验证
    Integer selectByIdAndPassword(@Param("id") Integer id,@Param("password") String password);

    String selectImageById(Integer id);


}
