package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.SalaryListMapper;
import com.muji.zh.admin.model.SalaryList;
import com.muji.zh.admin.model.SalaryListExample;
import com.muji.zh.admin.service.SalaryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class SalaryListServiceImpl implements SalaryListService {
    @Autowired
    private SalaryListMapper salaryListMapper;
    @Override
    public SalaryList findTosid(Integer pid) {

        try {
            List<SalaryList> salaryListList = salaryListMapper.findBYPid(pid);


            return salaryListList.get(0);
        } catch (Exception e) {
            return null;

        }
    }




    @Override
    public int updateRealWagesBySidAndPid(Integer sId, Integer pId, Integer total_wages) {
        return salaryListMapper.updateRealWagesBySidAndPid(sId,pId,total_wages);
    }
}
