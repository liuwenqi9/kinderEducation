package com.muji.zh.part.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.ComType;
import com.muji.zh.admin.model.Complaint;
import com.muji.zh.admin.model.Kindergarten;
import com.muji.zh.admin.model.Reply;
import com.muji.zh.admin.service.ComTypeService;
import com.muji.zh.admin.service.ComplaintService;
import com.muji.zh.admin.service.KindergartenService;
import com.muji.zh.admin.service.ReplyService;
import com.muji.zh.config.service.FastefsClient;
import com.muji.zh.utils.BASE64DecodedMultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/complaint",description = "这是全部的/complaint方法")
public class ComplaintController {

    @Reference
    private ComplaintService complaintService;

    @Reference
    private ComTypeService comTypeService;
    @Reference
    private KindergartenService kindergartenService;
    @Reference
    private ReplyService replyService;

    //添加投诉信息
    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;
    @Autowired
    private FastefsClient fastefsClient;


    @PostMapping(value = "/insertSelectiveComplaint")
    @ApiOperation("添加投诉信息")
    @ResponseBody
    public String insertSelective(@RequestBody String parms){

        System.out.print("parms:"+parms);
        //        Complaint complaint
        //将前台数据转换成Json 数据
        Complaint complaint =(Complaint)JSONObject.parseObject(parms,Complaint.class);
        //获得 tId
        Integer tId = JSONObject.parseObject(parms).getInteger("tId");
        //将tId 映射到 Complain
        complaint.settId(tId);
        //将当前日期存到数据库中
        complaint.setCreateDate(new Date());
        //将oId 映射到Complaint中
        Integer oId = JSONObject.parseObject(parms).getInteger("oId");
        complaint.setoId(oId);
        //拿到幼儿园 oId 查找幼儿园名称
        Kindergarten kindergarten = kindergartenService.selectByPrimaryKey(oId);
        //将 幼儿园名称 插入到cname中
        complaint.setCname(kindergarten.getKname());

        //拿到 投诉类别ID 将 投诉名称  掺入到flag1中
        ComType comType = comTypeService.selectByPrimaryKey(complaint.gettId());
        System.out.println("cname:"+comType.getCname());
        complaint.setFlag1(comType.getCname());
        //将投诉 对象设置为 所在得幼儿园
        complaint.setCname(kindergartenService.selectByPrimaryKey(complaint.getoId()).getKname());


          //处理图片
         String img= (String)JSONObject.parseObject(parms).get("img");
         String png="data:image/png;base64,";
         MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);

         System.out.println(multipartFile);

         String filename =pathHead+ fastefsClient.uploFile(multipartFile);
         //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
         complaint.setImage(filename);



        if(complaint!=null){
            //如果 不为空  插入到数据库中
            //将数据添加到数据库中
            complaintService.insertSelective(complaint);
        }
        Map<String,Object> map =  new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //修改投诉信息
    @PostMapping(value = "/updateByPrimaryKeySelectiveComplaint")
    @ApiOperation("修改投诉信息")
    @ResponseBody
    public String updateByPrimaryKeySelective(@RequestBody String parms){
        //Complaint complaint
        //封装数据 将 Json数据 转换成 对象 更新数据库
        Complaint complaint =(Complaint) JSONObject.parseObject(parms,Complaint.class);
        //判断是否转换成Java 对象
        if(complaint!=null){
            //不为空  更新数据库
            complaintService.updateByPrimaryKeySelective(complaint);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        //将map转换成 json
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //删除投诉信息
    @PostMapping(value = "/deleteByPrimaryKeyComplaint")
    @ApiOperation("删除投诉信息")
    @ResponseBody
    public String deleteByPrimaryKey(@RequestBody String parms){
        //Integer id
        //封装数据
        JSONObject jsonObject = JSONObject.parseObject(parms);
        // 投诉记录 id
        Integer id = jsonObject.getInteger("id");
        // 从业者 id (谁投诉)
        Integer whoId = jsonObject.getInteger("whoId");
        if(id!=null&&whoId!=null){
            //如果id 不为空 删除数据库记录
            complaintService.deleteByIdAndWhoId(id,whoId);
       }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查询历史投诉信息  who_id
    @PostMapping(value = "/selectHistoryComplaintInfo")
    @ApiOperation("查询历史投诉信息")
    @ResponseBody
    public String selectHistoryComplaintInfo(@RequestBody String parms) throws ParseException {
        //Integer who_id
        //封装数据
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获取id 值
        Integer whoId = jsonObject.getInteger("whoId");
        List<Complaint> complaintList = null;
        if(whoId!=null){
            complaintList = complaintService.selectHistoryComplaintInfo(whoId);
            for(Complaint c:complaintList){
                //将投诉时间  正常化
                Date createDate = c.getCreateDate();
                if(createDate==null){
                    continue;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String format = simpleDateFormat.format(createDate);
                c.setFlag4(format);
                //拿到 t_id 将幼儿园名称 设置为投诉对象
                //c.setCname(kindergartenService.selectByPrimaryKey(c.getoId()).getKname());
                //将投诉类别 插入到Flag1中
                //c.setFlag1(comTypeService.selectByPrimaryKey(c.gettId()).getCname());
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("complaintList",complaintList);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查询历史投诉信息  who_id
    @PostMapping(value = "/selectByIdAndWhoId")
    @ApiOperation("查询单个投诉信息")
    @ResponseBody
    public String selectByIdAndWhoId(@RequestBody String parms) throws ParseException {
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获得  id
        Integer id = jsonObject.getInteger("id");
        //获得  whoId
        Integer whoId = jsonObject.getInteger("whoId");
        Map<String,Object> map = new HashMap<>();
        if (whoId != null&&id!=null) {
            Complaint complaint = complaintService.selectByIdAndWhoId(id, whoId);
            if (complaint != null) {
                //将投诉时间  正常化
                Date date = complaint.getCreateDate();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                complaint.setFlag4(simpleDateFormat.format(date));

                //查看sign 状态 如果sign是0 为未处理,1是处理已完成,2是属实未处理
                if(complaint.getSign()==1){
                    //处理已经完成则可以查询到 回复信息 查询回复表
                    List<Reply> replies = replyService.selectReplyByCIdAndWhoId(id, whoId);
                    for (Reply r:replies){
                        r.setFlag4(simpleDateFormat.format(r.getCreateDate()));
                    }
                    map.put("replies",replies);
                }
                map.put("complaint",complaint);
                map.put("status",200);
            }
        }
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查找投诉类别 和  投诉类别ID--->List
    @PostMapping(value = "/selectAllComplaintType")
    @ApiOperation("查询所有的投诉类别")
    @ResponseBody
    public String selectAllComplaintType(){
        List<ComType> comTypes = comTypeService.selectAllComplaintType();
        //查询出来 类别 和 ID 返回给前台
        Map<String,Object> map = new HashMap<>();
        if (comTypes != null) {
            map.put("comTypes",comTypes);
            map.put("status",200);
        }
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }
}
