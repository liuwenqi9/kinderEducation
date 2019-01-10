package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.SalaryList;
import com.muji.zh.admin.model.SalaryListExample;
import com.muji.zh.admin.model.SalaryListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SalaryListMapper {
    long countByExample(SalaryListExample example);

    int deleteByExample(SalaryListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SalaryList record);

    int insertSelective(SalaryList record);

    List<SalaryList> selectByExample(SalaryListExample example);

    SalaryList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SalaryList record, @Param("example") SalaryListExample example);

    int updateByExample(@Param("record") SalaryList record, @Param("example") SalaryListExample example);

    int updateByPrimaryKeySelective(SalaryList record);

    int updateByPrimaryKey(SalaryList record);

    List<SalaryList> findBYPid(Integer pid);

    // SalaryListVo selectBysNameAndsId(String sname, Integer pId);

    //通过 sid 和 pid 确定 唯一的一条记录  更新它的 实际发放工资
    int updateRealWagesBySidAndPid(@Param("sId") Integer sId, @Param("pId") Integer pId, @Param("real_wages") Integer total_wages);












    List<SalaryList> selectBysNameAndsId(@Param("sname") String sname, @Param("pId") Integer pId,@Param("kinderName")String kinderName);

    List<SalaryList> selectPartView(@Param("kinderName") String kinderName);




}