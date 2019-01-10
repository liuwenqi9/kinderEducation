package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.ParSlarList;
import com.muji.zh.admin.model.ParSlarListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParSlarListMapper {
    long countByExample(ParSlarListExample example);

    int deleteByExample(ParSlarListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParSlarList record);

    int insertSelective(ParSlarList record);

    List<ParSlarList> selectByExample(ParSlarListExample example);

    ParSlarList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParSlarList record, @Param("example") ParSlarListExample example);

    int updateByExample(@Param("record") ParSlarList record, @Param("example") ParSlarListExample example);

    int updateByPrimaryKeySelective(ParSlarList record);

    int updateByPrimaryKey(ParSlarList record);







    List<ParSlarList> selectParSlarListByPrimaryAndSignId(@Param("pId")Integer pId,@Param("sign")Integer sign,@Param("state")Integer state);
    List<ParSlarList> selectParSlarListByPidAndSign(@Param("pId") Integer pid,@Param("sign")Integer sign);

    int ConfirmSlarList(@Param("sign") Integer sign,@Param("state") Integer state,@Param("pId") Integer pId);

    // 查询是工资否到账
    List<Integer> selectStateBypIdAndSignAndId(@Param("pId") Integer pId,@Param("sign") Integer sign);
    //通过Pid 查询 Sid
    List<Integer> selectSidBypPidAndId(@Param("pId") Integer pId);
    //通过pId 和 sign  查询  总的实际发放的工资
    Integer selectTotalWagesBypIdAndSign(@Param("pId") Integer pId,@Param("sign") Integer sign);
}