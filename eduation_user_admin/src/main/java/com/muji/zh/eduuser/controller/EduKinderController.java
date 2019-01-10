package com.muji.zh.eduuser.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.model.PartWinRecord;
import com.muji.zh.admin.service.*;
import com.muji.zh.config.service.FastefsClient;
import com.sun.imageio.plugins.common.I18N;
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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(value = "/EduKinderController", description = "这是全部的教育局查询幼儿园方法")
public class EduKinderController {


    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;

    @Autowired
    private FastefsClient fastefsClient;

    @Reference
    private ReplyService replyService;
    @Reference
    private EduUserService eduUserService;

    @Reference
    private  KinderLegalService kinderLegalService;
    @Reference
    private NoticeService noticeService;
    @Reference
    private AreaService areaService;

    @Reference
    private PractitionerService practitPionerService;

    @Reference
    private KindergartenService kindergartenService;
    @Reference
    private StationService stationService;

    @Reference
    private ParentService parentService;

    @Reference
    private ClasService clasService;

    @Reference
    private ClasTypeService clasTypeService;

    @Reference
    private StudentService studentService;

    @Reference
    private EducationService educationService;

    @Reference
    private KindWarnService kindWarnService;
    @Reference
    private ComplaintService complaintService;
    @Reference
    private PartWarnService partWarnService;

    @Reference
    private WraningService wraningService;

    @Reference
    private ParExperienceService parExperienceService;

    @Reference

    private PartWinRecordService partWinRecordService;

    @Reference
    private StuParentService stuParentService;


    @Reference
    private ParSlarListService slarListService;
    @Reference
    private StuExperienceService stuExperienceService;
    @Reference
    private StuWinRecordService stuWinRecordService;

    @Reference
    private PaymentListService paymentListService;


    @RequestMapping(value = "/findByKid", method = RequestMethod.GET)

    @ApiOperation(value = "幼儿园基础信息统计")
    public String findByKid(Model model, Integer kid,HttpServletRequest req) throws ParseException {
        String sex = "男";
        String s = null;

        String woman = "女";

        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        if(eduUser==null)
        {
            model.addAttribute("msg","登陆超时,重新登陆");
            return "/main/500";
        }


        System.out.println(kid);
        List<Station> stationList = stationService.find();
        //统计幼儿园从业者男女比例
        Map<String, Object> manMap = practitPionerService.findByKid(kid, sex, stationList);
        Map<String, Object> womanMap = practitPionerService.findByKid(kid, woman, stationList);
        //如果flag为空查询全部
        String flag1 = null;
        model.addAttribute("practitionerTypeMan", manMap);
        model.addAttribute("practitionerTypeWoMan", womanMap);
        //设置幼师类别为一
        String type = "2";



        //学生和班主任的比
        Map<String,Object> counts=practitPionerService.findPart(kid,stationList);

        model.addAttribute("counts",counts);

        //Map<String,Object> count=studentService.findByClasTypeStudent( clasTypeService.finds(),kid);

        List<ClassType> typeList = clasTypeService.finds();
        Map<String, String> clasStuTotalMan = studentService.findByCtype(typeList, eduUser, sex);
        Map<String, String> clasStuTotalWoMan = studentService.findByCtype(typeList, eduUser, woman);
        model.addAttribute("clasStuTotalMan", clasStuTotalMan);
        model.addAttribute("clasStuTotalWoMan", clasStuTotalWoMan);


        long contSafe = practitPionerService.findByQs(type, kid, type);
        long contSafes = practitPionerService.findByQs("3", kid, type);

        model.addAttribute("contSafe",contSafe);
        model.addAttribute("contSafes",contSafes);


        List<ClassType> classTypeList = clasTypeService.finds();
        //三个饼图的比学生和教师
        Map<String, Object> clasMap = studentService.findKidToType(kid, classTypeList);

        //幼儿园学生男生总人数
        Integer studentCountMan = studentService.findKidToSex(sex, kid);
        Integer studentCountWoMan = studentService.findKidToSex(woman, kid);
        model.addAttribute("studentCountMan", studentCountMan);
        //学生总人数
        Integer studnetTotal = studentService.findKidToSex(s, kid);
        model.addAttribute("studnetTotal", studnetTotal);
        model.addAttribute("studentCountWoMan", studentCountWoMan);
        Kindergarten kindergarten = kindergartenService.selectByPrimaryKey(kid);
        model.addAttribute("kindergarten", kindergarten);
        if (kindergarten.getBusinessNature().equals("公办")) {
           model.addAttribute("typename", "公办");

        } else {
            model.addAttribute("typename", "民办"); }


        Education education = educationService.selectByPrimaryKey(kindergarten.getEduId());
        model.addAttribute("educationName", education.getEname());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String d = simpleDateFormat.format(kindergarten.getCreateDate());
        model.addAttribute("date", d);

        Integer really1=practitPionerService.countByKid(kid);

        Integer really=studentService.findKidToSex(null,kid);

        Long really2=clasService.countToClas(kid);

        model.addAttribute("really1",really1);
        model.addAttribute("really2",really2);
        model.addAttribute("really",really);
        KinderLegal kinderLegal=kinderLegalService.findById(kindergarten.getLegalId());

        model.addAttribute("legalName",kinderLegal.getKlname());

        //查询警告级别
        List<Warning> warningList = wraningService.findAll();
        Map<String, Object> kindWarnList = kindWarnService.findByKid(kid, warningList);
        //查询投诉返回结果
        Map<String, Object> KindComplant = complaintService.findByKid(kid);

try{
    Integer co = Integer.parseInt(kindWarnList.get("wraningsize1") + "");

    //Integer cs= Integer.parseInt(warningMap.get("wraningsize1")+"") ;

    model.addAttribute("cso1", co + "条");


    Integer cod = Integer.parseInt(kindWarnList.get("wraningsize2") + "");


    model.addAttribute("cso2", cod + "条");

    Integer cods = Integer.parseInt(kindWarnList.get("wraningsize3") + "");


    model.addAttribute("cso3", cods + "条");


    Integer codsd = Integer.parseInt(kindWarnList.get("wraningsize4") + "");


    model.addAttribute("cso4", codsd + "条");


    Integer ts = Integer.parseInt(KindComplant.get("comlistsizesS") + "");
    Integer tsp = Integer.parseInt(KindComplant.get("comlistsizesP") + "");

    model.addAttribute("ts", ts);
    model.addAttribute("tsp", tsp);


}catch (Exception e)
{
    e.printStackTrace();
}


        Map<String, Object> mapMap = new HashMap<>();
        mapMap.put("practitionerTypeMan", manMap);
        mapMap.put("practitionerTypeWoMan", womanMap);
//        mapMap.put("mapTeacherTotal",mapTeacherTotal);
//        mapMap.put("mapTecherMan",mapTecherMan);
        mapMap.put("clasMap", clasMap);
        // mapMap.put("StudentCountMan",StudentCountMan);
        //mapMap.put("StudnetTotal",StudnetTotal);
        mapMap.put("kindWarnList", kindWarnList);
        mapMap.put("KindComplant", KindComplant);
        mapMap.put("kindergarten", kindergarten);
        mapMap.put("manMap",manMap);
        mapMap.put("womanMap",womanMap);


        model.addAttribute("warningMap", kindWarnList);
        model.addAttribute("ComMap", KindComplant);

        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));

        System.out.println(jsonObject1.toJSONString());
        return "/main/ban3";


    }

    @RequestMapping(value = "/findByPid", method = RequestMethod.GET)

    @ApiOperation(value = "从业者基础信息统计基础信息统计")
    public String findPidPid(Model model, Integer pid,HttpServletRequest req) throws ParseException {

        Practitioner practitPioner = practitPionerService.selectByPrimaryKey(pid);

        model.addAttribute("practitPioner", practitPioner);




        PaymentList list=paymentListService.selectBySidAndSname(practitPioner.getPname(),practitPioner.getpId());



       try{
           Long rellaywages=slarListService.findRellay(list.getsId());

           model.addAttribute("reallywages",rellaywages);
       }catch (Exception e)
       {

       }





        List<PartWarn> list1=partWarnService.findBySid(practitPioner.getId());

        model.addAttribute("partList",list1);

        System.out.println(list1.size());

        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        if(eduUser==null)
        {
            model.addAttribute("msg","登陆超时,重新登陆");
            return "/main/500";
        }



        Station station = stationService.selectByPrimaryKey(practitPioner.getpId());
        Kindergarten kindergarten=kindergartenService.selectByPrimaryKey(practitPioner.getKinderId());

        model.addAttribute("kindergarten",kindergarten);

        KinderLegal kinderLegal=kinderLegalService.findById(practitPioner.getKinderId());
        model.addAttribute("kinderLegal",kinderLegal);
        //职称
        String name = station.getSname();
        model.addAttribute("station",station);
        //从业者的经历
        List<ParExperience> parExperienceList = parExperienceService.selectByExample(practitPioner.getId());


        model.addAttribute("parExperienceList", parExperienceList);
        //查询被投诉的记录
        List<Complaint> complaintList = complaintService.findByPidBeOid(practitPioner.getId());
        //获奖记录
        model.addAttribute("complaintList", complaintList);
        List<PartWinRecord> partWinRecordList = partWinRecordService.FindByPid(practitPioner.getId());
        model.addAttribute("partWinRecordList", partWinRecordList);
        List<Complaint> complaintsIng = complaintService.findByFromWhoId(practitPioner.getId());
        model.addAttribute("complaintsIng", complaintsIng);











        Map<String, Object> mapMap = new HashMap<>();

        mapMap.put("practitPioner", practitPioner);
        mapMap.put("parExperienceList", parExperienceList);
        mapMap.put("complaintList", complaintList);
        mapMap.put("partWinRecordList", partWinRecordList);
        mapMap.put("list2",list1);
        //教师合格的人数
        mapMap.put("complaintsIng", complaintsIng);


        System.out.println(mapMap);


        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(mapMap));
        System.out.println(jsonObject1.toJSONString());
        return "main/ban5";

    }


    @RequestMapping(value = "/findBySid", method = RequestMethod.GET)

    @ApiOperation(value = "学生基础信息统计基础信息统计")
    public String findBySid(Integer sid, Model model) {
        Student student = studentService.selectByPrimaryKey(sid);
        model.addAttribute("student",student);
        System.out.println(sid);
        List<StuExperience> stuExperienceList = stuExperienceService.findBySid(student.getId());
        model.addAttribute("stuExperienceList",stuExperienceList);

        Education education=educationService.selectByPrimaryKey(student.getEduId());

        model.addAttribute("education",education);
        List<StuWinRecord> stuWinRecordList = stuWinRecordService.findBySid(student.getId());
        model.addAttribute("stuWinRecordList",stuWinRecordList);
        StuParent stuParent = stuParentService.findByStuId(student.getId());
        model.addAttribute("stuParent",stuParent);

        Parent parent=parentService.selectByPrimaryKey(stuParent.getPid());
        model.addAttribute("parent",parent);

        Kindergarten kindergarten=kindergartenService.selectByPrimaryKey(student.getKid());

        model.addAttribute("kindergarten",kindergarten);

        KinderLegal kinderLegal=kinderLegalService.findById(kindergarten.getLegalId());

        model.addAttribute("kinderLegal",kinderLegal);

        Clas clas=clasService.selectByPrimaryKey(student.getClasId());

        model.addAttribute("clas",clas);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        String s=simpleDateFormat.format(student.getCreateDate());
        student.setFlag4(s);



       List<Practitioner> list=practitPionerService.findByKidToPract(kindergarten.getkId());
       model.addAttribute("count",list.size()+"人");

        Practitioner practitioner=practitPionerService.selectByPrimaryKey(clas.getpId());

        model.addAttribute("pr",practitioner);


        /*
        学生基本信息统计预留
         */

        String flag1 = "1";//0代表投诉的幼儿园。1代表家长
        String flag2 = "0";
        //查询投诉幼儿园
        List<Complaint> complaintList = complaintService.findByFromWhoIdFlags(stuParent.getPid(), flag1);
        //查询投诉的教师

        model.addAttribute("complaintList",complaintList);
        List<Complaint> complaintListKinder = complaintService.findByFromWhoIdFlags(stuParent.getPid(), flag2);
        model.addAttribute("complaintListKinder",complaintListKinder);
        Map<String, Object> map = new HashMap<>();

        map.put("stuExperienceList", stuExperienceList);
        map.put("stuWinRecordList", stuWinRecordList);
        map.put("complaintList", complaintList);
        map.put("complaintListKinder", complaintListKinder);
        map.put("stu",student);
        map.put("stuParent",stuParent);


        JSONObject jsonObject1 = JSONObject.parseObject(JSON.toJSONString(map));
        System.out.println(jsonObject1.toJSONString());
        //return jsonObject1.toJSONString();
        return "/main/ban8";

    }

    @RequestMapping(value = "/ReplyByCid", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "投诉的回复")
    public String findPidKid(Model model, String cid1, Reply reply, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req) throws IOException, ParseException {


        System.out.println(cid1);
        Complaint complaint = complaintService.selectByPrimaryKey(Integer.parseInt(cid1));
        complaint.setSign(1);
        complaint.setDoDate(new Date());
        complaintService.updateByPrimaryKeySelective(complaint);
        EduUser eduUser = (EduUser) req.getSession().getAttribute("eduUser");
        if(eduUser==null)
        {
            model.addAttribute("msg","登陆超时,重新登陆");
            return "success";
        }
        System.out.println(eduUser);
        reply.setWhoId(complaint.getWhoId());
        reply.setcId(Integer.parseInt(cid1));


        if (file!=null)
        {
            String filenames = pathHead + fastefsClient.uploFile(file);
            System.out.println(filenames);
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String ds = simpleDateFormat.format(date);
//            Date date1 = simpleDateFormat.parse(ds);

            reply.setCreateDate(new Date());


            replyService.insertSelective(reply);
            return "success";

        }


         else {
            reply.setCreateDate(new Date());

            replyService.insertSelective(reply);
            return "success";
        }



    }


    @RequestMapping(value = "/fileTest", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "文件的测试")
    public String fileTest(Model model, Integer cid, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req) throws IOException, ParseException {
        String filenames = pathHead + fastefsClient.uploFile(file);
        System.out.println(filenames);
        return filenames;
    }


}
