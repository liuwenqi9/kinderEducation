package com.muji.zh.eduuser.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.*;
import com.muji.zh.config.service.FastefsClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/EduUser", description = "这是全部的/EduUser方法")

public class EduUserController {


    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;

    @Autowired
    private FastefsClient fastefsClient;

    @Reference
    private EduUserService eduUserService;

    @Reference
    private EducationService educationService;

    @Reference
    private NoticeService noticeService;
    @Reference
    private AreaService areaService;

    @Reference
    private PractitionerService practitionerService;

    @Reference
    private KindergartenService kindergartenService;
    @Reference
    private StationService stationService;

    @Reference
    private ClasService clasService;

    @Reference
    private ClasTypeService clasTypeService;

    @Reference

    private StudentService studentService;


    @Reference
    private KindWarnService kindWarnService;
    @Reference
    private ComplaintService complaintService;
    @Reference
    private PartWarnService partWarnService;

    @RequestMapping(value = "/s")
    @ApiOperation("添加信息")

    public String test() {

        return "html/test";
    }


    @Reference
    private WraningService wraningService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加信息")
    @ResponseBody
    public String add(EduUser eduUser) {
        eduUserService.insertSelective(eduUser);
        return eduUser.toString();
    }

    @RequestMapping(value = "/toAddNotice")
    @ApiOperation(value = "欲添加公告")


    public String toAddNotice(Model model, HttpServletRequest req) throws ParseException {
        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");




        if(eduUser==null)
        {
            model.addAttribute("msg","登陆超时,重新登陆");
            return "/main/500";
        }


        if (eduUser.getSign() == 1) {
            String sex = "男";
            String woman = "女";

            List<Area> areaList = areaService.dinstinctName(eduUser.getAreaId());
            model.addAttribute("areaList", areaList);
            List<NoticeType> noticeTypeList = noticeService.distinctName();
            model.addAttribute("typeList", noticeTypeList);

            try{
                Notice notice=noticeService.findBy(1,eduUser.getEpId());

                model.addAttribute("notice",notice);
            }catch (Exception e)
            {
                e.printStackTrace();
            }


            int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
            int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
            model.addAttribute("publicCount", publicCount);
            Integer nopublicCount = sum - publicCount;
            model.addAttribute("sum", nopublicCount);

            System.out.println(publicCount);
            //查找从业者类别
            List<Station> list = stationService.find();
            //根据地区和从业者类别查询从业者总人数
            Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
            //根据地区和从业者类别查询从业者男性总人数

            model.addAttribute("mapSexTotal", mapSexTotal);

            Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

            Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

            model.addAttribute("mapSexMan", mapSexMan);
            model.addAttribute("mapSexWoman", mapSexWoman);


            //教师类别设为一
            int typeid = 2;
            //教师合格的人数
            int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
            //教师总人数
            model.addAttribute("mapQualified", mapQualified);

            int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
            model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
            //班级类型
            List<ClassType> typeList = clasTypeService.finds();


            Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

            String s = null;

            model.addAttribute("clasStu", clasStu);
            Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
            model.addAttribute("clasStuTotal", clasStuTotal);
            //幼儿园多少所
            long kinderTotal = kindergartenService.countTotal(eduUser);

            model.addAttribute("kinderTotal", kinderTotal);
            //从业者总人数
            long partTotal = practitionerService.countTotal(eduUser);

            model.addAttribute("partTotal", partTotal);
            //幼儿总人数
            long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

            model.addAttribute("studentTotal", studentTotal);

            long comeStudentToal = studentService.findByDate(eduUser);

            model.addAttribute("comeStudentToal", comeStudentToal);
            long leaveStudenttotal = studentTotal - comeStudentToal;
            model.addAttribute("leaveStudenttotal", leaveStudenttotal);

            //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
            // model.addAttribute("mapStudentList",mapStudentList);
            //学生总人数

            Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
            Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
            model.addAttribute("clasStuTotalMan", clasStuTotalMan);
            model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
            long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


            List<Warning> warningList = wraningService.findAll();
            //查询幼儿园警告分类分级别
            Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            //查询
        try{

            // warningMap.putAll(partwarningMap);

            model.addAttribute("partwarningMap", partwarningMap);

            Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");

            Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");

            model.addAttribute("cso1", cs + co+"条");


            Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

            Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

            model.addAttribute("cso2", css + cod+"条");

            Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

            Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

            model.addAttribute("cso3", cssd + cods+"条");


            Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

            Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

            model.addAttribute("cso4", cssds + codsd+"条");
        }catch (Exception e)
        {
            e.printStackTrace();
        }



            System.out.println(warningMap);
            System.out.println(partwarningMap);

            model.addAttribute("warningMap", warningMap);


            Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


            model.addAttribute("ComMap", ComMap);

            Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
            Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

            model.addAttribute("ts", ts);
            model.addAttribute("tsp", tsp);
            Map<String, Object> mapMap = new HashMap<>();

            mapMap.put("publicCount", publicCount);
            mapMap.put("sum", sum);
            mapMap.put("mapSexTotal", mapSexTotal);
            mapMap.put("mapSexMan", mapSexMan);
            //教师合格的人数
            mapMap.put("mapQualified", mapQualified);
            //总人数
            mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
            //班级
            mapMap.put("clasStuTotal", clasStuTotal);
            //男生总人数
            //  mapMap.put("mapStudentListMan", mapStudentListMan);
            //学生总人数根据类型匹配
            mapMap.put("countTotalStudent", countTotalStudent);
            //学生总人数
            //    mapMap.put("mapStudentList", mapStudentList);
            mapMap.put("warningMap", warningMap);
            //从业者警告
            mapMap.put("partwarningMap", partwarningMap);
            mapMap.put("ComMap", ComMap);

            System.out.println(mapMap);


            JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

            System.out.println(jsonObject1.toJSONString());
            return "main/ban9";

        } else if (eduUser.getSign() == 0) {


            String sex = "男";
            String woman = "女";
            int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
            int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
            model.addAttribute("publicCount", publicCount);
            Integer nopublicCount = sum - publicCount;
            model.addAttribute("sum", nopublicCount);

            System.out.println(publicCount);
            //查找从业者类别
            List<Station> list = stationService.find();
            //根据地区和从业者类别查询从业者总人数
            Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
            //根据地区和从业者类别查询从业者男性总人数

            model.addAttribute("mapSexTotal", mapSexTotal);

            Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

            Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

            model.addAttribute("mapSexMan", mapSexMan);
            model.addAttribute("mapSexWoman", mapSexWoman);


            //教师类别设为一
            int typeid = 2;
            //教师合格的人数
            int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
            //教师总人数
            model.addAttribute("mapQualified", mapQualified);

            int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
            model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
            //班级类型
            List<ClassType> typeList = clasTypeService.finds();


            Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

            String s = null;

            model.addAttribute("clasStu", clasStu);
            Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
            model.addAttribute("clasStuTotal", clasStuTotal);
            //幼儿园多少所
            long kinderTotal = kindergartenService.countTotal(eduUser);

            model.addAttribute("kinderTotal", kinderTotal);
            //从业者总人数
            long partTotal = practitionerService.countTotal(eduUser);

            model.addAttribute("partTotal", partTotal);
            //幼儿总人数
            long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

            model.addAttribute("studentTotal", studentTotal);

            long comeStudentToal = studentService.findByDate(eduUser);

            model.addAttribute("comeStudentToal", comeStudentToal);
            long leaveStudenttotal = studentTotal - comeStudentToal;
            model.addAttribute("leaveStudenttotal", leaveStudenttotal);

            //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
            // model.addAttribute("mapStudentList",mapStudentList);
            //学生总人数

            Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
            Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
            model.addAttribute("clasStuTotalMan", clasStuTotalMan);
            model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
            long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


            List<Warning> warningList = wraningService.findAll();
            //查询幼儿园警告分类分级别
            Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            //查询


            // warningMap.putAll(partwarningMap);

            model.addAttribute("partwarningMap", partwarningMap);

            Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");

            Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");

            model.addAttribute("cso1", cs + co+"条");


            Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

            Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

            model.addAttribute("cso2", css + cod+"条");

            Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

            Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

            model.addAttribute("cso3", cssd + cods+"条");


            Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

            Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

            model.addAttribute("cso4", cssds + codsd+"条");


            System.out.println(warningMap);
            System.out.println(partwarningMap);

            model.addAttribute("warningMap", warningMap);


            Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


            model.addAttribute("ComMap", ComMap);

            Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
            Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

            model.addAttribute("ts", ts);
            model.addAttribute("tsp", tsp);
            Map<String, Object> mapMap = new HashMap<>();

            mapMap.put("publicCount", publicCount);
            mapMap.put("sum", sum);
            mapMap.put("mapSexTotal", mapSexTotal);
            mapMap.put("mapSexMan", mapSexMan);
            //教师合格的人数
            mapMap.put("mapQualified", mapQualified);
            //总人数
            mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
            //班级
            mapMap.put("clasStuTotal", clasStuTotal);
            //男生总人数
            //  mapMap.put("mapStudentListMan", mapStudentListMan);
            //学生总人数根据类型匹配
            mapMap.put("countTotalStudent", countTotalStudent);
            //学生总人数
            //    mapMap.put("mapStudentList", mapStudentList);
            mapMap.put("warningMap", warningMap);
            //从业者警告
            mapMap.put("partwarningMap", partwarningMap);
            mapMap.put("ComMap", ComMap);

            System.out.println(mapMap);

            List<Area> areaList = areaService.dinstinctName(eduUser.getAreaId());
            model.addAttribute("areaList", areaList);
            List<NoticeType> noticeTypeList = noticeService.distinctName();
            model.addAttribute("typeList", noticeTypeList);


            JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

            System.out.println(jsonObject1.toJSONString());
            return "main/ban9";
        }
        return null;
    }

    @RequestMapping(value = "/addNotice", method = RequestMethod.POST)
    @ApiOperation("实现添加公告")
    @ResponseBody
    public String addNotice(Notice notice, @RequestParam(value = "file1", required = false)MultipartFile file, HttpServletRequest req) throws IOException {
        //if true 上传附件
        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        System.out.println(eduUser);

        System.out.println(file);


        if (file != null) {

            notice.setCreateDate(new Date());
            String filename = pathHead + fastefsClient.uploFile(file);


            notice.setFile(filename);


            noticeService.insertSelective(notice);
            return "success";

        } else {
            notice.setCreateDate(new Date());
            noticeService.insertSelective(notice);
            return "success";
        }


    }


    @RequestMapping(value = "/saveNotice", method = RequestMethod.POST)
    @ApiOperation("保存添加公告")
    @ResponseBody
    public String saveNotice(Notice notice, @RequestParam(value = "file1", required = false) MultipartFile file, HttpServletRequest req) throws IOException {
        //if true 上传附件
        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        System.out.println(eduUser);

        System.out.println(file);

        if (file != null) {

            String filename = pathHead + fastefsClient.uploFile(file);
            notice.setCreateDate(new Date());

            notice.setFile(filename);

            notice.setNname("1");

            noticeService.insertSelective(notice);
            return "success";
        } else {
            notice.setNname("1");
            notice.setCreateDate(new Date());
            noticeService.insertSelective(notice);
            return "success";
        }


    }


    @RequestMapping(value = "/examineNotice", method = RequestMethod.POST)
    @ApiOperation("提交审核公告")
    @ResponseBody
    public String examineNotice(Notice notice, @RequestParam(value = "file1", required = false) MultipartFile file1, HttpServletRequest req) throws IOException {
        //if true 上传附件
        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        System.out.println(eduUser);
        System.out.println(file1);
        if (file1 != null) {
            String filename = pathHead + fastefsClient.uploFile(file1);


            notice.setFile(filename);

            notice.setCreateDate(new Date());
            notice.setSign(0);
            noticeService.insertSelective(notice);
            return "sucess";
        } else {

            notice.setCreateDate(new Date());
            notice.setSign(0);
            noticeService.insertSelective(notice);
            return "success";
        }


    }

    @RequestMapping(value = "/toLogin")
    @ApiOperation(value = "用户的登陆")
    public String toLogin() {
        return "main/login";
    }

    @RequestMapping(value = "/toFind")
    @ApiOperation(value = "用户的查询")
    public String toFind(Model model, HttpServletRequest req) throws ParseException {


        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        System.out.println(eduUser);
        PageInfo<Student> studentList = studentService.findByLikeName("幼", "刘", "1", eduUser, 1);

        //System.out.println(kinderName);
        PageInfo<Practitioner> practitionerList = practitionerService.findByLikeName("幼", "刘", "1", eduUser, 1);

        model.addAttribute("practitionerList", practitionerList);
        model.addAttribute("studentList", studentList);

        if (eduUser.getSign() == 1) {
            String sex = "男";
            String woman = "女";
            int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
            int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
            model.addAttribute("publicCount", publicCount);
            Integer nopublicCount = sum - publicCount;
            model.addAttribute("sum", nopublicCount);

            System.out.println(publicCount);
            //查找从业者类别
            List<Station> list = stationService.find();
            //根据地区和从业者类别查询从业者总人数
            Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
            //根据地区和从业者类别查询从业者男性总人数

            model.addAttribute("mapSexTotal", mapSexTotal);

            Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

            Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

            model.addAttribute("mapSexMan", mapSexMan);
            model.addAttribute("mapSexWoman", mapSexWoman);


            //教师类别设为一
            int typeid = 2;
            //教师合格的人数
            int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
            //教师总人数
            model.addAttribute("mapQualified", mapQualified);

            int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
            model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
            //班级类型
            List<ClassType> typeList = clasTypeService.finds();


            Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

            String s = null;

            model.addAttribute("clasStu", clasStu);
            Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
            model.addAttribute("clasStuTotal", clasStuTotal);
            //幼儿园多少所
            long kinderTotal = kindergartenService.countTotal(eduUser);

            model.addAttribute("kinderTotal", kinderTotal);
            //从业者总人数
            long partTotal = practitionerService.countTotal(eduUser);

            model.addAttribute("partTotal", partTotal);
            //幼儿总人数
            long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

            model.addAttribute("studentTotal", studentTotal);

            long comeStudentToal = studentService.findByDate(eduUser);

            model.addAttribute("comeStudentToal", comeStudentToal);
            long leaveStudenttotal = studentTotal - comeStudentToal;
            model.addAttribute("leaveStudenttotal", leaveStudenttotal);

            //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
            // model.addAttribute("mapStudentList",mapStudentList);
            //学生总人数

            Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
            Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
            model.addAttribute("clasStuTotalMan", clasStuTotalMan);
            model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
            long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


            List<Warning> warningList = wraningService.findAll();
            //查询幼儿园警告分类分级别
            Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            //查询


            // warningMap.putAll(partwarningMap);

            model.addAttribute("partwarningMap", partwarningMap);

          try{
              Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");
              Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");

              model.addAttribute("cso1", cs + co+"条");


              Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

              Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

              model.addAttribute("cso2", css + cod+"条");

              Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

              Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

              model.addAttribute("cso3", cssd + cods+"条");


              Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

              Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

              model.addAttribute("cso4", cssds + codsd+"条");
          }catch (Exception e)
          {
              e.printStackTrace();
          }



            System.out.println(warningMap);
            System.out.println(partwarningMap);

            model.addAttribute("warningMap", warningMap);


            Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


            model.addAttribute("ComMap", ComMap);

            Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
            Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

            model.addAttribute("ts", ts);
            model.addAttribute("tsp", tsp);
            Map<String, Object> mapMap = new HashMap<>();

            mapMap.put("publicCount", publicCount);
            mapMap.put("sum", sum);
            mapMap.put("mapSexTotal", mapSexTotal);
            mapMap.put("mapSexMan", mapSexMan);
            //教师合格的人数
            mapMap.put("mapQualified", mapQualified);
            //总人数
            mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
            //班级
            mapMap.put("clasStuTotal", clasStuTotal);
            //男生总人数
            //  mapMap.put("mapStudentListMan", mapStudentListMan);
            //学生总人数根据类型匹配
            mapMap.put("countTotalStudent", countTotalStudent);
            //学生总人数
            //    mapMap.put("mapStudentList", mapStudentList);
            mapMap.put("warningMap", warningMap);
            //从业者警告
            mapMap.put("partwarningMap", partwarningMap);
            mapMap.put("ComMap", ComMap);

            System.out.println(mapMap);


            JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

            System.out.println(jsonObject1.toJSONString());
            return "main/ban10";

        } else if (eduUser.getSign() == 0) {


            String sex = "男";
            String woman = "女";
            int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
            int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
            model.addAttribute("publicCount", publicCount);
            Integer nopublicCount = sum - publicCount;
            model.addAttribute("sum", nopublicCount);

            System.out.println(publicCount);
            //查找从业者类别
            List<Station> list = stationService.find();
            //根据地区和从业者类别查询从业者总人数
            Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
            //根据地区和从业者类别查询从业者男性总人数

            model.addAttribute("mapSexTotal", mapSexTotal);

            Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

            Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

            model.addAttribute("mapSexMan", mapSexMan);
            model.addAttribute("mapSexWoman", mapSexWoman);


            //教师类别设为一
            int typeid = 2;
            //教师合格的人数
            int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
            //教师总人数
            model.addAttribute("mapQualified", mapQualified);

            int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
            model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
            //班级类型
            List<ClassType> typeList = clasTypeService.finds();


            Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

            String s = null;

            model.addAttribute("clasStu", clasStu);
            Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
            model.addAttribute("clasStuTotal", clasStuTotal);
            //幼儿园多少所
            long kinderTotal = kindergartenService.countTotal(eduUser);

            model.addAttribute("kinderTotal", kinderTotal);
            //从业者总人数
            long partTotal = practitionerService.countTotal(eduUser);

            model.addAttribute("partTotal", partTotal);
            //幼儿总人数
            long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

            model.addAttribute("studentTotal", studentTotal);

            long comeStudentToal = studentService.findByDate(eduUser);

            model.addAttribute("comeStudentToal", comeStudentToal);
            long leaveStudenttotal = studentTotal - comeStudentToal;
            model.addAttribute("leaveStudenttotal", leaveStudenttotal);

            //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
            // model.addAttribute("mapStudentList",mapStudentList);
            //学生总人数

            Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
            Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
            model.addAttribute("clasStuTotalMan", clasStuTotalMan);
            model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
            long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


            List<Warning> warningList = wraningService.findAll();
            //查询幼儿园警告分类分级别
            Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            //查询


            // warningMap.putAll(partwarningMap);

            model.addAttribute("partwarningMap", partwarningMap);

            Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");

            Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");

            model.addAttribute("cso1", cs + co+"条");


            Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

            Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

            model.addAttribute("cso2", css + cod+"条");

            Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

            Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

            model.addAttribute("cso3", cssd + cods+"条");


            Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

            Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

            model.addAttribute("cso4", cssds + codsd+"条");


            System.out.println(warningMap);
            System.out.println(partwarningMap);

            model.addAttribute("warningMap", warningMap);


            Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


            model.addAttribute("ComMap", ComMap);

            Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
            Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

            model.addAttribute("ts", ts);
            model.addAttribute("tsp", tsp);
            Map<String, Object> mapMap = new HashMap<>();

            mapMap.put("publicCount", publicCount);
            mapMap.put("sum", sum);
            mapMap.put("mapSexTotal", mapSexTotal);
            mapMap.put("mapSexMan", mapSexMan);
            //教师合格的人数
            mapMap.put("mapQualified", mapQualified);
            //总人数
            mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
            //班级
            mapMap.put("clasStuTotal", clasStuTotal);
            //男生总人数
            //  mapMap.put("mapStudentListMan", mapStudentListMan);
            //学生总人数根据类型匹配
            mapMap.put("countTotalStudent", countTotalStudent);
            //学生总人数
            //    mapMap.put("mapStudentList", mapStudentList);
            mapMap.put("warningMap", warningMap);
            //从业者警告
            mapMap.put("partwarningMap", partwarningMap);
            mapMap.put("ComMap", ComMap);

            System.out.println(mapMap);


            JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

            System.out.println(jsonObject1.toJSONString());
            return "main/ban10";
        }

        return "main/ban10";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "用户的登陆", httpMethod = "POST")
//    @ResponseBody
    public String login(EduUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws IOException, ParseException {

        EduUser eduUser = eduUserService.login(user);

      if (eduUser==null)
      {
          String s="用户名或密码错误";
          model.addAttribute("msg",s);


          request.setAttribute("errorInfo", "用户名或密码错误！");
          return "main/login";

          //return "/main/500";
      }
        System.out.println(user);

        if (user != null) {
            request.getSession().setAttribute("eduUser", eduUser);

            Education education = educationService.findByAreaId(eduUser.getAreaId() + "");
            session.setAttribute("education", education);


            session.setAttribute("eduUser", eduUser);
            if (eduUser.getSign() == 1) {
                String sex = "男";
                String woman = "女";
                int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
                int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
                model.addAttribute("publicCount", publicCount);
                Integer nopublicCount = sum - publicCount;
                model.addAttribute("sum", nopublicCount);

                System.out.println(publicCount);
                //查找从业者类别
                List<Station> list = stationService.find();
                //根据地区和从业者类别查询从业者总人数
                Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
                //根据地区和从业者类别查询从业者男性总人数

                model.addAttribute("mapSexTotal", mapSexTotal);

                Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

                Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

                model.addAttribute("mapSexMan", mapSexMan);
                model.addAttribute("mapSexWoman", mapSexWoman);


                //教师类别设为一
                int typeid = 2;
                //教师合格的人数
                int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
                //教师总人数
                model.addAttribute("mapQualified", mapQualified);

                int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
                model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
                //班级类型
                List<ClassType> typeList = clasTypeService.finds();


                Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

                String s = null;

                model.addAttribute("clasStu", clasStu);
                Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
                model.addAttribute("clasStuTotal", clasStuTotal);
                //幼儿园多少所
                long kinderTotal = kindergartenService.countTotal(eduUser);

                model.addAttribute("kinderTotal", kinderTotal);
                //从业者总人数
                long partTotal = practitionerService.countTotal(eduUser);

                model.addAttribute("partTotal", partTotal);
                //幼儿总人数
                long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

                model.addAttribute("studentTotal", studentTotal);

                long comeStudentToal = studentService.findByDate(eduUser);

                model.addAttribute("comeStudentToal", comeStudentToal);
                long leaveStudenttotal = studentTotal - comeStudentToal;
                model.addAttribute("leaveStudenttotal", leaveStudenttotal);

                //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
                // model.addAttribute("mapStudentList",mapStudentList);
                //学生总人数

                Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
                Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
                model.addAttribute("clasStuTotalMan", clasStuTotalMan);
                model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
                long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


                List<Warning> warningList = wraningService.findAll();
                //查询幼儿园警告分类分级别
                Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
                Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
                //查询


                // warningMap.putAll(partwarningMap);

                model.addAttribute("partwarningMap", partwarningMap);


try {
    Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");
    Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");
    model.addAttribute("cso1", cs + co+"条");


    Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

    Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

    model.addAttribute("cso2", css + cod+"条");

    Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

    Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

    model.addAttribute("cso3", cssd + cods+"条");


    Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

    Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

    model.addAttribute("cso4", cssds + codsd+"条");

}catch (Exception e)
{
    e.printStackTrace();
}








                System.out.println(warningMap);
                System.out.println(partwarningMap);

                model.addAttribute("warningMap", warningMap);


                Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


                model.addAttribute("ComMap", ComMap);

                Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
                Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

                model.addAttribute("ts", ts);
                model.addAttribute("tsp", tsp);
                Map<String, Object> mapMap = new HashMap<>();

                mapMap.put("publicCount", publicCount);
                mapMap.put("sum", sum);
                mapMap.put("mapSexTotal", mapSexTotal);
                mapMap.put("mapSexMan", mapSexMan);
                //教师合格的人数
                mapMap.put("mapQualified", mapQualified);
                //总人数
                mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
                //班级
                mapMap.put("clasStuTotal", clasStuTotal);
                //男生总人数
                //  mapMap.put("mapStudentListMan", mapStudentListMan);
                //学生总人数根据类型匹配
                mapMap.put("countTotalStudent", countTotalStudent);
                //学生总人数
                //    mapMap.put("mapStudentList", mapStudentList);
                mapMap.put("warningMap", warningMap);
                //从业者警告
                mapMap.put("partwarningMap", partwarningMap);
                mapMap.put("ComMap", ComMap);

                System.out.println(mapMap);


                JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

                System.out.println(jsonObject1.toJSONString());
                return "/main/index1";

            } else if (eduUser.getSign() == 0) {


                String sex = "男";
                String woman = "女";
                int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
                int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
                model.addAttribute("publicCount", publicCount);
                Integer nopublicCount = sum - publicCount;
                model.addAttribute("sum", nopublicCount);

                System.out.println(publicCount);
                //查找从业者类别
                List<Station> list = stationService.find();
                //根据地区和从业者类别查询从业者总人数
                Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
                //根据地区和从业者类别查询从业者男性总人数

                model.addAttribute("mapSexTotal", mapSexTotal);

                Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

                Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

                model.addAttribute("mapSexMan", mapSexMan);
                model.addAttribute("mapSexWoman", mapSexWoman);


                //教师类别设为一
                int typeid = 2;
                //教师合格的人数
                int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
                //教师总人数
                model.addAttribute("mapQualified", mapQualified);

                int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
                model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
                //班级类型
                List<ClassType> typeList = clasTypeService.finds();


                Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

                String s = null;

                model.addAttribute("clasStu", clasStu);
                Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
                model.addAttribute("clasStuTotal", clasStuTotal);
                //幼儿园多少所
                long kinderTotal = kindergartenService.countTotal(eduUser);

                model.addAttribute("kinderTotal", kinderTotal);
                //从业者总人数
                long partTotal = practitionerService.countTotal(eduUser);

                model.addAttribute("partTotal", partTotal);
                //幼儿总人数
                long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

                model.addAttribute("studentTotal", studentTotal);

                long comeStudentToal = studentService.findByDate(eduUser);

                model.addAttribute("comeStudentToal", comeStudentToal);
                long leaveStudenttotal = studentTotal - comeStudentToal;
                model.addAttribute("leaveStudenttotal", leaveStudenttotal);

                //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
                // model.addAttribute("mapStudentList",mapStudentList);
                //学生总人数

                Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
                Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
                model.addAttribute("clasStuTotalMan", clasStuTotalMan);
                model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
                long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


                List<Warning> warningList = wraningService.findAll();
                //查询幼儿园警告分类分级别
                Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
                Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
                //查询


                // warningMap.putAll(partwarningMap);

                model.addAttribute("partwarningMap", partwarningMap);

               try{

                   Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");

                   Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");

                   model.addAttribute("cso1", cs + co+"条");


                   Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

                   Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

                   model.addAttribute("cso2", css + cod+"条");

                   Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

                   Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

                   model.addAttribute("cso3", cssd + cods+"条");


                   Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

                   Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

                   model.addAttribute("cso4", cssds + codsd+"条");


               }catch (Exception e)
               {
                   e.printStackTrace();
               }


                System.out.println(warningMap);
                System.out.println(partwarningMap);

                model.addAttribute("warningMap", warningMap);


                Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


                model.addAttribute("ComMap", ComMap);

                Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
                Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

                model.addAttribute("ts", ts);
                model.addAttribute("tsp", tsp);
                Map<String, Object> mapMap = new HashMap<>();

                mapMap.put("publicCount", publicCount);
                mapMap.put("sum", sum);
                mapMap.put("mapSexTotal", mapSexTotal);
                mapMap.put("mapSexMan", mapSexMan);
                //教师合格的人数
                mapMap.put("mapQualified", mapQualified);
                //总人数
                mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
                //班级
                mapMap.put("clasStuTotal", clasStuTotal);
                //男生总人数
                //  mapMap.put("mapStudentListMan", mapStudentListMan);
                //学生总人数根据类型匹配
                mapMap.put("countTotalStudent", countTotalStudent);
                //学生总人数
                //    mapMap.put("mapStudentList", mapStudentList);
                mapMap.put("warningMap", warningMap);
                //从业者警告
                mapMap.put("partwarningMap", partwarningMap);
                mapMap.put("ComMap", ComMap);

                System.out.println(mapMap);


                JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

                System.out.println(jsonObject1.toJSONString());
                return "/map/" + eduUser.getAreaId();
            }
        } else {


        }
        return null;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "main/login";
    }

    @RequestMapping(value = "/selectByNameId")
    @ApiOperation(value = "模糊查询幼儿园，从业者，学生", httpMethod = "GET")
    public String selectByNameId(Model model, @RequestParam(value = "kinderName", required = false) String kinderName,

                                 @RequestParam(value = "partname", required = false) String partname,
                                 @RequestParam(value = "phone", required = false) String phone,
                                 @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                 HttpServletRequest req) throws ParseException {
        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");

        if(eduUser==null)
        {


            model.addAttribute("msg","登陆超时,重新登陆");
            return "/main/500";
        }

        System.out.println(eduUser);

        System.out.println(kinderName);
        PageInfo<Practitioner> practitionerList = practitionerService.findByLikeName(kinderName, partname, phone, eduUser, pn);

        System.out.println(practitionerList.getSize());
        PageInfo<Student> studentList = studentService.findByLikeName(kinderName, partname, phone, eduUser, pn);
        System.out.println(studentList.getSize());
        System.out.println(studentList);
        System.out.println(practitionerList);

        model.addAttribute("practitionerList", practitionerList);
        model.addAttribute("studentList", studentList);

        if (eduUser.getSign() == 1) {
            String sex = "男";
            String woman = "女";
            int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
            int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
            model.addAttribute("publicCount", publicCount);
            Integer nopublicCount = sum - publicCount;
            model.addAttribute("sum", nopublicCount);

            System.out.println(publicCount);
            //查找从业者类别
            List<Station> list = stationService.find();
            //根据地区和从业者类别查询从业者总人数
            Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
            //根据地区和从业者类别查询从业者男性总人数

            model.addAttribute("mapSexTotal", mapSexTotal);

            Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

            Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

            model.addAttribute("mapSexMan", mapSexMan);
            model.addAttribute("mapSexWoman", mapSexWoman);


            //教师类别设为一
            int typeid = 2;
            //教师合格的人数
            int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
            //教师总人数
            model.addAttribute("mapQualified", mapQualified);

            int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
            model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
            //班级类型
            List<ClassType> typeList = clasTypeService.finds();


            Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

            String s = null;

            model.addAttribute("clasStu", clasStu);
            Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
            model.addAttribute("clasStuTotal", clasStuTotal);
            //幼儿园多少所
            long kinderTotal = kindergartenService.countTotal(eduUser);

            model.addAttribute("kinderTotal", kinderTotal);
            //从业者总人数
            long partTotal = practitionerService.countTotal(eduUser);

            model.addAttribute("partTotal", partTotal);
            //幼儿总人数
            long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

            model.addAttribute("studentTotal", studentTotal);

            long comeStudentToal = studentService.findByDate(eduUser);

            model.addAttribute("comeStudentToal", comeStudentToal);
            long leaveStudenttotal = studentTotal - comeStudentToal;
            model.addAttribute("leaveStudenttotal", leaveStudenttotal);

            //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
            // model.addAttribute("mapStudentList",mapStudentList);
            //学生总人数

            Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
            Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
            model.addAttribute("clasStuTotalMan", clasStuTotalMan);
            model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
            long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


            List<Warning> warningList = wraningService.findAll();
            //查询幼儿园警告分类分级别
            Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            //查询


            // warningMap.putAll(partwarningMap);
            try{

                model.addAttribute("partwarningMap", partwarningMap);

                Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");

                Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");

                model.addAttribute("cso1", cs + co+"条");


                Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

                Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

                model.addAttribute("cso2", css + cod+"条");

                Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

                Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

                model.addAttribute("cso3", cssd + cods+"条");


                Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

                Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

                model.addAttribute("cso4", cssds + codsd+"条");
            }catch (Exception e)
            {
                e.printStackTrace();
            }


            System.out.println(warningMap);
            System.out.println(partwarningMap);

            model.addAttribute("warningMap", warningMap);


            Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


            model.addAttribute("ComMap", ComMap);

            Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
            Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

            model.addAttribute("ts", ts);
            model.addAttribute("tsp", tsp);
            Map<String, Object> mapMap = new HashMap<>();

            mapMap.put("publicCount", publicCount);
            mapMap.put("sum", sum);
            mapMap.put("mapSexTotal", mapSexTotal);
            mapMap.put("mapSexMan", mapSexMan);
            //教师合格的人数
            mapMap.put("mapQualified", mapQualified);
            //总人数
            mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
            //班级
            mapMap.put("clasStuTotal", clasStuTotal);
            //男生总人数
            //  mapMap.put("mapStudentListMan", mapStudentListMan);
            //学生总人数根据类型匹配
            mapMap.put("countTotalStudent", countTotalStudent);
            //学生总人数
            //    mapMap.put("mapStudentList", mapStudentList);
            mapMap.put("warningMap", warningMap);
            //从业者警告
            mapMap.put("partwarningMap", partwarningMap);
            mapMap.put("ComMap", ComMap);

            System.out.println(mapMap);


            JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

            System.out.println(jsonObject1.toJSONString());
            return "main/ban10";

        } else if (eduUser.getSign() == 0) {


            String sex = "男";
            String woman = "女";
            int publicCount = kindergartenService.findByAreaIdToType(eduUser.getAreaId(), 1, eduUser.getSign());
            int sum = kindergartenService.sumKinder(eduUser.getAreaId(), eduUser.getSign());
            model.addAttribute("publicCount", publicCount);
            Integer nopublicCount = sum - publicCount;
            model.addAttribute("sum", nopublicCount);

            System.out.println(publicCount);
            //查找从业者类别
            List<Station> list = stationService.find();
            //根据地区和从业者类别查询从业者总人数
            Map<String, String> mapSexTotal = practitionerService.findByAreaIDToSexTotal(eduUser.getAreaId(), list, eduUser.getSign());
            //根据地区和从业者类别查询从业者男性总人数

            model.addAttribute("mapSexTotal", mapSexTotal);

            Map<String, String> mapSexMan = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, sex, eduUser.getSign());

            Map<String, String> mapSexWoman = practitionerService.findByAreaIDToSex(eduUser.getAreaId(), list, woman, eduUser.getSign());

            model.addAttribute("mapSexMan", mapSexMan);
            model.addAttribute("mapSexWoman", mapSexWoman);


            //教师类别设为一
            int typeid = 2;
            //教师合格的人数
            int mapQualified = practitionerService.findCertificateYes(eduUser.getAreaId(), typeid, eduUser.getSign());
            //教师总人数
            model.addAttribute("mapQualified", mapQualified);

            int mapQualifiedTotal = practitionerService.findCertificateTotal(eduUser.getAreaId(), typeid, eduUser.getSign());
            model.addAttribute("mapQualifiedTotal", mapQualifiedTotal);
            //班级类型
            List<ClassType> typeList = clasTypeService.finds();


            Map<String, String> clasStu = studentService.findByCtype(typeList, eduUser, sex);

            String s = null;

            model.addAttribute("clasStu", clasStu);
            Map<String, String> clasStuTotal = studentService.findByCtype(typeList, eduUser, s);
            model.addAttribute("clasStuTotal", clasStuTotal);
            //幼儿园多少所
            long kinderTotal = kindergartenService.countTotal(eduUser);

            model.addAttribute("kinderTotal", kinderTotal);
            //从业者总人数
            long partTotal = practitionerService.countTotal(eduUser);

            model.addAttribute("partTotal", partTotal);
            //幼儿总人数
            long studentTotal = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());

            model.addAttribute("studentTotal", studentTotal);

            long comeStudentToal = studentService.findByDate(eduUser);

            model.addAttribute("comeStudentToal", comeStudentToal);
            long leaveStudenttotal = studentTotal - comeStudentToal;
            model.addAttribute("leaveStudenttotal", leaveStudenttotal);

            //Map<String, String> mapStudentList = studentService.findClasTypeSex(clasList,eduUser.getAreaId(), sex,eduUser.getSign());
            // model.addAttribute("mapStudentList",mapStudentList);
            //学生总人数

            Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
            Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
            model.addAttribute("clasStuTotalMan", clasStuTotalMan);
            model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);
            long countTotalStudent = studentService.findAll(eduUser.getAreaId(), eduUser.getSign());


            List<Warning> warningList = wraningService.findAll();
            //查询幼儿园警告分类分级别
            Map<String, Object> warningMap = kindWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            Map<String, Object> partwarningMap = partWarnService.findWarnByArea(eduUser.getAreaId(), warningList, eduUser.getSign());
            //查询


            // warningMap.putAll(partwarningMap);

            model.addAttribute("partwarningMap", partwarningMap);

         try {
             Integer co = Integer.parseInt(partwarningMap.get("wraningsize1") + "");


             Integer cs = Integer.parseInt(warningMap.get("wraningsize1") + "");

             model.addAttribute("cso1", cs + co + "条");


             Integer cod = Integer.parseInt(partwarningMap.get("wraningsize2") + "");

             Integer css = Integer.parseInt(warningMap.get("wraningsize2") + "");

             model.addAttribute("cso2", css + cod + "条");

             Integer cods = Integer.parseInt(partwarningMap.get("wraningsize3") + "");

             Integer cssd = Integer.parseInt(warningMap.get("wraningsize3") + "");

             model.addAttribute("cso3", cssd + cods + "条");


             Integer codsd = Integer.parseInt(partwarningMap.get("wraningsize4") + "");

             Integer cssds = Integer.parseInt(warningMap.get("wraningsize4") + "");

             model.addAttribute("cso4", cssds + codsd + "条");
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }

            System.out.println(warningMap);
            System.out.println(partwarningMap);

            model.addAttribute("warningMap", warningMap);


            Map<String, Object> ComMap = complaintService.findBY(eduUser.getAreaId(), eduUser.getSign());


            model.addAttribute("ComMap", ComMap);

            Integer ts = Integer.parseInt(ComMap.get("comlistsizesS") + "");
            Integer tsp = Integer.parseInt(ComMap.get("comlistsizesP") + "");

            model.addAttribute("ts", ts);
            model.addAttribute("tsp", tsp);
            Map<String, Object> mapMap = new HashMap<>();

            mapMap.put("publicCount", publicCount);
            mapMap.put("sum", sum);
            mapMap.put("mapSexTotal", mapSexTotal);
            mapMap.put("mapSexMan", mapSexMan);
            //教师合格的人数
            mapMap.put("mapQualified", mapQualified);
            //总人数
            mapMap.put("mapQualifiedTotal", mapQualifiedTotal);
            //班级
            mapMap.put("clasStuTotal", clasStuTotal);
            //男生总人数
            //  mapMap.put("mapStudentListMan", mapStudentListMan);
            //学生总人数根据类型匹配
            mapMap.put("countTotalStudent", countTotalStudent);
            //学生总人数
            //    mapMap.put("mapStudentList", mapStudentList);
            mapMap.put("warningMap", warningMap);
            //从业者警告
            mapMap.put("partwarningMap", partwarningMap);
            mapMap.put("ComMap", ComMap);

            System.out.println(mapMap);


            JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

            System.out.println(jsonObject1.toJSONString());
            return "main/ban10";
        }
        return null;

    }



}






