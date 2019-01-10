package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.StuPayListMapper;
import com.muji.zh.admin.model.StuPayList;
import com.muji.zh.admin.model.StuPayListExample;
import com.muji.zh.admin.service.StuPayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class StuPayListServiceImpl implements StuPayListService {
    @Autowired
    private StuPayListMapper stuPayListMapper;


    @Override
    public List<StuPayList> selectByExample(StuPayListExample example) {
        return stuPayListMapper.selectByExample(example);
    }

    @Override
    public List <StuPayList> findBySidStatus(Integer sid, int i) {

        StuPayListExample example=new StuPayListExample();
        StuPayListExample.Criteria  criteria=example.createCriteria();
        criteria.andSIdEqualTo(sid);
        criteria.andStausEqualTo(i);


        return stuPayListMapper.selectByExample(example);
    }

    @Override
    public void updateList(List<StuPayList> stuPayListList) {
        //stuPayListMapper.updateList(stuPayListList);


        for (int i=0;i<stuPayListList.size();i++)
        {
            StuPayListExample example=new StuPayListExample();
            StuPayListExample.Criteria  criteria=example.createCriteria();

            criteria.andSIdEqualTo(stuPayListList.get(i).getId());

            stuPayListList.get(i).setStaus(1);

            stuPayListMapper.updateByPrimaryKey(stuPayListList.get(i));


        }


    }

    @Override
    public StuPayList selectByPrimaryKey(Integer id) {
      return   stuPayListMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<StuPayList> findByPidStatus(int s, int i) {

        StuPayListExample example=new StuPayListExample();
        StuPayListExample.Criteria  criteria=example.createCriteria();

        criteria.andPIdEqualTo(s);
        criteria.andSIdEqualTo(i);



        return stuPayListMapper.selectByExample(example);
    }
}
