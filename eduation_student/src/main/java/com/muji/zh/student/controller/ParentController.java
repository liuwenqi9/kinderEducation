package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.*;
import com.muji.zh.config.service.FastefsClient;
import com.muji.zh.student.Json.ParentJson;
import com.muji.zh.student.util.BASE64DecodedMultipartFile;
import com.muji.zh.student.util.StatusUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Api(value = "/Parent", description = "这是全部的/Parent方法")
public class ParentController {


    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;

    @Autowired
    private FastefsClient fastefsClient;

    @Reference
    private ParentService parentService;

    @Reference
    private ReplyService replyService;

    @Reference
    private StudentService studentService;

    @Reference
    private StuParentService stuParentService;

    @Reference
    private ClasService clasService;


    @Reference
    private CourseService courseService;

    @Reference
    private ComTypeService comTypeService;

    @Reference
    private PractitionerService practitionerService;


    @Reference
    private KindergartenService kindergartenService;

    @Reference
    private ComplaintService complaintService;


    @PostMapping(value = "/updateParents")
    @ApiOperation("家长更新信息")
    @ResponseBody
    public String upadetParent(@RequestBody String parms, HttpSession session) {

        String s = parms;
        System.out.println(JSON.parse(s));
        JSONObject jsonObject = JSONObject.parseObject(s);

        String img= (String) jsonObject.get("img");
        String png="data:image/png;base64,";
        MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);

        System.out.println(multipartFile);

        String filename =pathHead+ fastefsClient.uploFile(multipartFile);

        System.out.println(filename);
        //jsonObject.parseObject(parms, Parent.class);
        Parent parent = jsonObject.parseObject(parms, Parent.class);
        parent.setImage(filename);
        System.out.println(parent);

        parentService.updateByPrimaryKeySelective(parent);

        return StatusUtil.getStatus("200");


    }

    @PostMapping(value = "/login")
    @ApiOperation("家长登录")
    @ResponseBody
    public String zh_login_Parent(@RequestBody String parms, HttpSession session) {

        String s = parms;

        System.out.println(JSON.parse(s));

        JSONObject jsonObject = JSONObject.parseObject(s);


        Parent parent = jsonObject.parseObject(parms, Parent.class);

        Parent parent1 = parentService.login(parent);


        if (parent1 != null) {

            List<StuParent> lists = stuParentService.findBy(parent1.getId());
            if (lists != null) {

                try {
                    StuParent stuParent = lists.get(0);
                    if (stuParent != null) {

                        //List<Student> list = studentService.findByPid(parent1.getId());

                        Map<String, Object> map = new HashMap<>();
//                        map.put("studentList", list);
                        map.put("status", 200);
                        map.put("sex",parent1.getSex());
                        map.put("id", parent1.getId());
                        map.put("pname", parent1.getPname());
                        map.put("image",parent1.getImage());
                        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));

                        System.out.println(jsonObject1.toJSONString());
                        return jsonObject1.toJSONString();

                    } else {
                        Map<String, Object> map = new HashMap<>();
                        map.put("status", 203);
                        map.put("image",parent1.getImage());
                        map.put("id", parent1.getId());
                        map.put("pname", parent1.getPname());
                        map.put("sex",parent1.getSex());
                        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));

                        System.out.println(jsonObject1.toJSONString());
                        return jsonObject1.toJSONString();
                    }

                } catch (Exception e) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("status", 203);
                    map.put("pname", parent1.getPname());
                    map.put("id", parent1.getId());
                    map.put("sex",parent1.getSex());
                    map.put("image",parent1.getImage());

                    JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));

                    System.out.println(jsonObject1.toJSONString());
                    return jsonObject1.toJSONString();


                }

            } else {
                //203 提示绑定信息
                Map<String, Object> map = new HashMap<>();
                map.put("status", 203);
                map.put("image",parent1.getImage());
                map.put("id", parent1.getId());
                map.put("pname", parent1.getPname());
                map.put("sex",parent1.getSex());
                JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));

                System.out.println(jsonObject1.toJSONString());
                return jsonObject1.toJSONString();
            }
        }else {
            return StatusUtil.getStatus("404");
        }


    }


    @PostMapping("/parentManager")
    @ApiOperation("家长个人信息")
    @ResponseBody
    public String parentManager(@RequestBody String parms, HttpSession session) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("id");
        Parent parent = parentService.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();

        map.put("parent", parent);
        map.put("status", 200);
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();

    }




    @PostMapping("/findByID")
    @ApiOperation("家长id")
    @ResponseBody
    public String findByPID(@RequestBody String parms, HttpSession session) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        //JSONObject jsonObject = JSONObject.parseObject(parms);
        Parent parent = jsonObject.parseObject(parms, Parent.class);

        List<Student> list = studentService.findByPid(parent.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("studentList", list);
        map.put("pId", parent.getId());
        map.put("status", 200);
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();

    }


    @PostMapping("/findBySID")
    @ApiOperation("家长id")
    @ResponseBody
    public String findBySID(@RequestBody String parms, HttpSession session) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("id");
        Student student = studentService.selectByPrimaryKey(id);

        Clas clas = clasService.selectByPrimaryKey(student.getClasId());

        Map<String, Object> map = new HashMap<>();
        map.put("sname", student.getSname());
        map.put("stuId", student.getStuId());
        map.put("className", clas.getCname());
        map.put("areaId", student.getAreaId());
        map.put("ubranId", student.getUbranId());
        map.put("eduId", student.getEduId());
        map.put("status", 200);
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();

    }

    @PostMapping("/findByCourse")
    @ApiOperation("家长id")
    @ResponseBody
    public String findBySID(@RequestBody String parms) {


        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("areaId");
        //Student student=studentService.selectByPrimaryKey(id);
        List<Course> coursesList = courseService.findByAreaID(id);
        Map<String, Object> map = new HashMap<>();
        map.put("CourseList", coursesList);
        map.put("status", 200);
        Gson gson = new Gson();
        System.out.println(gson.toJson(map).toString());
        return gson.toJson(map).toString();
    }

    @PostMapping("/findByIdToComplaint")
    @ApiOperation("欲投诉")
    @ResponseBody
    public String findByIdToComplaint(@RequestBody String parms) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("id");
        Student student = studentService.selectByPrimaryKey(id);
        Kindergarten kindergarten = kindergartenService.selectByPrimaryKey(student.getKid());
        System.out.println(kindergarten.getkId());
        List<Practitioner> practitionerList = practitionerService.findByKidToPract(kindergarten.getkId());
        List<ComType> comTypeList = comTypeService.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("practitionerList", practitionerList);
        map.put("comTypeList", comTypeList);
        map.put("status", 200);
        map.put("kinderName", kindergarten.getKname());
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();
    }


    @PostMapping("/insertComplaint")
    @ApiOperation("投诉")
    @ResponseBody
    public String insertComplaint(@RequestBody String parms) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Complaint complaint = jsonObject.parseObject(parms, Complaint.class);
        System.out.println(complaint);
        String img=jsonObject.getString("img");

        String png="data:image/png;base64,";
        MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);

        System.out.println(multipartFile);

        String filename =pathHead+ fastefsClient.uploFile(multipartFile);
        complaint.setImage(filename);
        complaint.setCname("sss");
        complaint.settId(Integer.parseInt(jsonObject.getString("tId")));
        System.out.println(Integer.parseInt(jsonObject.getString("oId")));

        complaint.setWhoId(Integer.parseInt(jsonObject.getString("whoId")));
        // complaint.setSign(Integer.parseInt(jsonObject.getString("sign")));
        complaint.setUbarnId(Integer.parseInt(jsonObject.getString("ubarnId")));
        System.out.println("-------------------------------");
        System.out.println(complaint.getoId());
        if (jsonObject.getString("oId") != null) {
            complaint.setoId(Integer.parseInt(jsonObject.getString("oId")));
            complaint.setFlag1("1");
            complaint.setSign(0);


        } else {
            complaint.setoId(Integer.parseInt(jsonObject.getString("sign")));
            complaint.setSign(0);
        }
        Date date = new Date();
        complaint.setCreateDate(date);
        complaintService.insertSelective(complaint);
        return StatusUtil.getStatus("200");
    }

    @PostMapping("/complaintList")
    @ApiOperation("投诉回复列表")
    @ResponseBody
    public String complaintList(@RequestBody String parms) throws ParseException {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);

        Integer sid = jsonObject.getInteger("sid");


        List<Complaint> complaintList = complaintService.findByFromWhoId(sid);
        Map<String, Object> map = new HashMap<>();
        for (int i = complaintList.size()-1; i >=0; i--) {
            ComType comType = comTypeService.selectByPrimaryKey(complaintList.get(i).gettId());
            complaintList.get(i).setCname(comType.getCname());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(complaintList.get(i).getCreateDate());
            complaintList.get(i).setFlag3(date);
            System.out.println(date);
            System.out.println("========================");
            if (complaintList.get(i).getFlag1().equals("0")) {
                Kindergarten kindergarten = kindergartenService.selectByPrimaryKey(complaintList.get(i).getoId());

                complaintList.get(i).setFlag2(kindergarten.getKname());

            } else {
                Practitioner practitioner = practitionerService.selectByPrimaryKey(complaintList.get(i).getoId());
                System.out.println(practitioner.getPname());
                System.out.println("_____________");
                complaintList.get(i).setFlag2(practitioner.getPname());
            }
        }
        map.put("complaintList", complaintList);
        map.put("status", 200);
        Gson gson = new Gson();
        gson.toJson(map);

        System.out.println(gson.toJson(map));
        return gson.toJson(map).toString();


    }


    @PostMapping("/replyList")
    @ApiOperation("投诉回复列表")
    @ResponseBody
    public String replyList(@RequestBody String parms) throws ParseException {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);

        Integer cid = jsonObject.getInteger("cid");
        Complaint complaint = complaintService.selectByPrimaryKey(cid);

        ComType comType = comTypeService.selectByPrimaryKey(complaint.gettId());
        complaint.setCname(comType.getCname());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(complaint.getCreateDate());
        complaint.setFlag3(date);
        if (complaint.getFlag1().equals("0")) {
            Kindergarten kindergarten = kindergartenService.selectByPrimaryKey(complaint.getoId());

            complaint.setFlag2(kindergarten.getKname());

        } else {
            Practitioner practitioner = practitionerService.selectByPrimaryKey(complaint.getoId());
            System.out.println(practitioner.getPname());
            System.out.println("_____________");
            complaint.setFlag2(practitioner.getPname());
        }

        List<Reply> replyList = replyService.selectReplyBycid(cid);
        Map<String, Object> map = new HashMap<>();
        for (int i = replyList.size()-1; i >=0;  i--) {
            Date date1 = replyList.get(i).getCreateDate();

            String s = simpleDateFormat.format(date1);


            replyList.get(i).setFlag3(s);


        }

        map.put("replyList", replyList);
        map.put("status", 200);

        map.put("complaint", complaint);
        Gson gson = new Gson();
        gson.toJson(map);

        System.out.println(gson.toJson(map));
        return gson.toJson(map).toString();

    }


    //@POMapping(value = "/add",method = RequestMethod.POST)
    @PostMapping(value = "/add")
    @ApiOperation("家长信息录入 / 家长注册")
    @ResponseBody
    public int zh_insert_Parent(@RequestBody String parm) {

        System.out.println(JSON.parse(parm));
        JSONObject jsonObject = JSONObject.parseObject(parm);
        //String image = jsonObject.getString("img");
        String img= (String) jsonObject.get("img");
        String png="data:image/png;base64,";
        MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);

        System.out.println(multipartFile);

        String filename =pathHead+ fastefsClient.uploFile(multipartFile);

        jsonObject.parseObject(parm, Parent.class);
        Parent parent = jsonObject.parseObject(parm, Parent.class);
        parent.setImage(filename);
        System.out.println(parent);

        return parentService.insert(parent);
    }





}
