package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.Complaint;
import com.muji.zh.admin.model.StuWinRecord;
import com.muji.zh.admin.model.StuWinRecordExample;
import com.muji.zh.admin.service.StuWinRecordService;
import com.muji.zh.student.Json.StuWinRecordJson;
import com.muji.zh.student.util.StatusUtil;
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
@Api(value = "/StuWinRecord",description = "这是StuWinRecord所有的方法")
public class StuWinRecordController {

    @Reference
    private StuWinRecordService stuWinRecordService;

    @ResponseBody
    @ApiOperation("插入获奖记录")
    @PostMapping("/insertStuWinRecord")
    public String insertComplaint(@RequestBody String parms) throws ParseException {


        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        StuWinRecord stuWinRecord = jsonObject.parseObject(parms, StuWinRecord.class);
        Date da=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=simpleDateFormat.format(da);
        Date d=simpleDateFormat.parse(date);

        stuWinRecord.setDate(d);

        System.out.println(stuWinRecord);
        stuWinRecordService.insertSelective(stuWinRecord);
        return StatusUtil.getStatus("200");


    }

    @ResponseBody
    @ApiOperation("查询获奖记录")
    @PostMapping("/selectStuWinRecord")
    public String zh_select_StuWinRecord(@RequestBody String parms) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("sid");
        List<StuWinRecord> stuWinRecordList= stuWinRecordService.findBySid(id);

        ///Date sd=new Date("yyyy-MM-dd");


        for(int i=0;i<stuWinRecordList.size();i++)
        {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String date=   simpleDateFormat.format(stuWinRecordList.get(i).getDate());
            stuWinRecordList.get(i).setFalg3(date);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("stuWinRecordList", stuWinRecordList);
       // map.put("comTypeList",comTypeList);
        map.put("status", 200);
        //map.put("kinderName",kindergarten.getKname());
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();


    }

    @ResponseBody
    @ApiOperation("更新获奖记录")
    @PostMapping("/updateStuWinRecord")
    public String zh_update_StuWinRecord(@RequestBody String parms) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        StuWinRecord stuWinRecord = jsonObject.parseObject(parms, StuWinRecord.class);
        System.out.println(stuWinRecord);

        stuWinRecordService.updateByPrimaryKeySelective(stuWinRecord);//stuWinRecordService.insertSelective(stuWinRecord);
        return StatusUtil.getStatus("200");
        //return stuWinRecordService.updateByPrimaryKeySelective(record);
    }

    @ResponseBody
    @ApiOperation("删除获奖记录")
    @PostMapping("/deleteStuWinRecord")
    public String zh_delete_StuWinRecord(@RequestBody String parms){


        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("id");

        stuWinRecordService.deleteByPrimaryKey(id);
        return StatusUtil.getStatus("200");

    }

}
