package com.muji.zh.student.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.muji.zh.admin.model.Course;
import com.muji.zh.admin.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "/Course" ,description = "这是全部的/Course方法")
public class CourseController {
    @Reference
    private CourseService courseService;


    @PostMapping(value = "/selectAllCourse")
    @ApiOperation("查看所有课程")
    @ResponseBody
    public List<Course> zh_select_All_Course(){
        return courseService.selectAllCourse(1,3);
    }

}
