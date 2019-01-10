package com.muji.zh.admin.service;

import com.muji.zh.admin.model.Course;
import com.muji.zh.admin.model.CourseExample;

import java.util.List;

public interface CourseService {
    List<Course> selectByExample(CourseExample example);

    //  List<Course> selectAllCourse(Integer aim1,Integer aim2);
    List<Course> selectAllCourse(Integer aim1,Integer aim2);

    List<Course> findByAreaID(Integer id);




    //从业者查询课程资源信息
    List<Course> selectAllCourse();

}
