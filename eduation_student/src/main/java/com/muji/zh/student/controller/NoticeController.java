package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.NoticeService;
import com.muji.zh.admin.service.ParentService;
import com.muji.zh.admin.service.StuParentService;
import com.muji.zh.admin.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/Notice" ,description = "这是全部的/Notice方法")
public class NoticeController {
    @Reference
    private NoticeService noticeService;

    @Reference
    private ParentService parentService;
    @Reference
    private StudentService studentService;
    @Reference
    private StuParentService stuParentService;

    @PostMapping("/noticeManager")
    @ApiOperation("消息管理")
    @ResponseBody
    public String noticeManager(@RequestBody String parms) {

        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("id");

        Parent parent=parentService.selectByPrimaryKey(id);

        StuParent stuParent= stuParentService.findBy(parent.getId()).get(0);

        Student student=studentService.selectByPrimaryKey(stuParent.getSid());
        List<Notice> noticeList=noticeService.findByParent(parent,student.getAreaId()+"");



        Map<String, Object> map = new HashMap<>();

        map.put("noticeList", noticeList);

        // map.put("pId",parent.getId());
        map.put("status", 200);
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();





    }
}
