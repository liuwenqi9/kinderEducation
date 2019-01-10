package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.CourseMapper;
import com.muji.zh.admin.model.Course;
import com.muji.zh.admin.model.CourseExample;
import com.muji.zh.admin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectByExample(CourseExample example) {
        return courseMapper.selectByExample(example);
    }

    @Override
    public List<Course> selectAllCourse(Integer aim1, Integer aim2) {
        return courseMapper.selectAllCourse1(aim1,aim2);
    }

    @Override
    public List<Course> findByAreaID(Integer id) {
        CourseExample courseExample=new CourseExample();
        CourseExample.Criteria criteria=courseExample.createCriteria();
        criteria.andAreaIdEqualTo(id);
        //criteria.andAimBetween()

        List<Course> coursesList= courseMapper.selectByExample(courseExample);
        return coursesList;
    }












    @Override
    public List<Course> selectAllCourse() {
        return courseMapper.selectAllCourse();
    }
}
