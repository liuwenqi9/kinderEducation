package com.muji.zh.kinder.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.*;

import com.muji.zh.config.FastefsClient;
import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
//@Controller
@Api(value = "/kinder",description = "这是全部的/kinder方法")
@Controller
@RequestMapping("/kinder")
public class KindergartenController {
    @Reference
    private KindergartenService kindergartenService;
    @Reference
    private KindergrationTypeService kindergratenTypeService;
    @Reference
    private AreaService areaService;
    @Reference
    private EducationService educationService;
    @Reference
    private KinderLegalService kinderLegalService;
    @Reference
    private PaymentListService paymentListService;
    @Reference
    private StudentService studentService;
    @Reference
    private StuParentService stuParentService;
    @Reference
    private PractitionerService practitionerService;
    @Reference
    private ClasService clasService;
    @Reference
    private StationService stationService;
    @Reference
    private NoticeService noticeService;
    @Reference
    private KinderFileService kinderFileService;
    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;
    @Autowired
    private FastefsClient fastefsClient;
    @ApiOperation(value = "欲添加幼儿园")
    @RequestMapping(value = "/toadd")
    public String toadd(Model model, Integer id) {
        List<Area> list = areaService.dinstinctName(id);
        model.addAttribute("areaList", list);
        List<Education> educationList = educationService.distinctName(id);
        model.addAttribute("educationList", educationList);
        List<KindergartenType> kindergartenTypeList = kindergratenTypeService.distinct();
        model.addAttribute("typeList", kindergartenTypeList);

        return "/kinder/addKinder";
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ApiOperation("添加幼儿园信息")
//    public String add(Kindergarten kindergarten) {
//        System.out.println(kindergarten.toString());
//        kindergartenService.insertSelective(kindergarten, eduname, legalName);
//        return kindergarten.toString();
//    }
    @RequestMapping(value ="/chooseSalary",method = RequestMethod.POST)
    @ApiOperation("查询个人工资")
    public String chooseSalary(Model model,String sname,Integer pId,HttpServletRequest request){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            Kindergarten kindergarten= (Kindergarten) kindergartenService.findById(kinderLegal.getKindId());
            String kindergartenName=kindergarten.getKname();
            PageInfo<SalaryList> salaryListList=kindergartenService.chooseSalaryList(pId,sname,kindergartenName,1);
            long count=salaryListList.getList().size();
            model.addAttribute("salaryListList",salaryListList);
            model.addAttribute("sname",sname);
            model.addAttribute("pId",pId);
            model.addAttribute("count",count);
            model.addAttribute("check",1);
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "redirect:/kinder/tologin";
        }
        return "salaryManageSearch";
    }
    @RequestMapping(value ="/chooseSalarys")
    public String chooseSalarys(Model model,@RequestParam(defaultValue = "") String sname,@RequestParam(defaultValue = "") Integer pId,HttpServletRequest request,@RequestParam(defaultValue = "1") int currentPage){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            Kindergarten kindergarten=kindergartenService.findById(kinderLegal.getKindId());
            String kindergartenName=kindergarten.getKname();
            PageInfo<SalaryList> salaryListList=kindergartenService.chooseSalaryList(pId,sname,kindergartenName,currentPage);;
            long count=salaryListList.getList().size();
            model.addAttribute("salaryListList",salaryListList);
            model.addAttribute("sname",sname);
            model.addAttribute("pId",pId);
            model.addAttribute("count",count);
            model.addAttribute("check",1);
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "redirect:/kinder/tologin";
        }
        return "salaryManageSearch";
    }
    @RequestMapping(value = "/choosePayment", method = RequestMethod.POST)
    @ApiOperation("查询个人缴费")
    public String choosePayment(Model model,String pname,Integer sId,HttpServletRequest request){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            Kindergarten kindergarten=kindergartenService.findById(kinderLegal.getKindId());
            String kindergartenName=kindergarten.getKname();
            PageInfo<PaymentList> paymentListList=paymentListService.choosePaymentList(sId,pname,kindergartenName,1);
            model.addAttribute("paymentListList",paymentListList);
            model.addAttribute("pname",pname);
            model.addAttribute("sId",sId);
            model.addAttribute("check",1);
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "redirect:/kinder/tologin";
        }
        return "payManageSearch";
    }
    @RequestMapping("/choosePayments")
    @ApiOperation("查询个人缴费")
    public String choosePayments(Model model,@RequestParam(defaultValue = "") String pname,@RequestParam(defaultValue = "")Integer sId,HttpServletRequest request,@RequestParam(defaultValue = "1") int currentPage){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            Kindergarten kindergarten=kindergartenService.findById(kinderLegal.getKindId());
            String kindergartenName=kindergarten.getKname();
            PageInfo<PaymentList> paymentListList=paymentListService.choosePaymentList(sId,pname,kindergartenName,currentPage);
            model.addAttribute("paymentListList",paymentListList);
            model.addAttribute("pname",pname);
            model.addAttribute("sId",sId);
            model.addAttribute("check",1);
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "redirect:/kinder/tologin";
        }
        return "payManageSearch";
    }
    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation("法人登陆")
    @ResponseBody
    public String login(Integer id,String password,HttpServletRequest request){
        KinderLegal kinderLegal=kinderLegalService.login(id,password);
        if(kinderLegal!=null){
            Kindergarten kindergarten=kindergartenService.findById(kinderLegal.getKindId());
            request.getSession().setAttribute("kinderLegal",kinderLegal);
            request.getSession().setAttribute("kindergarten",kindergarten);
            return "200";
        }
        else {
            return "403";
        }
    }
    @RequestMapping(value = "/updatePassword",method=RequestMethod.POST)
    @ApiOperation("修改密码")
    @ResponseBody
    public String updatePassword(String password,HttpServletRequest request){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            KinderLegal kinder=new KinderLegal();
            kinder.setId(kinderLegal.getId());
            kinder.setPassword(password);
            kinderLegalService.updatePassword(kinder);
            return "success";
        }else{
            return "redirect:/kinder/tologin";
        }

    }
    @RequestMapping(value = "/paymodeUpload",method = RequestMethod.POST)
    @ApiOperation("模板上传")
    @ResponseBody
    public Map<String, Object> paymodeUpload(HttpServletRequest request,@RequestParam("file")MultipartFile file,KinderFile kinderFile) throws IOException {
           // int size = (int) file.getSize();
        Map<String, Object> map = new HashMap<>(2);
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            if(file.isEmpty()){
                map.put("url",kinderFile.getUrl());
                map.put("fId",kinderFile.getfId());
                map.put("msg","请上传附件");
                return map;
            }else{
                Workbook wb = null;
                if (isExcel2007(file.getOriginalFilename())) {
                    wb = new XSSFWorkbook(file.getInputStream());
                } else {
                    wb = new HSSFWorkbook(file.getInputStream());
                }
                Sheet sheet = wb.getSheetAt(0);//获取第一张表
                Row titleRow=sheet.getRow(0);

                if(!("学号".equals(titleRow.getCell(0).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }else if(!("学生姓名".equals(titleRow.getCell(1).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }else if(!("性别".equals(titleRow.getCell(2).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }else if(!("所在学校".equals(titleRow.getCell(3).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }else if(!("所在年级".equals(titleRow.getCell(4).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }else if(!("所在班级".equals(titleRow.getCell(5).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }else if(!("应交学费(月)".equals(titleRow.getCell(6).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }else if(!("基本学费(月)".equals(titleRow.getCell(7).getStringCellValue()))){
                    map.put("url",kinderFile.getUrl());
                    map.put("fId",kinderFile.getfId());
                    map.put("msg","模板格式内容不正确，请查证后上传");
                    return map;
                }
                String fileUrl=pathHead+fastefsClient.uploFile(file);
                fastefsClient.deleteFile(kinderFile.getUrl());
                kinderFileService.deleteFile(kinderFile.getfId());
                String type="1";
                KinderFile kFile=kinderFileService.insertFile(file.getOriginalFilename(),fileUrl,type,kinderLegal.getKindId());
                map.put("url",kFile.getUrl());
                map.put("fId",kFile.getfId());
                map.put("msg","成功上传模板");
                return map;
            }
        }else{
            map.put("url", kinderFile.getUrl());
            map.put("fId", kinderFile.getfId());
            map.put("msg", "登陆超时请重新登录");
            return map;
        }
    }
    @RequestMapping(value = "/modeUpload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modeUpload(HttpServletRequest request,@RequestParam("file")MultipartFile file,KinderFile kinderFile) throws IOException {
        Map<String, Object> map = new HashMap<>(2);
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null) {
            if (file.isEmpty()) {
                map.put("url", kinderFile.getUrl());
                map.put("fId", kinderFile.getfId());
                map.put("msg", "请上传附件");
                return map;
            } else {
                Workbook wb = null;
                if (isExcel2007(file.getOriginalFilename())) {
                    wb = new XSSFWorkbook(file.getInputStream());
                } else {
                    wb = new HSSFWorkbook(file.getInputStream());
                }
                Sheet sheet = wb.getSheetAt(0);//获取第一张表
                Row titleRow = sheet.getRow(0);

                if (!("教职工号".equals(titleRow.getCell(0).getStringCellValue()))) {
                    map.put("url", kinderFile.getUrl());
                    map.put("fId", kinderFile.getfId());
                    map.put("msg", "模板格式内容不正确，请查证后上传");
                    return map;
                } else if (!("教师姓名".equals(titleRow.getCell(1).getStringCellValue()))) {
                    map.put("url", kinderFile.getUrl());
                    map.put("fId", kinderFile.getfId());
                    map.put("msg", "模板格式内容不正确，请查证后上传");
                    return map;
                } else if (!("年龄".equals(titleRow.getCell(2).getStringCellValue()))) {
                    map.put("url", kinderFile.getUrl());
                    map.put("fId", kinderFile.getfId());
                    map.put("msg", "模板格式内容不正确，请查证后上传");
                    return map;
                } else if (!("性别".equals(titleRow.getCell(3).getStringCellValue()))) {
                    map.put("url", kinderFile.getUrl());
                    map.put("fId", kinderFile.getfId());
                    map.put("msg", "模板格式内容不正确，请查证后上传");
                    return map;
                } else if (!("所属学校".equals(titleRow.getCell(4).getStringCellValue()))) {
                    map.put("url", kinderFile.getUrl());
                    map.put("fId", kinderFile.getfId());
                    map.put("msg", "模板格式内容不正确，请查证后上传");
                    return map;
                } else if (!("应得工资(月)".equals(titleRow.getCell(5).getStringCellValue()))) {
                    map.put("url", kinderFile.getUrl());
                    map.put("fId", kinderFile.getfId());
                    map.put("msg", "模板格式内容不正确，请查证后上传");
                    return map;
                } else if (!("基本工资(月)".equals(titleRow.getCell(6).getStringCellValue()))) {
                    map.put("url", kinderFile.getUrl());
                    map.put("fId", kinderFile.getfId());
                    map.put("msg", "模板格式内容不正确，请查证后上传");
                    return map;
                }
                String fileUrl = pathHead + fastefsClient.uploFile(file);
                fastefsClient.deleteFile(kinderFile.getUrl());
                kinderFileService.deleteFile(kinderFile.getfId());
                String type = "2";
                KinderFile kFile = kinderFileService.insertFile(file.getOriginalFilename(), fileUrl, type, kinderLegal.getKindId());
                map.put("url", kFile.getUrl());
                map.put("fId", kFile.getfId());
                map.put("msg", "成功上传模板");
                return map;
            }
        }
        map.put("url", kinderFile.getUrl());
        map.put("fId", kinderFile.getfId());
        map.put("msg", "登陆超时请重新登录");
        return map;
    }
    @RequestMapping(value ="/checkKinder",method = RequestMethod.GET)
    @ApiOperation("幼儿园列表")
    public String checkKinder(Model model,HttpServletRequest request){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            Kindergarten kindergarten=kindergartenService.findById(kinderLegal.getKindId());
            model.addAttribute("kindergarten",kindergarten);
            return "kinderView";
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "kinderView";
        }
    }
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    @ApiOperation("文件上传")
    @ResponseBody
    public allSalayList fileUpload(@RequestParam("file")MultipartFile file,Model model) throws IOException {
        Workbook wb = null;
        if (isExcel2007(file.getOriginalFilename())) {
            wb = new XSSFWorkbook(file.getInputStream());
        } else {
            wb = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        Row titleRow=sheet.getRow(0);
        String titles="";
        for(int y=0; y<titleRow.getPhysicalNumberOfCells();y++){
            titles+=titleRow.getCell(y).getStringCellValue()+",";
        }
        titles = titles.substring(0,titles.length()-1);
        InputStream input = file.getInputStream();
        byte[] arr = null;
        arr = IOUtils.toByteArray(input);
        List<SalaryList>  salaryListList = kindergartenService.fileupload(file.getOriginalFilename(),arr);
       //List<SalaryList>  salaryListList =null;

        allSalayList allSalayList=new allSalayList();
        if(salaryListList==null||salaryListList.size()==0){
            allSalayList.setStatus(403);
        }
        allSalayList.setSalaryListList(salaryListList);
        allSalayList.setTitles(titles);
        allSalayList.setStatus(200);
        return allSalayList;
    }
    @RequestMapping(value = "/payFileUpload",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("缴费清单文件上传")
    public allPaymentList payFileUpload(@RequestParam("file")MultipartFile file) throws IOException {
        Workbook wb = null;
        if (isExcel2007(file.getOriginalFilename())) {
            wb = new XSSFWorkbook(file.getInputStream());
        } else {
            wb = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        Row titleRow=sheet.getRow(0);
        String titles="";
        for(int y=0; y<titleRow.getPhysicalNumberOfCells();y++){
            titles+=titleRow.getCell(y).getStringCellValue()+",";
        }
        titles = titles.substring(0,titles.length()-1);
        InputStream input = file.getInputStream();
        byte[] arr = null;
        arr = IOUtils.toByteArray(input);
        List<PaymentList> paymentListList=paymentListService.fileUpload(file.getOriginalFilename(),arr,titles);
        allPaymentList allPaymentList=new allPaymentList();
        if(paymentListList==null||paymentListList.size()==0){
            allPaymentList.setStatus(403);
        }
        allPaymentList.setPaymentListList(paymentListList);
        allPaymentList.setTitles(titles);
        allPaymentList.setStatus(200);
        return allPaymentList;
    }
    @RequestMapping("/practitionerImport")
    public String practitionerImport(){
        return "practitionerImport";
    }
    @RequestMapping(value = "/personUpload",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("人员清单文件上传")
    public String personUpload(@RequestParam("file")MultipartFile file,HttpServletRequest request) throws IOException {
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        InputStream input = file.getInputStream();
        byte[] arr = null;
        arr = IOUtils.toByteArray(input);
        int result=practitionerService.fileupload(file.getOriginalFilename(),arr,kinderLegal);
        if(result==2){
            return "表内教职工号为空或者已经存在";
        }else if(result==3){
            return "表内有不正确的岗位信息";
        }else if(result==-1){
            return "文件上传失败";
        }else if(result==0){
            return "文件上传成功";
        }
        return "文件上传失败";
    }
    public static boolean isExcel2007(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
    @RequestMapping(value="/fileDownload")
    @ApiOperation("文件下载")
    @ResponseBody
    public String fileDownload(String fileName){
        String result=kindergartenService.fileDownload(fileName);
        return result;
    }
    @RequestMapping(value = "/checkStudent",method = RequestMethod.GET)
    @ApiOperation("查看学生信息")
    @ResponseBody
    public String checkStudent(Model model,HttpServletRequest request){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            List<Student> studentList=studentService.studentView(kinderLegal.getKindId());
            model.addAttribute("studentList",studentList);
            return "studentView";
        }
        else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "kinderView";
        }
    }
    @RequestMapping(value = "/checkParent",method = RequestMethod.GET)
    @ApiOperation("查看亲属关系")
    @ResponseBody
    public ParentVo parentView(Integer sId){
        return stuParentService.ParentView(sId);
    }
    @RequestMapping(value = "/deleteStudent",method = RequestMethod.GET)
    @ApiOperation("删除学生")
    @ResponseBody
    public String deleteStudent(String id){
        studentService.deleteStudent(Integer.parseInt(id));
        return "redirect:/checkStudent";
    }

    @RequestMapping(value = "/updateStudent",method = RequestMethod.GET)
    @ApiOperation("修改学生信息")
    @ResponseBody
    public String updateStudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/checkStudent";
    }

    @RequestMapping("/salaryManageSearch")
    @ApiOperation("工资清单列表")
    public String showSalaryList(HttpServletRequest request, Model model,int currentPage){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        String kName=kindergartenService.getKname(kinderLegal.getKindId());
        PageInfo<SalaryList> salaryListList=kindergartenService.findAllByKinderName(kName,currentPage,5);
        long count=salaryListList.getList().size();
        model.addAttribute("salaryListList",salaryListList);
        model.addAttribute("count",count);
        model.addAttribute("check",0);
        return "salaryManageSearch";
    }
    @RequestMapping("/toImport")
    @ApiOperation("工资清单上传")
    public String toImport(){
        return "salaryManageImport";
    }
    @RequestMapping("/payManageImport")
    @ApiOperation("缴费清单上传")
    public String payManageImport(){
        return "payManageImport";
    }
    @RequestMapping("/index")
    @ApiOperation("首页")
    public String index(HttpServletRequest request,Model model){
        return "index";
    }
    @RequestMapping("/retest")
    public String test(){
        return "test";
    }
    @RequestMapping("/payManageSearch")
    public String payManageSearch(HttpServletRequest request,Model model,int currentPage){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        String kName=kindergartenService.getKname(kinderLegal.getKindId());
        PageInfo<PaymentList> paymentListList=paymentListService.findAllByKinderName(kName,currentPage,5);
        long count=paymentListList.getList().size();
        model.addAttribute("paymentListList",paymentListList);
        model.addAttribute("check",0);
        model.addAttribute("count",count);
        return "payManageSearch";
    }
    @RequestMapping(value="schoolManageUpload")
    public String schoolManageUpload(HttpServletRequest request,Model model) throws ParseException {
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal==null){
            return "redirect:/kinder/tologin";
        }
        Kindergarten kindergarten=kindergartenService.findById(kinderLegal.getKindId());
        List<Area> areas=areaService.findAll();
        if(kindergarten!=null){
            Education education=educationService.findById(kindergarten.getEduId());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            String createDate=sdf.format(kindergarten.getCreateDate().getTime());
            model.addAttribute("createDate",createDate);
            model.addAttribute("education",education);
            model.addAttribute("kindergarten",kindergarten);
        }
        model.addAttribute("areas",areas);
        return "schoolManageUpload";
    }
    @RequestMapping("/schoolManageSearch")
    public String schoolManageSearch(HttpServletRequest request,Model model){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        List<Practitioner> practitionerList=practitionerService.findPraList(kinderLegal.getKindId());
        model.addAttribute("practitionerList",practitionerList);
        return "schoolManageSearch";
    }

    @RequestMapping("payManageSend")
    public String payManageSend(HttpServletRequest request,Model model){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal==null){
            return "redirect:/kinder/tologin";
        }
        KinderFile kinderFile=kinderFileService.findKinderFile(String.valueOf(1),kinderLegal.getKindId());
        model.addAttribute("kinderFile",kinderFile);
        return "payManageSend";
    }
    @RequestMapping("salaryManageSend")
    public String salaryManageSend(HttpServletRequest request,Model model){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal==null){
            return "redirect:/kinder/tologin";
        }
        KinderFile kinderFile=kinderFileService.findKinderFile(String.valueOf(2),kinderLegal.getKindId());
        model.addAttribute("kinderFile",kinderFile);
        return "salaryManageSend";
    }
    @RequestMapping(value = "/insterKinder",method=RequestMethod.POST)
    @ApiOperation("添加幼儿园")
    @ResponseBody
    public int insterKinder(HttpServletRequest request,Kindergarten kindergarten,String mphone,Integer kId,String date,String eduname,String legalName,@RequestParam("file")MultipartFile file,@RequestParam("file1")MultipartFile file1,@RequestParam("file2")MultipartFile file2){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kId!=null){
            Kindergarten check=kindergartenService.findById(kId);
            if(check!=null){
                if(!file.isEmpty()){
                    kindergarten.setFlag4(pathHead+fastefsClient.uploFile(file));

                }
                if(!file1.isEmpty()){
                    kindergarten.setFlag5(pathHead+fastefsClient.uploFile(file1));
                }
                if(!file2.isEmpty()){
                    kindergarten.setFirework(pathHead+fastefsClient.uploFile(file2));
                }
                kindergarten.setPhone(mphone);
                int flag=kindergartenService.editKinder(kindergarten,date,eduname,legalName,kinderLegal.getId());
                if(flag==1){
                    return 1;
                }else if(flag==3){
                    return 3;
                }
                return 0;
            }
        }

        if(file.isEmpty()||file1.isEmpty()||file2.isEmpty()){
            return 2;
        }
        kindergarten.setkId(kinderLegal.getKindId());
        kindergarten.setFlag4(pathHead+fastefsClient.uploFile(file));
        kindergarten.setFlag5(pathHead+fastefsClient.uploFile(file1));
        kindergarten.setFirework(pathHead+fastefsClient.uploFile(file2));
        kindergarten.setPhone(mphone);
        int result=kindergartenService.insertSelective(kindergarten,date,eduname,legalName,kinderLegal.getId());
        if(result==1){
            return 1;
        }else if(result==3){
            return 3;
        }
        return 0;
    }
//    public String fileUpload(MultipartFile file,String filename){
//        String path = "F:/test" ;
//        String fileName = file.getOriginalFilename();
//        int size = (int) file.getSize();
//        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//        String pathname=path + "/" + filename +"."+suffix;
//        File dest = new File(path + "/" + filename +"."+suffix);
//        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
//            dest.getParentFile().mkdir();
//        }
//        try {
//            file.transferTo(dest);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        return pathname;
//    }
    @RequestMapping(value ="/choosePractitioner")
    @ApiOperation("查询个人工资")
    public String choosePra(Model model,String pname,String phone,HttpServletRequest request){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            List<Practitioner> practitionerList=practitionerService.choosePra(pname,phone,kinderLegal.getKindId());
            model.addAttribute("practitionerList",practitionerList);
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "schoolManageSearch";
        }
        return "schoolManageSearch";
    }
    @RequestMapping(value ="/chooseStudent",method = RequestMethod.POST)
    @ApiOperation("查询学生信息")
    public String chooseStudnet(Model model,String sname,Integer stuId,HttpServletRequest request){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            PageInfo<StudentVo> studentVoList=studentService.chooseStudent(sname,stuId,kinderLegal.getKindId(),1);
            long count=studentService.chooseCount(sname,stuId,kinderLegal.getKindId());
            model.addAttribute("studentVoList",studentVoList);
            model.addAttribute("check",1);
            model.addAttribute("sname",sname);
            model.addAttribute("stuId",stuId);
            model.addAttribute("count",count);
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "schoolStudentSearch";
        }
        return "schoolStudentSearch";
    }
    @RequestMapping("/chooseStudents")
    @ApiOperation("查询学生信息")
    public String chooseStudents(Model model,@RequestParam(defaultValue = "") String sname,@RequestParam(defaultValue = "") Integer stuId,HttpServletRequest request,@RequestParam(defaultValue = "1") int currentPage){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal!=null){
            PageInfo<StudentVo> studentVoList=studentService.chooseStudent(sname,stuId,kinderLegal.getKindId(),currentPage);
            long count=studentService.chooseCount(sname,stuId,kinderLegal.getKindId());
            model.addAttribute("studentVoList",studentVoList);
            model.addAttribute("check",1);
            model.addAttribute("sname",sname);
            model.addAttribute("stuId",stuId);
            model.addAttribute("count",count);
        }else{
            model.addAttribute("msg","当前用户登录超时请重新登录");
            return "schoolStudentSearch";
        }
        return "schoolStudentSearch";
    }
    @RequestMapping("/loginout")
    @ApiOperation("登录推出")
    public String loginout(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session==null){
            return "login";
        }
        session.invalidate();
        return "login";
    }

    @RequestMapping("/deleteClass")
    @ResponseBody
    @ApiOperation("删除班级")
    public Integer deleteClass(Integer id){
        if(clasService.deleteClass(id)){
            return 200;
        }else{
            return 500;
        }
    }
    @RequestMapping(value = "/classEdit/{cId}",method = RequestMethod.GET)
    @ApiOperation("到班级修改页面")
    public String updateClass(@PathVariable String cId,Model model){
        Clas clas=clasService.findById(Integer.valueOf(cId));
        List<ClassType> classTypeList=clasService.getClassType();
        List<Practitioner> practitionerList=clasService.findPractitionerList(clas.getKid());
        model.addAttribute("clas",clas);
        model.addAttribute("classTypeList",classTypeList);
        model.addAttribute("practitionerList",practitionerList);
        return "classEdit";
    }
    @RequestMapping(value = "/updateClass",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("班级修改")
    public Integer update(Clas clas){
        int result=clasService.update(clas);
        if(result==0){
            return 200;
        }else if(result==1){
            return 1;
        }else if(result==2){
            return 2;
        }else if(result==3){
            return 3;
        }
        else{
            return 500;
        }
    }
    @RequestMapping(value = "/classAdd",method = RequestMethod.GET)
    @ApiOperation("到班级添加")
    public String classAdd(HttpServletRequest request,Model model){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        List<ClassType> classTypeList=clasService.getClassType();
        List<Practitioner> practitionerList=clasService.findPractitionerList(kinderLegal.getKindId());
        model.addAttribute("classTypeList",classTypeList);
        model.addAttribute("practitionerList",practitionerList);
        return "classAdd";
    }
    @RequestMapping(value = "/classInster",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("班级添加")
    public Integer add(HttpServletRequest request,Clas clas){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if (kinderLegal == null) {
            return 403;
        }else{
            clas.setKid(kinderLegal.getKindId());
            clas.setFlag1(String.valueOf(kinderLegal.getAreaId()));
            int result=clasService.insterClass(clas);
            if(result==1){
                return 1;
            }
            if(result==2){
                return 2;
            }
            return 200;
        }
    }
    @RequestMapping(value = "/checkClass",method = RequestMethod.POST)
    public String checkClass(HttpServletRequest request,Model model,String cname){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        PageInfo<ClassVo> classVoList=clasService.selectClassByName(kinderLegal.getKindId(),cname,1);
        long count=clasService.checkCount(kinderLegal.getKindId(),cname);
        model.addAttribute("classVoList",classVoList);
        model.addAttribute("count",count);
        model.addAttribute("check",1);
        model.addAttribute("cname",cname);
        return "classList";
    }
    @RequestMapping("/checkClasses")
    public String checkClasses(HttpServletRequest request,Model model,String cname,@RequestParam(defaultValue = "1") int currentPage){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        PageInfo<ClassVo> classVoList=clasService.selectClassByName(kinderLegal.getKindId(),cname,currentPage);
        long count=clasService.checkCount(kinderLegal.getKindId(),cname);
        model.addAttribute("classVoList",classVoList);
        model.addAttribute("count",count);
        model.addAttribute("check",1);
        model.addAttribute("cname",cname);
        return "classList";
    }
    @RequestMapping("/classList")
    @ApiOperation("班级列表展示")
    public String classList(HttpServletRequest request,Model model,int currentPage,@RequestParam(defaultValue = "0") int check){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        PageInfo<ClassVo> classVoList=clasService.selectClass(kinderLegal.getKindId(),currentPage,5);
        long count=clasService.selectCount(kinderLegal.getKindId());
        model.addAttribute("classVoList",classVoList);
        model.addAttribute("count",count);
        model.addAttribute("check",check);
        return "classList";

    }
    @RequestMapping("/practitionList")
    @ApiOperation("教职工列表展示")
    public String practitionList(HttpServletRequest request,Model model,int currentPage,@RequestParam(defaultValue = "0") int check){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
            PageInfo<PraVo> praVoList=practitionerService.getPraVoList(kinderLegal.getKindId(),currentPage,5);
            long count=practitionerService.getCount(kinderLegal.getKindId());
            model.addAttribute("praVoList",praVoList);
            model.addAttribute("count",count);
            model.addAttribute("check",0);
        return "practitionList";
    }
    @RequestMapping("/deletePra")
    @ResponseBody
    @ApiOperation("删除职工")
    public Integer deletePra(Integer id){
        if(practitionerService.deletePra(id)){
            return 200;
        }else{
            return 500;
        }
    }
    @RequestMapping(value = "/practitionEdit/{cId}",method = RequestMethod.GET)
    @ApiOperation("修改职工信息")
    public String  practitionEdit(@PathVariable String cId,Model model){
        Practitioner practitioner=practitionerService.findById(Integer.valueOf(cId));
        List<Station> stationList=stationService.findAll();
        model.addAttribute("stationList",stationList);
        model.addAttribute("practitioner",practitioner);
        return "practitionEdit";
    }
    @RequestMapping(value = "/updatePra",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("班级修改")
    public Integer updatePra(Practitioner practitioner){
        if(practitionerService.update(practitioner)){
            return 200;
        }
        else{
            return 500;
        }
    }
    @RequestMapping(value = "/practitionAdd",method = RequestMethod.GET)
    @ApiOperation("到员工添加")
    public String practitionAdd(Model model){
        List<Station> stationList=stationService.findAll();
        List<KinderLegal> kinderLegalList=kinderLegalService.findAll();
        model.addAttribute("stationList",stationList);
        model.addAttribute("kinderLegalList",kinderLegalList);
        return "practitionAdd";
    }
    @RequestMapping(value = "/praInster",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation("员工添加")
    public Integer addPra(HttpServletRequest request,Practitioner practitioner){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal==null){
            return 403;
        }else{
            practitioner.setKinderId(kinderLegal.getKindId());
            practitioner.setLegalParsonName(kinderLegal.getKlname());
            practitioner.setLegalParsonPhone(kinderLegal.getPhone());
            practitionerService.praInster(practitioner);
            return 200;
        }
    }
    @RequestMapping(value = "/checkPra",method = RequestMethod.POST)
    public String checkPra(HttpServletRequest request,String pname,Model model){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        PageInfo<PraVo> praVoList=practitionerService.checkPra(kinderLegal.getKindId(),pname, 1);
        long count=practitionerService.checkCount(kinderLegal.getKindId(),pname);
        model.addAttribute("praVoList",praVoList);
        model.addAttribute("count",count);
        model.addAttribute("check",1);
        model.addAttribute("pname",pname);
        return "practitionList";
    }
    @RequestMapping(value = "/checkPras")
    public String checkPra(HttpServletRequest request,String pname,Model model,@RequestParam(defaultValue = "1") int currentPage){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        PageInfo<PraVo> praVoList=practitionerService.checkPra(kinderLegal.getKindId(),pname,currentPage);
        long count=practitionerService.checkCount(kinderLegal.getKindId(),pname);
        model.addAttribute("praVoList",praVoList);
        model.addAttribute("count",count);
        model.addAttribute("check",1);
        model.addAttribute("pname",pname);
        return "practitionList";
    }
    @RequestMapping(value = "/getPhone",method = RequestMethod.POST)
    public String getPhone(String id){
        KinderLegal kinderLegal=kinderLegalService.findById(Integer.valueOf(id));
        if(kinderLegal!=null){
            return kinderLegal.getPhone();
        }
        return null;
    }
    @RequestMapping("/schoolStudentSearch")
    public String schoolStudentSearch(HttpServletRequest request,Model model,int currentPage,@RequestParam(defaultValue = "0") int check){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        if(kinderLegal==null){
            return "redirect:/kinder/tologin";
        }
        PageInfo<StudentVo> studentVoList=studentService.getStudentVo(kinderLegal.getKindId(),currentPage,5);
        if(studentVoList.getList().size()==0||studentVoList.getList().isEmpty()){
            long count=0;
            model.addAttribute("count",count);
        }else{
            long count=studentVoList.getList().size();
            model.addAttribute("count",count);
        }
        model.addAttribute("studentVoList",studentVoList);
        model.addAttribute("check",check);

        return "schoolStudentSearch";
    }
    @RequestMapping("/seeNotice")
    public String seeNotice(HttpServletRequest request,Model model){
        KinderLegal kinderLegal= (KinderLegal) request.getSession().getAttribute("kinderLegal");
        List<Notice> noticeList=noticeService.findKinderNotice(kinderLegal.getAreaId());
        model.addAttribute("noticeList",noticeList);
        return "seeNotice";
    }
//    @RequestMapping(value = "/fileTest", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation(value = "文件的测试")
//    public String fileTest(Model model, Integer cid, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest req) throws IOException, ParseException {
//        String filenames = pathHead + fastefsClient.uploFile(file);
//        System.out.println(filenames);
//        return filenames;
//    }

}
