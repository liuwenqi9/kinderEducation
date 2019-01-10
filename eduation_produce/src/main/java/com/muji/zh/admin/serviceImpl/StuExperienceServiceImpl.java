package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.StuExperienceMapper;
import com.muji.zh.admin.model.StuExperience;
import com.muji.zh.admin.model.StuExperienceExample;
import com.muji.zh.admin.service.StuExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class StuExperienceServiceImpl implements StuExperienceService {
    @Autowired
    private StuExperienceMapper stuExperienceMapper;


    @Override
    public List<StuExperience> findBySId(Integer id) {

        StuExperienceExample experienceExample=new StuExperienceExample();
        StuExperienceExample.Criteria criteria=experienceExample.createCriteria();
        criteria.andSidEqualTo(id);

        return stuExperienceMapper.selectByExample(experienceExample);
    }


    @Override
    public int insertSelective(StuExperience record) {
        return stuExperienceMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(StuExperience record) {
        return stuExperienceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<StuExperience> selectByExample(StuExperienceExample example) {
        return stuExperienceMapper.selectByExample(example);
    }

    @Override
    public List<StuExperience> findBySid(Integer id) {
        StuExperienceExample experienceExample=new StuExperienceExample();
        StuExperienceExample.Criteria criteria=experienceExample.createCriteria();
        criteria.andSidEqualTo(id);
         List<StuExperience>list = stuExperienceMapper.selectByExample(experienceExample);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        for (int i=0;i<list.size();i++)
        {
            String s=simpleDateFormat.format(list.get(i).getDate());

            list.get(i).setFlag1(s);

        }
        return list;

    }

    @Override
    public int deleteByExample(StuExperienceExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return stuExperienceMapper.deleteByPrimaryKey(id);
    }
}
