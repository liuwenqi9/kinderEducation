package com.muji.zh.part.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.ParSlarList;
import com.muji.zh.admin.service.ParSlarListService;
import com.muji.zh.admin.service.SalaryListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 修改时间 Time:2019/1/5  10:12
 */
@Controller
@Api(value = "/parExperience",description = "这是全部的/parExperience的方法")
public class ParSlarListController {

    @Reference
    private ParSlarListService parSlarListService;
    @Reference
    private SalaryListService salaryListService;

    //查询自己 工资是否属实   待发放   每月查询出来一条数据
    @PostMapping(value = "/selectParSlarListByPidAndSign")
    @ApiOperation("查询待发工资")
    @ResponseBody
    public String selectParSlarListByPidAndSign(@RequestBody String parms){
        //将parms 封装到 Json里边
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获得  从业者ID
        Integer p_id = jsonObject.getInteger("pId");
        //获得  清单状态  0 表示未确认 1 表示已确认
        Integer sign = jsonObject.getInteger("sign");
        List<ParSlarList> parSlarList = null;
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Double slar = 0.0;
        String date = null;
        if(p_id!=null&&sign!=null){
            parSlarList = parSlarListService.selectParSlarListByPidAndSign(p_id,sign);
            if (parSlarList != null) {
                for(ParSlarList p:parSlarList){
                    date = s.format(p.getCreateDate());
                    slar+=p.getRealWages();
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("parSlarList",parSlarList);
        map.put("totalSlar",slar);
        map.put("date",date);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //确认工资
    //确认工资 无误   即工资一定会到账   更新salary_list 表中的 real_wages 字段
    @PostMapping(value = "/ConfirmSlarList")
    @ApiOperation("确认工资")
    @ResponseBody
    public String ConfirmSlarList(@RequestBody String parms){
        //拿到sign状态
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer sign = jsonObject.getInteger("sign");
        Integer pId = jsonObject.getInteger("pId");
        //拿到 查询的工资ID
        //Integer id = jsonObject.getInteger("id");
        //修改清单状态
        if (pId != null&&sign!=null)
            //这里 之所以 传 2 个 sign 值  是因为 sign 工资是否确认 和 state 工资是否到账 同时刷新 为 1
            parSlarListService.ConfirmSlarList(sign,sign,pId);
        //查询  工资是否到账
        List<Integer> state = null;
        Map<String,Object> map = new HashMap<>();
        if (sign!=null&&pId!=null) {
            //通过pid 查询sid 也就是 salary_lsit的id
            List<Integer> sid = parSlarListService.selectSidBypPidAndId(pId);
            //通过pId 和 sign 查询 real_wages 总的实际发工资
            Integer total_wages = parSlarListService.selectTotalWagesBypIdAndSign(pId,sign);
            //更新 salary_list 表中的 real_wages 字段
            int sId = sid.get(0);
            System.out.println("ss-sid:"+sId);
            salaryListService.updateRealWagesBySidAndPid(sId,pId,total_wages);
            //state 不为空 说明 State 有值
            state = parSlarListService.selectStateBypIdAndSignAndId(pId,sign);
            System.out.println("state:"+state);
            if (state != null) {
                System.out.println("state[0]:"+state.get(0));
                map.put("state",state.get(0));
            }else{
                map.put("state",null);
            }
        }
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查询已发放工资记录
    @PostMapping(value = "/selectParSlarListByPrimaryKey1")
    @ApiOperation("查询已发工资")
    @ResponseBody
    public String selectParSlarListByPrimaryKey1(@RequestBody String parms){
        List<ParSlarList> parSlarLists = null;
        //Integer pid, Integer sign
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //拿到共 从业者ID 清单状态  工资是否到账状态
        Integer pid = jsonObject.getInteger("pId");         //从业者ID
        Integer sign = jsonObject.getInteger("sign");       //是否确认无误 0 未确认 1确认
        Integer state = jsonObject.getInteger("state");     //工资是否到账
        System.out.print("pid:"+pid);
        System.out.print("sign:"+sign);
        System.out.print("state:"+state);
        Double slar = 0.0;
        String date = null;
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if(pid!=null&&sign!=null&&state!=null){
            parSlarLists = parSlarListService.selectParSlarListByPrimaryAndSignId(pid, sign,state);
            if (parSlarLists != null) {
                for(ParSlarList p:parSlarLists){
                    date = s.format(p.getCreateDate());
                    //求工资的和
                    slar+=p.getRealWages();
                }
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("parSlarLists",parSlarLists);
        map.put("totalSlar",slar);
        map.put("date",date);
        map.put("status",200);
        JSONObject newJson = JSONObject.parseObject(JSON.toJSONString(map));
        return newJson.toJSONString();
    }
}
