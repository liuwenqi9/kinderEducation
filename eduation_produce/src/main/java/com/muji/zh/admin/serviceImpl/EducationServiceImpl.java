package com.muji.zh.admin.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.mapper.EducationMapper;
import com.muji.zh.admin.model.Education;
import com.muji.zh.admin.model.EducationExample;
import com.muji.zh.admin.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class EducationServiceImpl  implements EducationService {
    @Autowired
    private EducationMapper educationMapper;
    @Override
    public long countByExample(EducationExample example) {
        return educationMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(EducationExample example) {
        return educationMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer epId) {
        return educationMapper.deleteByPrimaryKey(epId);
    }

    @Override
    public int insert(Education record) {
        return educationMapper.insert(record);
    }

    @Override
    public int insertSelective(Education record) {
        return educationMapper.insertSelective(record);
    }

    @Override
    public List<Education> selectByExample(EducationExample example) {
        return educationMapper.selectByExample(example);
    }

    @Override
    public Education selectByPrimaryKey(Integer epId) {
        return educationMapper.selectByPrimaryKey(epId);
    }

    @Override
    public int updateByExampleSelective(Education record, EducationExample example) {
        return educationMapper.updateByExampleSelective(record ,example);
    }

    @Override
    public int updateByExample(Education record, EducationExample example) {
        return educationMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Education record) {
        return educationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Education record) {
        return educationMapper.updateByPrimaryKey(record);
    }
//PageInfo<Blog> ajaxBlog(Integer pageNum,Integer pageSize){
    public PageInfo<Education> findByUbranID(Integer pageNum,Integer pageSize,int id)
    {
        PageHelper.startPage(pageNum,pageSize);
        EducationExample educationExample=new EducationExample();
        EducationExample.Criteria criteria=educationExample.createCriteria();
        criteria.andUbranIdEqualTo(id);
        List<Education> educations= educationMapper.selectByExample(educationExample);
        PageInfo<Education> pageInfo=new PageInfo<Education>(educations);

        return pageInfo;
    }

    @Override
    public List<Education> distinctName(Integer id) {
        return educationMapper.distinctName(id);
    }


    @Override
    public Education findByAreaId(String area_id) {
        EducationExample educationExample=new EducationExample();
        EducationExample.Criteria criteria=educationExample.createCriteria();
        criteria.andAreaIdEqualTo(Integer.parseInt(area_id));
        List<Education> educations= educationMapper.selectByExample(educationExample);

        return educations.get(0);
    }











    @Override
    public Education findById(Integer eduId) {
        return educationMapper.selectByPrimaryKey(eduId);
    }
}
