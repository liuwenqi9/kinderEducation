package com.muji.zh.eduuser.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.ClassType;
import com.muji.zh.admin.model.EduUser;
import com.muji.zh.admin.model.Station;
import com.muji.zh.admin.model.Warning;
import com.muji.zh.admin.service.*;
import com.muji.zh.config.service.FastefsClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/EduUser", description = "这是全部的/EduUser方法")
public class AreaController {






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

    @Reference
    private WraningService wraningService;

    @RequestMapping(value = "/toAreaId")
    @ApiOperation(value = "地图的跳转")
    public String toAreaId(Model model,  Integer areaid, HttpServletRequest req) throws ParseException {
        EduUser eduUser=new EduUser();
        //eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        String sex = "男";
        String woman = "女";
        eduUser.setSign(1);
        if (eduUser.getSign() == 1) {

            eduUser.setSign(0);
            eduUser.setAreaId(areaid);

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
            return "/map/"+eduUser.getAreaId();



        }
        return null;

    }

}