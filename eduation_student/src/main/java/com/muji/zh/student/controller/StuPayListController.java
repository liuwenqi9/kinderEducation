package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.muji.zh.admin.model.PaymentList;
import com.muji.zh.admin.model.StuPayList;
import com.muji.zh.admin.service.PaymentListService;
import com.muji.zh.student.util.StatusUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Api(value = "StuParent", description = "这是StuPayList所有的方法")
public class StuPayListController {

    @Reference
    private com.muji.zh.admin.service.StuPayListService stuPayListService;

    @Reference
    private PaymentListService paymentListService;


    @PostMapping("/waitPayList")
    @ApiOperation("代缴清单")
    @ResponseBody
    public String waitPayList(@RequestBody String parms) {

        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer sid = jsonObject.getInteger("sId");

        List<StuPayList> stuPayListList = stuPayListService.findBySidStatus(sid, 0);

        Map<String, Object> map = new HashMap<>();


        map.put("stuPayListList", stuPayListList);
        map.put("status", 200);
        Gson gson = new Gson();
        gson.toJson(map);

        System.out.println(gson.toJson(map));
        return gson.toJson(map).toString();


    }


    @PostMapping("/payList")
    @ApiOperation("代缴清单")
    @ResponseBody
    public String payList(@RequestBody String parms) {

        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer sid = jsonObject.getInteger("sId");


        List<StuPayList> stuPayListList = stuPayListService.findBySidStatus(sid, 1);




        Map<String, Object> map = new HashMap<>();
        double total = 0;
        for (int i = 0; i < stuPayListList.size(); i++) {
            total += stuPayListList.get(i).getRealWa();
        }




        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");

        try{
            String date = simpleDateFormat.format(stuPayListList.get(0).getCreateDate());
            map.put("time", date);

        }catch (Exception e)
        {
            e.printStackTrace();


        }

        map.put("stuPayListList", stuPayListList);
        map.put("status", 200);
        map.put("total", total);

        Gson gson = new Gson();
        gson.toJson(map);

        System.out.println(gson.toJson(map));
        return gson.toJson(map).toString();


    }

    @PostMapping("/UpPayList")
    @ApiOperation("代缴清单")
    @ResponseBody
    public String payListStatus(@RequestBody String parms) {

        JSONObject jsonObject = JSONObject.parseObject(parms);

        System.out.println(parms);
        JSONArray ids = jsonObject.getJSONArray("new_arr");

        //Integer [] integers= (Integer[]) ids.toArray();
        Object[] objects = ids.toArray();
        List<StuPayList> stuPayListList = new ArrayList<>();


        for (int i = 0; i < objects.length; i++) {



            JSONObject jsonObject1 = JSONObject.parseObject(objects[i].toString());
            String id = (String) jsonObject1.get("id");
            StuPayList stuPayList = stuPayListService.selectByPrimaryKey(Integer.parseInt(id));
            stuPayList.setEndDate(new Date());
            stuPayList.setSign(1);
            stuPayListList.add(i, stuPayList);


        }
      int s= stuPayListList.get(0).getpId();

        List<StuPayList> lists=stuPayListService.findByPidStatus(s,1);

        float sum=0;
        for(int i=0;i< lists.size();i++){

            sum=sum+lists.get(i).getRealWa();

        }


        PaymentList paymentList= paymentListService.selectByPrimaryKey(s);

        paymentList.setTuition(sum);
        paymentListService.updateByPrimaryKeySelective(paymentList);
















        stuPayListService.updateList(stuPayListList);








        return StatusUtil.getStatus("200");


    }


//    @ResponseBody
//    @ApiOperation("查询缴费清单")
//    @PostMapping("/selectStuPayList")
//    public List<StuPayList> zh_Select_StuPayList(Integer sid){
//        StuPayListExample stuPayListExample=new StuPayListExample();
//        StuPayListExample.Criteria criteria=stuPayListExample.createCriteria();
//        criteria.andSIdEqualTo(sid);
//        return stuPayListService.selectByExample(stuPayListExample);
//    }
}
