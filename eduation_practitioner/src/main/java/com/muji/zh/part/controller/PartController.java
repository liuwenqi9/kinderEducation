package com.muji.zh.part.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.PartLogin;
import com.muji.zh.admin.model.Practitioner;
import com.muji.zh.admin.service.PartLoginService;
import com.muji.zh.admin.service.PractitionerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(value = "/part",description = "这是全部的/part方法")
public class PartController {
    @Reference
    private PartLoginService partLoginService;
    @Reference
    private PractitionerService practitionerService;

    @PostMapping(value = "/add")
    @ApiOperation("添加从业者登陆信息")
    @ResponseBody
    public String add(@RequestBody String parms){
        PartLogin partLogin = JSONObject.parseObject(parms,PartLogin.class);
        if(partLogin!=null) {
            //如果 前台传进来的数据不为空 将数据封装到 对象中 插入到数据库
            partLoginService.insertSelective(partLogin);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("map",map);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    @PostMapping(value = "/updatePartLoginByPrimaryKeySelective")
    @ApiOperation("修改密码")
    @ResponseBody
    public String updatePartLoginByPrimaryKeySelective(@RequestBody String parms){
        PartLogin partLogin = JSONObject.parseObject(parms,PartLogin.class);
        if(partLogin!=null){
            partLoginService.updateByPrimaryKeySelective(partLogin);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

//    @RequestMapping("Login")
//    public String Loging(){
//        return "Login";
//    }
    /*****************************************************************************************************************/
    @PostMapping(value="/PractionterLogin")
    @ApiOperation("从业者登陆")
    @ResponseBody
    public String LoginAction(@RequestBody String parms){
        //将 前台数据封装成JSONObject 对象
       JSONObject jsonObject = JSONObject.parseObject(parms);
       Integer id = jsonObject.getInteger("id");
       // 拿到密码
       String password = jsonObject.getString("password");

        //拿到工号 查询 从业者表 是否存在 此从业者
        Map<String,Object> map = new HashMap<>();
        Practitioner practitioner = null;

       if(id!=null&&password!=null){
           //进行登陆验证  获得Id 工号
          Integer partLoginId =  partLoginService.selectByIdAndPassword(id,password);
           System.out.println("partLoginId = " + partLoginId);
          //说明 没有此从业者
           if (partLoginId == null||partLoginId.equals("")) {
               //说明没有此从业者  返回给前台 状态码 404
               map.put("status",404);
           }else{
               //说明有此从业者,查看从业者是否有身份证信息 如果有 则返回200  没有 则返回203
               practitioner = practitionerService.selectByPrimaryKey(id);
               if (practitioner.getIdCard() == null ||practitioner.getIdCard().equals("")) {
                   //说明没有 身份证号  没有绑定
                   map.put("id",practitioner.getId());
                   map.put("pname",practitioner.getPname());
                   System.out.println(practitioner.getPname());
                   map.put("status",203);
               }else{
                   //说明 有此人身份证编号    返回给前台  image id pname
                   //拿到从业者图像信息
                   String image = partLoginService.selectImageById(id);
                   System.out.println("image:"+image);
                   map.put("id",practitioner.getId());
                   map.put("pname",practitioner.getPname());
                   System.out.println(practitioner.getPname());
                   map.put("image",image);
                   map.put("positionalTitles",practitioner.getPositionalTitles());
                   map.put("status",200);
               }
           }
       }
        //返回给前台
        JSON json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }
}
