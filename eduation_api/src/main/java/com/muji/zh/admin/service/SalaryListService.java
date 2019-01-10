package com.muji.zh.admin.service;

import com.muji.zh.admin.model.SalaryList;
import org.apache.ibatis.annotations.Param;

public interface SalaryListService {

    SalaryList findTosid(Integer pid);






    //通过 sid 和 pid 确定 唯一的一条记录  更新它的 实际发放工资
    int updateRealWagesBySidAndPid(@Param("sId") Integer sId, @Param("pId") Integer pId, @Param("real_wages") Integer total_wages);
}
