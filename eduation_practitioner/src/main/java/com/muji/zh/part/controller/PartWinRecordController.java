package com.muji.zh.part.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.PartWinRecord;
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
public class PartWinRecordController {

    @Reference
    private com.muji.zh.admin.service.PartWinRecord partWinRecord1;

    //添加从业者获奖记录
    @PostMapping(value = "/insertPartWinRecord")
    @ApiOperation("添加从业者获奖记录")
    @ResponseBody
    public String insertPartWinRecord(@RequestBody String parms){
        //PartWinRecord partWinRecord
        //封装数据
        PartWinRecord partWinRecord = (PartWinRecord)JSONObject.parseObject(parms, PartWinRecord.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        partWinRecord.setDate(simpleDateFormat.format(new Date()));
        if(partWinRecord!=null){
            partWinRecord1.insert(partWinRecord);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }
    //修改获奖记录
    @PostMapping(value = "/updatePartWinRecordByPrimaryKeySelective")
    @ApiOperation("修改从业者获奖记录")
    @ResponseBody
    public String updatePartWinRecordByPrimaryKeySelective(@RequestBody String parms){
        //PartWinRecord partWinRecord
        //封装数据
        PartWinRecord partWinRecord = (PartWinRecord)JSONObject.parseObject(parms,PartWinRecord.class);
        if(partWinRecord!=null){
            partWinRecord1.updateByPrimaryKeySelective(partWinRecord);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }
    //删除获奖记录
    @PostMapping(value = "/deleteParWinRecordByPrimaryKey")
    @ApiOperation("删除从业者获奖记录")
    @ResponseBody
    public String deleteParWinRecordByPrimaryKey(@RequestBody String parms){
        //r id   pid
        //封装数据
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获得  获奖记录 Id
        Integer id = jsonObject.getInteger("id");
        //获得  从业着 id
        Integer p_id = jsonObject.getInteger("pId");
        if(p_id!=null&&id!=null){
            partWinRecord1.deleteByIdAndPid(id,p_id);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查看获奖记录
    @PostMapping(value = "/selectPartWinRecordByPid")
    @ApiOperation("查看从业者所有获奖记录")
    @ResponseBody
    public String selectPartWinRecordByPid(@RequestBody String parms) throws ParseException {
        //Integer id
        //封装数据
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获得 从业者ID
        Integer pId = jsonObject.getInteger("pId");
        List<com.muji.zh.admin.model.PartWinRecord> partWinRecords = null;
        if(pId!=null){
            partWinRecords = partWinRecord1.selectByPid(pId);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("partWinRecords",partWinRecords);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查看单个获奖记录
    @PostMapping(value = "/selectPartWinRecordByPidAndId")
    @ApiOperation("查看从业者单个获奖记录")
    @ResponseBody
    public String selectPartWinRecordByPidAndId(@RequestBody String parms) throws ParseException {
        //Integer id
        //封装数据
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获得 从业者ID
        Integer pId = jsonObject.getInteger("pId");
        //获得 获奖记录id
        Integer id = jsonObject.getInteger("id");
        PartWinRecord partWinRecord = null;
        if(id!=null&&pId!=null){
            partWinRecord = partWinRecord1.selectByPidAndId(id,pId);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("partWinRecords",partWinRecord);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }
}
