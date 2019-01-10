package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Clas;
import com.muji.zh.admin.model.ClasExample;
import com.muji.zh.admin.model.ClassVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClasMapper {
    long countByExample(ClasExample example);

    int deleteByExample(ClasExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(Clas record);

    int insertSelective(Clas record);

    List<Clas> selectByExample(ClasExample example);

    Clas selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") Clas record, @Param("example") ClasExample example);

    int updateByExample(@Param("record") Clas record, @Param("example") ClasExample example);

    int updateByPrimaryKeySelective(Clas record);

    int updateByPrimaryKey(Clas record);










    List<ClassVo> selectClassVo(@Param("kId") Integer kId);

    long selectCount(@Param("kId") Integer kId);

    List<ClassVo> checkClassVo(@Param("kId") Integer kId,@Param("cname")String cname);

    long checkCount(@Param("kId") Integer kId,@Param("cname")String cname);

    Clas selectBypId(@Param("pId") Integer pId);

    Clas selectByCname(@Param("cname") String cname);

    Clas UpdateCheckBypId(@Param("pId") Integer pId,@Param("cId") Integer cId);

    Clas UpdateCheckByCname(@Param("cname") String cname,@Param("cId") Integer cId);




}