package com.muji.zh.part.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.ParExperience;
import com.muji.zh.admin.service.ParExperienceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/parExperience",description = "这是全部的/parExperience的方法")
public class ParExperienceController {
    @Reference
    private ParExperienceService parExperienceService;

    //添加从业者工作履历
    @PostMapping(value = "/insertParExperience")
    @ApiOperation("添加从业者工作履历")
    @ResponseBody
    public String insertParExperience(@RequestBody String parms){
        System.out.print("parms:"+parms);
        //ParExperience parExperience
        //封装数据 映射Java对象
        ParExperience parExperience = (ParExperience)JSONObject.parseObject(parms,ParExperience.class);
        //封装 pId
        parExperience.setpId(JSONObject.parseObject(parms).getInteger("pId"));
        parExperience.setSdates(new Date());
        //判断 是否为空
        if(parExperience!=null){
            parExperienceService.insert(parExperience);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //修改从业者工作履历
    @PostMapping(value = "/updateParExperienceByPrimaryKeySelective")
    @ApiOperation("修改从业者工作履历")
    @ResponseBody
    public String updateByPrimaryKeySelective(@RequestBody String parms){
        //ParExperience parExperience
        //封装数据
        ParExperience parExperience = (ParExperience)JSONObject.parseObject(parms,ParExperience.class);
        //封装pId
        parExperience.setpId(JSONObject.parseObject(parms).getInteger("pId"));
        if(parExperience!=null){
            parExperienceService.updateByIdAndPid(parExperience);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //删除从业者工作履历
    @PostMapping(value = "/deleteParExperienceByPrimaryKey")
    @ApiOperation("删除从业者工作履历")
    @ResponseBody
    public String deleteByPrimaryKey(@RequestBody String parms){
        //Integer id
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("id");
        //获取从业者pId
        Integer pId = jsonObject.getInteger("pId");
        if(pId!=null&&id!=null){
            parExperienceService.deleteByIdAndPid(id,pId);
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查看从业者工作者履历
    @PostMapping(value = "/selectParExperienceByPrimaryKey")
    @ApiOperation("查看从业者工作履历")
    @ResponseBody
    public String selectByPrimaryKey(@RequestBody String parms ) throws ParseException {
        //Integer id
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer pId = jsonObject.getInteger("pId");
        List<ParExperience> parExperience = null;
        if(pId!=null){
            parExperience = parExperienceService.selectByPid(pId);
            for(ParExperience p:parExperience){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("format:"+simpleDateFormat.format(p.getSdates()));
                System.out.println("parse:"+simpleDateFormat.parse(simpleDateFormat.format(p.getSdates())));
//                p.setSdates(simpleDateFormat.parse(simpleDateFormat.format(p.getSdates())));
                p.setFlag3(simpleDateFormat.format(p.getSdates()));
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("parExperience",parExperience);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }
}
