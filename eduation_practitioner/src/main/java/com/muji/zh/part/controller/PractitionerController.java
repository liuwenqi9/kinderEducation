package com.muji.zh.part.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.*;
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

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/practitioner",description = "这是全部的/practitioner方法")
public class PractitionerController {
    @Reference
    private PractitionerService practitionerService;
    @Reference
    private ReplyService replyService;
    @Reference
    private CourseService courseService;
    @Reference
    private NoticeService noticeService;
    @Reference
    KindergartenService kindergartenService;
    @Reference
    StationService stationService;
    //添加投诉信息
    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;
    @Autowired
    private FastefsClient fastefsClient;

    @PostMapping(value = "/insert")
    @ApiOperation("添加从业者信息")
    @ResponseBody
    public String insert(@RequestBody String parms){
        // Practitioner practitioner
        //封装数据
        Practitioner practitioner = (Practitioner)JSONObject.parseObject(parms,Practitioner.class);
        //封装pid
        practitioner.setpId(JSONObject.parseObject(parms).getInteger("pId"));

        //处理上传头像
        String img= (String)JSONObject.parseObject(parms).get("image");
        if (img != null) {
            String png="data:image/png;base64,";
            MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);

            System.out.println(multipartFile);

            String filename =pathHead+ fastefsClient.uploFile(multipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setImage(filename);
        }

        //处理园长资格健康照片
        String certificate = (String)JSONObject.parseObject(parms).get("certificate");
        if (certificate != null) {
            String certificatePng="data:image/png;base64,";
            MultipartFile certificatemultipartFile= BASE64DecodedMultipartFile.base64ToMultipart(certificatePng+img);

            String certificatefilename1 =pathHead+ fastefsClient.uploFile(certificatemultipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setCertificate(certificatefilename1);
        }

        //处理心理健康照片
        String mentalImage = (String)JSONObject.parseObject(parms).get("mentalImage");
        if (mentalImage != null) {
            String mentalImagePng="data:image/png;base64,";
            MultipartFile MentalImagemultipartFile= BASE64DecodedMultipartFile.base64ToMultipart(mentalImagePng+img);

            String MentalImagefilename =pathHead+ fastefsClient.uploFile(MentalImagemultipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setMentalImage(MentalImagefilename);
        }

        //处理身体健康照片
        String physicalImage = (String)JSONObject.parseObject(parms).get("physicalImage");
        if (mentalImage != null) {
            String physicalImagePng="data:image/png;base64,";
            MultipartFile physicalImagemultipartFile= BASE64DecodedMultipartFile.base64ToMultipart(physicalImagePng+img);

            String physicalImagefilename =pathHead+ fastefsClient.uploFile(physicalImagemultipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setPhysicalImage(physicalImagefilename);
        }

        if(practitioner!=null){
            practitionerService.insertSelective(practitioner);              //使用insertSelective 插入数据  为空不插入
        }
        Map<String,Object> map = new HashMap <>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    @PostMapping(value = "/updateByPrimaryKeySelective")
    @ApiOperation("修改从业者信息")
    @ResponseBody
    public String updateByPrimaryKeySelective(@RequestBody String parms){
        //Practitioner practitioner
        Practitioner practitioner = (Practitioner)JSONObject.parseObject(parms,Practitioner.class);

        //处理上传头像
        String img= (String)JSONObject.parseObject(parms).get("image");
        if (img != null) {
            String png="data:image/png;base64,";
            MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);
            String filename =pathHead+ fastefsClient.uploFile(multipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setImage(filename);
        }

        //处理园长资格健康照片
        String certificate = (String)JSONObject.parseObject(parms).getString("certificate");
        if (certificate != null) {
            String certificatePng="data:image/png;base64,";
            MultipartFile certificatemultipartFile = BASE64DecodedMultipartFile.base64ToMultipart(certificatePng+certificate);
            String certificatefilename =pathHead+ fastefsClient.uploFile(certificatemultipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setCertificate(certificatefilename);
        }

        //处理心理健康照片
        String mentalImage = (String)JSONObject.parseObject(parms).getString("mentalImage");
        if (mentalImage != null) {
            String mentalImagePng="data:image/png;base64,";
            MultipartFile MentalImagemultipartFile= BASE64DecodedMultipartFile.base64ToMultipart(mentalImagePng+mentalImage);

            String mentalImagefilename =pathHead+ fastefsClient.uploFile(MentalImagemultipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setMentalImage(mentalImagefilename);
        }

        //处理身体健康照片
        String physicalImage = (String)JSONObject.parseObject(parms).getString("physicalImage");
        if (physicalImage != null) {
            String physicalImagePng="data:image/png;base64,";
            MultipartFile physicalImagemultipartFile= BASE64DecodedMultipartFile.base64ToMultipart(physicalImagePng+physicalImage);

            String physicalImagefilename =pathHead+ fastefsClient.uploFile(physicalImagemultipartFile);
            //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
            //将上传到云上的图片的Url 插入到image属性中
            practitioner.setPhysicalImage(physicalImagefilename);
        }

        if(practitioner!=null)
            practitionerService.updateByPrimaryKeySelective(practitioner);              //使用insertSelective 插入数据  为空不插入
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();

    }

    @PostMapping(value = "/deleteByPrimaryKey")
    @ApiOperation("删除从业者信息")
    @ResponseBody
    public String deleteByPrimaryKey(@RequestBody String parms){
        //Integer id
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获得 从业者 id
        Integer id = jsonObject.getInteger("id");
        if(id!=null){
            practitionerService.deleteByPrimaryKey(id);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //从业者查看 回复信息 通过ID
    @PostMapping(value = "/selectReplyByCIdAndWhoId")
    @ApiOperation("从业者查询回复信息")
    @ResponseBody
    public String selectReplyByCIdAndWhoId(@RequestBody String parms){
        // Integer id
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //拿到 回复信息 id
        Integer id = jsonObject.getInteger("cId");
        //拿到 从业者 who_id
        Integer  who_id = jsonObject.getInteger("whoId");
        List<Reply> replies = null;
        if(id!=null&&who_id!=null)
            replies = replyService.selectReplyByCIdAndWhoId(id,who_id);

        Map<String,Object> map = new HashMap<>();
        map.put("replies",replies);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //从业者查看个人信息
    //从业者查看 回复信息 通过ID
    @PostMapping(value = "/selectByPrimaryKeyById")
    @ApiOperation("查询从业者个人信息")
    @ResponseBody
    public String selectByPrimaryKey(@RequestBody String parms){
        //Integer id
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //获得 从业者id
        Integer id = jsonObject.getInteger("id");
        Practitioner practitioner = null;
        if(id!=null){
            practitioner = practitionerService.selectByPrimaryKey(id);
            if (practitioner.getKinderId() != null) {
                //幼儿园Id 不为空  查询幼儿园表  拿到幼儿园名称  插入到Flag4 字段
                Integer kId = practitioner.getKinderId();
                Kindergarten kindergarten = kindergartenService.selectByPrimaryKey(kId);
                practitioner.setFlag4(kindergarten.getKname());
            }
            if (practitioner.getpId() != null) {
                //pId 不为空  查询岗位  将岗位 映射到 Flag3字段  但是不会插入到数据库 只抛给前台
                Station station = stationService.selectByPrimaryKey(practitioner.getpId());
                practitioner.setFlag3(station.getSname());
            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("practitioner",practitioner);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //查询 课程资源
    //调用 写好的接口和实现方法   根据查询 目标ID  和  类别 ID  查询课程信息
    @PostMapping(value = "/selectAllCourses")
    @ApiOperation("从业者查询课程资源信息")
    @ResponseBody
    public String selectAllCourses(@RequestBody String parms){
        //Integer id,Integer t_id
        //封装数据
        JSONObject jsonObject = JSONObject.parseObject(parms);
       /* //获得 类别id
        Integer t_id = jsonObject.getInteger("tId");*/
        //获得投诉目标id
        //Integer aim = jsonObject.getInteger("aim");

        //查询课程资源信息
        List<Course> courses = courseService.selectAllCourse();
        Map<String,Object> map = new HashMap<>();
        map.put("courses",courses);
        map.put("status",200);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }

    //从业者查询通知公告
    @PostMapping(value = "/selectByAimAndSign")
    @ApiOperation("从业者查询通知公告")
    @ResponseBody
    public String selectByAimAndSign(){
        List<Notice> notices = noticeService.selectByAimAndSign();
        System.out.println("notices = " + notices);
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        if (notices != null) {
            for(Notice n:notices){
               if(n.getCreateDate()!=null){
                   n.setFalg4(s.format(n.getCreateDate()));
               }
            }
            map.put("notices",notices);
            map.put("status",200);
        }
        //公告资源不存在
        map.put("status",404);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));
        return json.toJSONString();
    }
}
