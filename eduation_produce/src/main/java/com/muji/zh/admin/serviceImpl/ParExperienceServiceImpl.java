package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.ParExperienceMapper;
import com.muji.zh.admin.model.ParExperience;
import com.muji.zh.admin.model.ParExperienceExample;
import com.muji.zh.admin.service.ParExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ParExperienceServiceImpl implements ParExperienceService {
    @Autowired
    private ParExperienceMapper parExperienceMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return parExperienceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ParExperience record) {
        return parExperienceMapper.insert(record);
    }

    @Override
    public int insertSelective(ParExperience record) {
        return parExperienceMapper.insertSelective(record);
    }

    @Override
    public List<ParExperience> selectByExample(Integer id) throws ParseException {
        ParExperienceExample parExperienceExample = new ParExperienceExample();
        ParExperienceExample.Criteria criteria = parExperienceExample.createCriteria();
        criteria.andPIdEqualTo(id);

       List<ParExperience> list=parExperienceMapper.selectByExample(parExperienceExample);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        for (int i=0;i<list.size();i++)
        {
            String s=simpleDateFormat.format(list.get(i).getSdates());

            list.get(i).setFlag1(s);

        }
        return list;
    }

    @Override
    public ParExperience selectByPrimaryKey(Integer id) {
        return parExperienceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ParExperience record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ParExperience record) {
        return 0;
    }
















    @Override
    public int deleteByIdAndPid(Integer id, Integer pId) {
        return parExperienceMapper.deleteByIdAndPid(id,pId);
    }

    @Override
    public List<ParExperience> selectByPid(Integer pId) {
        return parExperienceMapper.selectByPid(pId);
    }

    @Override
    public int updateByIdAndPid(ParExperience parExperience) {
        return parExperienceMapper.updateByIdAndPid(parExperience);
    }
}
