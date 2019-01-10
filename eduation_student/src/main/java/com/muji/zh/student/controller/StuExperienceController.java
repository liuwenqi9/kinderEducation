package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.StuExperience;
import com.muji.zh.admin.model.StuExperienceExample;
import com.muji.zh.admin.model.StuExperience;
import com.muji.zh.admin.model.StuExperience;
import com.muji.zh.admin.service.StuExperienceService;
import com.muji.zh.student.Json.StuExperienceJSON;
import com.muji.zh.student.util.StatusUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/StuExperience",description = "这是全部的/StuExperience")
public class StuExperienceController {
    private static final Logger logger=LoggerFactory.getLogger(StuExperienceController.class);

    @Reference
    private StuExperienceService stuExperienceService;

    @ResponseBody
    @ApiOperation("插入个人经历")
    @PostMapping("/insertStuExperience")
    public String insertStuExperience(@RequestBody String parms) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        StuExperience stuExperience = jsonObject.parseObject(parms, StuExperience.class);
        System.out.println(stuExperience);
        stuExperience.setDate(new Date());
        stuExperienceService.insertSelective(stuExperience);
        return StatusUtil.getStatus("200");
    }



    @ResponseBody
    @ApiOperation("查询个人经历")
    @PostMapping("/selectStuExperience")
    public String zh_select_StuExperience(@RequestBody String parms) throws ParseException {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("sid");
        List<StuExperience> stuExperienceList= stuExperienceService.findBySid(id);
        for (int i=0;i<stuExperienceList.size();i++)
        {
            Date date=stuExperienceList.get(i).getDate();

            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
           String d= simpleDateFormat.format(date);

           //simpleDateFormat.parse(d);

           stuExperienceList.get(i).setFalg3(d);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("stuExperienceList", stuExperienceList);
        // map.put("comTypeList",comTypeList);
        map.put("status", 200);
        //map.put("kinderName",kindergarten.getKname());
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();
        
    }




    @ResponseBody
    @ApiOperation("更新个人经历")
    @PostMapping("/updateStuExperience")
    public String zh_update_stuExperience(@RequestBody String parms) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        StuExperience stuExperience = jsonObject.parseObject(parms, StuExperience.class);
        System.out.println(stuExperience);

        stuExperienceService.updateByPrimaryKeySelective(stuExperience);//stuExperienceService.insertSelective(stuExperience);
        return StatusUtil.getStatus("200");
        //return stuExperienceService.updateByPrimaryKeySelective(record);
    }

    @ResponseBody
    @ApiOperation("删除个人经历")
    @PostMapping("/deleteStuExperience")
    public String zh_delete_stuExperience(@RequestBody String parms){

        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("id");
        System.out.println(id);
        stuExperienceService.deleteByPrimaryKey(id);
        return StatusUtil.getStatus("200");

    }




}
