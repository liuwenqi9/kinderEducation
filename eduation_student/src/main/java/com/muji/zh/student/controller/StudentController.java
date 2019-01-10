package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.*;
import com.muji.zh.config.service.AsyncThreadPool;
import com.muji.zh.config.service.FastefsClient;
import com.muji.zh.student.util.BASE64DecodedMultipartFile;
import com.muji.zh.student.util.Base64Utils;
import com.muji.zh.student.util.StatusUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@Api(value = "/Student", description = "这是全部的/Student方法")
public class StudentController {
    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;

    @Autowired
    private FastefsClient fastefsClient;

    @Reference
    private StudentService studentService;

    @Reference
    private EducationService educationService;

    @Reference
    private ClasService clasService;

    @Reference
    private ParentService parentService;
    @Reference
    private AreaService areaService;

    @Reference
    private StuParentService stuParentService;

    @Reference
    private KindergartenService kindergartenService;


    @RequestMapping(value = "/toFindArea", method = RequestMethod.POST)
    @ApiOperation("欲添加")
    @ResponseBody
    public String toFindArea(@RequestBody String parms, HttpSession session) {

        List<Area> areaList=areaService.findAll();


        Map<String, Object> maps = new HashMap<>();
        maps.put("areaList", areaList);

        Gson gson = new Gson();
        gson.toJson(maps);

        System.out.println(gson.toJson(maps).toString());
        System.out.println("-------------------------");
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(maps));
        System.out.println(JSON.toJSONString(maps).toString());
        jsonObject1.put("status", 200);
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();






    }



    @RequestMapping(value = "/toAddStudent", method = RequestMethod.POST)
    @ApiOperation("欲添加")
    @ResponseBody
    public String findByPID(@RequestBody String parms, HttpSession session) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);

        String area_id=jsonObject.getString("areaId");







        List<Kindergarten> list = kindergartenService.findByareaID(area_id);


        Map<String, Object> maps = new HashMap<>();

        List<Kindergarten> kindergartenList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Kindergarten kindergarten = new Kindergarten();
            kindergarten.setKtId(list.get(i).getkId());
            kindergarten.setKname(list.get(i).getKname());

            kindergartenList.add(i, kindergarten);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("kinderList", kindergartenList);
        System.out.println(map.get("kinderList"));
        // map.put("pId",parent.getId());
        map.put("status", 200);
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();


    }


    @RequestMapping(value = "/findByKid", method = RequestMethod.POST)
    @ApiOperation("根据幼儿园获取班级ID,NAME")
    @ResponseBody
    public String findByKid(@RequestBody String parms, HttpSession session) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);

        String kId = jsonObject.getString("kId");


        List<Clas> clasList = clasService.findByToKid(Integer.parseInt(kId));
        System.out.println("================================" + kId);
        Map<String, List<Clas>> maps = new HashMap<>();
        maps.put("classList", clasList);
        // map.put("pId",parent.getId());
        // Map<String, Object> map = new HashMap<>();
        System.out.println(maps.get("classList"));
        Gson gson = new Gson();
        gson.toJson(maps);

        System.out.println(gson.toJson(maps).toString());
        System.out.println("-------------------------");
        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(maps));
        System.out.println(JSON.toJSONString(maps).toString());
        jsonObject1.put("status", 200);
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();


    }


    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    @ApiOperation("绑定学生。添加学生")
//    @ApiImplicitParam(name = "{\n" +
//            "\t\"id\": \"1615925014\",\n" +
//            "\t\"sname\": \"5555\",\n" +
//            "\t\"sex\": \"男\",\n" +
//            "\t\"img\": \"iVBORw0KGgoAAAANSUhEUgAAADgAAAAKCAIAAABuVgrvAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAA7EAAAOxAGVKw4bAAAC2klEQVQ4jb2TbUhTYRTH/7bZnPNtOdc0XSLzPW1KhWkiaaFoWRnWh15UpGFQBJIhoxfoQ0pfQsQIQ3zJgiLElDSzjMA0irQX1NTQIc7dqeB0m7bt7rl9uHS9WpBkdLg8nPvnnN//8HAel4oBI/5pzE9Tw/cqG2vuckrplWt0bJIyWr0erNDmJOuebUXYCXne3pa4N41TJsbHj5YnrtPI5Xqfft2z/Y9Y643qulq/PqoJSk6PPnH2r81mB/oAyKLjV2EjjhUGpx78w6Df1zaoIiWLJgyANdb/NkyGSQAeEcvLqkjJUqRkrQXrcq57bAVrqH/ozg02jyzS+kTGGV4/1TXVsUpwTv4SpTf2dAbn5APQNdVtTtwfclzza9fYw2pjTydf6b2Qy7mwXRw57nKlm58CAN8rski7ND3F/Qpi887TDMN9hq5W96CQ8OIygVhis5jh7jFaXS7bvS+8uIxeMNktC4G5ZwRiCWEgS84UiCUbJJ4ipWrsftVGH99tV2/TC6ZFo17oF6B7ULXlcJ5Ko2U5IqXKPz1XIJZ4RahVGq1nVDzNMGJlqGRr6NyH7k17MiCWWGcMnJd5+PP8t8HAXA3V8RhAlLZCaKOX79w+S832vgDAngDEYWoA7lE7bDQR+gUAsNHESRh+YqamrLoRZWGpjSbyI4VsozQhTd9cr2+uB6DIPs26cI2co8PJALDTBDSxGA2cl2dsAtXSYKampAlpAOAjX7GjDsIA8D1wyjspY2nkEwAbYQCYvrxjpHKqpcFrV6q7kyxSkwBcpw2s4hqmZmuEqpj5N88AbPTzn3v70r/gEgBD7U0HYVgXlj831A9AHLYdgIMQ1oU4CSOVA7Aa9UJVzNzHXpEylEjlzp8PwyW7fZC/o5aejvm2Rjb3zjzpkZjOVwDI8koWXjXbJ0b5imPGwO9yC1cbb13kY2V5JaLQWNOTWuv7LgCSnak+hwr4ZLZglcLH/gBWNohN8EKUZgAAAABJRU5ErkJggg==\",\n" +
//            "\t\"birthday\": \"199\",\n" +
//            "\t\"stuId\": \"123456\",\n" +
//            "\t\"kid\": \"1\",\n" +
//            "\t\"clasId\": \"11\",\n" +
//            "\t\"pId\": \"11\",\n" +
//            "\t\"relation\": \"父亲\"\n" +
//            "}")
    @ResponseBody
    public String insertStudent(@RequestBody String parms, HttpSession session, HttpServletRequest req) throws IOException {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);

        Student student = jsonObject.parseObject(parms, Student.class);
        String rel = jsonObject.getString("relation");
        String ic_ID = jsonObject.getString("pId");
        String img= (String) jsonObject.get("img");
        String area_id=jsonObject.getString("areaId");
        String png="data:image/png;base64,";
        MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);

        System.out.println(multipartFile);

        String filename =pathHead+ fastefsClient.uploFile(multipartFile);
        //fastefsClient.deleteFile("http://119.29.230.78:9999/group1/M00/00/01/rBAQA1wXKFiAXqVwAAADOl4SmZY814.png");
        student.setImage(filename);

       // FileUtil.GenerateImage(pa,img);


        Parent parent = parentService.selectByPrimaryKey(Integer.parseInt(ic_ID));
        student.setCreateDate(new Date());

        student.setAreaId(Integer.parseInt(area_id));

        Education education = educationService.findByAreaId(area_id);
        student.setEduId(education.geteId());
        student.setUbranId(410100);


        studentService.insertSelective(student);


        if (rel.equals("父亲")) {

            StuParent stuParent = new StuParent();
            Student student1 = studentService.findBYStuID(student.getStuId());
            stuParent.setRelation("第一监护人");
            stuParent.setRelationname(rel);
            stuParent.setPid(Integer.parseInt(ic_ID));
            stuParent.setSid(student1.getId());

            stuParentService.insertSelective(stuParent);

        } else if (rel.equals("母亲")) {
            StuParent stuParent = new StuParent();
            Student student1 = studentService.findBYStuID(student.getStuId());
            stuParent.setRelation("第二监护人");
            stuParent.setRelationname(rel);
            stuParent.setPid(Integer.parseInt(ic_ID));
            stuParent.setSid(student1.getId());

            stuParentService.insertSelective(stuParent);
        }

        return StatusUtil.getStatus("200");
    }




    @RequestMapping(value = "/findByStudent", method = RequestMethod.POST)
    @ApiOperation("查看学生信息")
    @ResponseBody
    public String findByStudent(@RequestBody String parms, HttpSession session) {
        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);

        String sID = jsonObject.getString("sId");



        Student student = studentService.selectByPrimaryKey(Integer.parseInt(sID));
        System.out.println(student);
        System.out.println(student);
        Kindergarten kindergarten = kindergartenService.selectByPrimaryKey(student.getKid());

        Clas clas = clasService.selectByPrimaryKey(student.getClasId());

        Map<String, Object> map = new HashMap<>();


        StuParent stuParent=stuParentService.findBySid_Pid(sID);


        Parent parent=parentService.selectByPrimaryKey(stuParent.getPid());


        map.put("sname",student.getSname());
        map.put("sex", student.getSex());
        map.put("stuId", student.getStuId());
        map.put("address", student.getBirthday());
        map.put("pname",parent.getPname() );
        map.put("cname", clas.getCname());
        map.put("kname",kindergarten.getKname() );
        map.put("relation", stuParent.getRelationname());
        map.put("img",student.getImage());
        map.put("relationName",student.getFlag1());
        map.put("relation2",student.getFalg2());
        map.put("phone",student.getFlag3());
        map.put("wages",student.getTuition());

        map.put("status",200);


        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        return jsonObject1.toJSONString();



    }




    @ResponseBody
    @ApiOperation("删除学生")
    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestBody String parms){

        System.out.println(parms);
        JSONObject jsonObject = JSONObject.parseObject(parms);
        Integer id = jsonObject.getInteger("sid");
        System.out.println(id);
        studentService.deleteByPrimaryKey(id);
        return StatusUtil.getStatus("200");

    }


    @ResponseBody
    @ApiOperation("修改学生")
    @PostMapping("/updateStudent")
    public String updateStudent(@RequestBody String parms) throws InterruptedException {


        Student student= JSONObject.parseObject(parms,Student.class);


        System.out.println(student);
        JSONObject jsonObject = JSONObject.parseObject(parms);

        String img= (String) jsonObject.get("img");
        String png="data:image/png;base64,";
        MultipartFile multipartFile= BASE64DecodedMultipartFile.base64ToMultipart(png+img);

        System.out.println(multipartFile);

        String filename =pathHead+ fastefsClient.uploFile(multipartFile);

        Thread.sleep(3000);
        student.setImage(filename);




        studentService.updateByPrimaryKeySelective(student);
        return StatusUtil.getStatus("200");

    }


    private void savePic(MultipartFile multipartFile, String filename, Long shopid) throws Exception{
        BufferedImage image = ImageIO.read(multipartFile.getInputStream());



//        Picture picture = new Picture();
//        picture.setFileName(filename);
//        picture.setHeight(image.getHeight());
//        picture.setWidth(image.getWidth());
//        picture.setPathInfo(pathHead);
//        picture.setCreate(new Date());
//        picture.setShopid(shopid);
//
//        pictureService.create(picture);

        System.out.println("----------------------------");
    }

}
