package com.muji.zh.admin.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.mapper.*;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.KindergartenService;
import com.muji.zh.admin.util.FtpUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.muji.zh.admin.util.ExcelUtil.isExcel2007;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class KindergartenServiceImpl implements KindergartenService {
    @Autowired
    private KindergartenMapper kindergartenMapper;

    @Autowired
    private SalaryListMapper salaryListMapper;



//    @Value("${FTP_ADDRESS}")
//    private String host;
//    @Value("${FTP_PORT}")
//    private int port;
//    @Value("${FTP_USERNAME}")
//    private String username;
//    @Value("${FTP_PASSWORD}")
//    private String password;
//    @Value("${FTP_BASE_PATH}")
//    private String basePath;
//    @Value("${IMAGE_BASE_URL}")
//    private String fileUrl;
    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;



    @Autowired
    private ParSlarListMapper parSlarListMapper;

    @Autowired
    private KinderLegalMapper kinderLegalMapper;
    @Autowired
    private EducationMapper educationMapper;
    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private PractitionerMapper practitionerMapper;
    @Override
    public int findByAreaIdToType(Integer areaId, Integer typeID,Integer sing) {
        if (sing==1) {


            KindergartenExample kindergartenExample = new KindergartenExample();
            KindergartenExample.Criteria criteria = kindergartenExample.createCriteria();
            criteria.andUrbanIdEqualTo(areaId);
            criteria.andBusinessNatureEqualTo("公办");
            Long s = kindergartenMapper.countByExample(kindergartenExample);
            return Math.toIntExact(s);
        }else {
            KindergartenExample kindergartenExample = new KindergartenExample();
            KindergartenExample.Criteria criteria = kindergartenExample.createCriteria();
            criteria.andAreaIdEqualTo(areaId);
            criteria.andBusinessNatureEqualTo("公办");
            Long s = kindergartenMapper.countByExample(kindergartenExample);
            return Math.toIntExact(s);

        }
    }



    @Override
    public int sumKinder(Integer areaId,Integer sign) {
        if (sign==1)
        {
            KindergartenExample kindergartenExample= new KindergartenExample();
            KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
            criteria.andUrbanIdEqualTo(areaId);
            return (int) kindergartenMapper.countByExample(kindergartenExample);
        }else {
            KindergartenExample kindergartenExample= new KindergartenExample();
            KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
            criteria.andAreaIdEqualTo(areaId);
            return (int) kindergartenMapper.countByExample(kindergartenExample);
        }

    }


    @Override
    public SalaryListVo chooseSalaryList(Integer pId, String sname) {
//        SalaryListVo salaryListVo=salaryListMapper.selectBysNameAndsId(sname,pId);
//        if (salaryListVo==null){
//            return null;
//        }
//        return salaryListVo;
        return null;
    }




    @Override
    public int insertSelective(Kindergarten record) {
        return kindergartenMapper.insertSelective(record);
    }


    @Override
    public int deleteByPrimaryKey(Integer kId) {
        return kindergartenMapper.deleteByPrimaryKey(kId);
    }

    @Override
    public int insert(Kindergarten record) {
        return kindergartenMapper.insert(record);
    }

    @Override
    public List<Kindergarten> selectByExample(KindergartenExample example) {
        return kindergartenMapper.selectByExample(example);
    }

    @Override
    public Kindergarten selectByPrimaryKey(Integer kId) {
        return kindergartenMapper.selectByPrimaryKey(kId);
    }

    @Override
    public int updateByPrimaryKeySelective(Kindergarten record) {
        return kindergartenMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Kindergarten record) {
        return kindergartenMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Kindergarten> findByareaID(String area_id) {
        KindergartenExample kindergartenExample= new KindergartenExample();
        KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
        criteria.andAreaIdEqualTo(Integer.parseInt(area_id));
        return  kindergartenMapper.selectByExample(kindergartenExample);
    }

    @Override
    public Long countTotal(EduUser eduUser) {
        if (eduUser.getSign()==1)
        {
            KindergartenExample kindergartenExample= new KindergartenExample();
            KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
            criteria.andUrbanIdEqualTo(eduUser.getAreaId());
            return  kindergartenMapper.countByExample(kindergartenExample);
        }else {
            KindergartenExample kindergartenExample= new KindergartenExample();
            KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
            criteria.andAreaIdEqualTo(eduUser.getAreaId());
            return  kindergartenMapper.countByExample(kindergartenExample);
        }

    }

    @Override
    public List<Kindergarten> findAll() {
        KindergartenExample kindergartenExample= new KindergartenExample();
        KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
        //criteria.andAreaIdEqualTo(eduUser.getAreaId());
        return  kindergartenMapper.selectByExample(kindergartenExample);
    }

    @Override
    public List<Kindergarten> sel() {
        KindergartenExample kindergartenExample= new KindergartenExample();
        KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();

        return kindergartenMapper.selectByExample(kindergartenExample);
    }


















    /*   private RedisUtil redisUtil=new RedisUtil();*/
    @Override
    public int findByAreaIdToType(Integer areaId, Integer typeID) {
        KindergartenExample kindergartenExample= new KindergartenExample();
        KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
        criteria.andUrbanIdEqualTo(areaId);
        criteria.andKtIdEqualTo(typeID);
        Long s=kindergartenMapper.countByExample(kindergartenExample);
        return Math.toIntExact(s);
    }



    @Override
    public int sumKinder(Integer areaId) {
        KindergartenExample kindergartenExample= new KindergartenExample();
        KindergartenExample.Criteria criteria=kindergartenExample.createCriteria();
        criteria.andUrbanIdEqualTo(areaId);
        return (int) kindergartenMapper.countByExample(kindergartenExample);
    }

    @Override
    public PageInfo<SalaryList> findAllByKinderName(String kinderName, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<SalaryList> salaryListList=salaryListMapper.selectPartView(kinderName);
        PageInfo<SalaryList> pageInfo=new PageInfo<SalaryList>(salaryListList);
        return pageInfo;
    }


    @Override
    public PageInfo<SalaryList> chooseSalaryList(Integer pId, String sname,String kindergartenName,int currentPage) {
        PageHelper.startPage(currentPage,5);
        List<SalaryList> salaryListList=salaryListMapper.selectBysNameAndsId(sname,pId,kindergartenName);
        if (salaryListList==null){
            return null;
        }
        PageInfo<SalaryList> pageInfo=new PageInfo<SalaryList>(salaryListList);
        return pageInfo;
    }

    //    @Override
//    public List<SalaryList> fileupload(MultipartFile file) throws IOException {
//        return null;
//    }
    //文件上传
    @Override
    public List<SalaryList> fileupload(String fileName, byte[] arr) throws IOException {
        ByteArrayInputStream inputStream= new ByteArrayInputStream(arr);
        Workbook wb = null;
        List<SalaryList> salaryListList = new ArrayList();
        if (isExcel2007(fileName)) {
            wb = new XSSFWorkbook(inputStream);
        } else {
            wb = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        Row titleRow=sheet.getRow(0);
        String titles="";
        for(int y=0; y<titleRow.getPhysicalNumberOfCells();y++){
            titles+=titleRow.getCell(y).getStringCellValue()+",";
        }
        titles = titles.substring(0,titles.length()-1);
        for (int i = 1; i <=sheet.getLastRowNum(); i++)
        {
            Row row = sheet.getRow(i);//获取索引为i的行，以0开始
            //    int y=row.getPhysicalNumberOfCells();
            if(row==null){
                continue;
            }
            String content="";
            int pId = (int) row.getCell(0).getNumericCellValue();
            if (pId==0)
            {
                break;
            }
            String sname=row.getCell(1).getStringCellValue();
//            Practitioner practitioner=practitionerMapper.checkSalay(pId,sname);
//            if(practitioner==null){
//                return null;
//            }
            int age = (int) row.getCell(2).getNumericCellValue();
            String sex=row.getCell(3).getStringCellValue();
            String kinderName=row.getCell(4).getStringCellValue();
            String salary = String.valueOf(row.getCell(5).getNumericCellValue());
            for(int y=6; y<row.getPhysicalNumberOfCells();y++){
                String value= String.valueOf(row.getCell(y).getNumericCellValue());
                if(value!=null){
                    content+=value+",";
                }
            }
            content = content.substring(0,content.length()-1);
            SalaryList salaryListVo=new SalaryList();
            salaryListVo.setSalary(salary);
            salaryListVo.setpId(pId);
            salaryListVo.setSname(sname);
            salaryListVo.setAge(age);
            salaryListVo.setSex(sex);
            salaryListVo.setKinderName(kinderName);
            salaryListVo.setContent(content);
            salaryListVo.setCreateDate(new Date());
            salaryListMapper.insertSelective(salaryListVo);
            salaryListList.add(salaryListVo);
            String[] strArray = null;
            int j=0;
            strArray = titles.split(",");
            String contents=salaryListVo.getContent();
            String[] strContetn=contents.split(",");
            int l=strArray.length;
            for(int z=6;z<l;z++){
                ParSlarList parSlarList =new ParSlarList();
                String conten=strArray[z];
                Float realWages=Float.parseFloat(strContetn[j]);
                parSlarList.setContent(conten);
                parSlarList.setCreateDate(new Date());
                parSlarList.setsId(salaryListVo.getId());
                parSlarList.setpId(salaryListVo.getpId());
                parSlarList.setRealWages(realWages);
                parSlarList.setState(0);
                parSlarList.setSign(0);
                parSlarListMapper.insertSelective(parSlarList);
                j++;
            }
        }
        try
        {
            wb.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        //上传文件
//        FtpUtil.uploadFile(host, port, username, password,basePath
//                , fileName, inputStream);
        //        String titles=ExcelUtil.getTitle(file);
        //将标题存入redis
        //        redisUtil.set("titles",titles);
        return salaryListList;

    }

    @Override
    public Kindergarten findById(Integer id) {
        return kindergartenMapper.selectByPrimaryKeyView(id);
    }

    @Override
    public String fileDownload(String fileName) {
        String loadPath="C:\\Users\\Administrator\\Desktop";
//        if(FtpUtil.downloadFile(host,port,username,password,basePath,fileName,loadPath)){
//            return "success";
//        }
        return "fall";
    }

    @Override
    public String getKname(Integer kindId) {
        return kindergartenMapper.selectgarById(kindId);
    }

    @Override
    public int editKinder(Kindergarten kindergarten, String date, String eduname, String legalName, Integer id) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        try {
            Date createdate=(Date)simpleDateFormat.parseObject(date);
            kindergarten.setCreateDate(createdate);
        } catch (ParseException e) {
            e.printStackTrace();
            return 1;
        }
        Education education=educationMapper.selectByName(eduname);
        if(education==null){
            return 3;
        }
        KinderLegal kinderLegal=kinderLegalMapper.selectByPrimaryKey(id);
        kinderLegal.setKlname(legalName);
        kinderLegal.setPhone(String.valueOf(kindergarten.getPhone()));
        kinderLegalMapper.updateByPrimaryKeySelective(kinderLegal);
        kindergarten.setLegalId(id);
        kindergarten.setEduId(education.geteId());
        kindergarten.setUrbanId(410100);
        kindergartenMapper.updateByPrimaryKeySelective(kindergarten);
        return 0;
    }

//    @Override
//    public void Upload(byte[] arr, long size, String fileType) {
//        ByteArrayInputStream inputStream= new ByteArrayInputStream(arr);
//        fastefsClient.uploFile(inputStream,size,fileType);
//    }


    @Override
    public void Upload(byte[] arr, long size, String fileType) {
    }

    @Override
    public int insertSelective(Kindergarten record, String date, String eduname, String legalName, Integer id) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        try {
            Date createdate=(Date)simpleDateFormat.parseObject(date);
            record.setCreateDate(createdate);
        } catch (ParseException e) {
            e.printStackTrace();
            return 1;
        }
        KinderLegal kinderLegal=kinderLegalMapper.selectByPrimaryKey(id);
        kinderLegal.setKlname(legalName);
        kinderLegal.setPhone(String.valueOf(record.getPhone()));
        kinderLegalMapper.updateByPrimaryKeySelective(kinderLegal);
        Education education=educationMapper.selectByName(eduname);
        if(education==null){
            return 3;
        }
        record.setLegalId(id);
        record.setEduId(education.geteId());
        record.setUrbanId(410100);
        kindergartenMapper.insertSelective(record);
        return 0;
    }




}
