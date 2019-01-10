package com.muji.zh.admin.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.mapper.PaymentListMapper;
import com.muji.zh.admin.mapper.StuPayListMapper;
import com.muji.zh.admin.model.PaymentList;
import com.muji.zh.admin.model.PaymentListExample;
import com.muji.zh.admin.model.StuPayList;
import com.muji.zh.admin.service.PaymentListService;
import com.muji.zh.admin.util.FtpUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.muji.zh.admin.util.ExcelUtil.isExcel2007;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class PaymentListServiceImpl implements PaymentListService {

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
    @Autowired
    private PaymentListMapper paymentListMapper;
    @Autowired
    private StuPayListMapper stuPayListMapper;
    @Override
    public void insertImportPayList(List<PaymentList> list) {
        paymentListMapper.insertImportPayList(list);
    }

    @Override
    public PaymentList selectBySidAndSname(String pname, Integer sId) {

        PaymentListExample example=new PaymentListExample();
        PaymentListExample.Criteria criteria=example.createCriteria();
        criteria.andSIdEqualTo(sId);

        List<PaymentList> lists=  paymentListMapper.selectByExample(example);



        try {
            return lists.get(0);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public PaymentList findBy(Integer sid, Integer id) {


        PaymentListExample example=new PaymentListExample();
        PaymentListExample.Criteria criteria=example.createCriteria();

        criteria.andIdEqualTo(id);



        List<PaymentList> lists=  paymentListMapper.selectByExample(example);



        try {
            return lists.get(0);
        }catch (Exception e){
            return null;
        }
    }


    @Override
    public PaymentList selectByPrimaryKey(Integer id) {
        return paymentListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PaymentList record) {
        return paymentListMapper.updateByPrimaryKeySelective(record);
    }


























    @Override
    public PageInfo<PaymentList> findAllByKinderName(String kName, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<PaymentList> paymentListList=paymentListMapper.selectPartView(kName);
        PageInfo<PaymentList> pageInfo=new PageInfo<PaymentList>(paymentListList);
        return pageInfo;
    }

    @Override
    public List<PaymentList> fileUpload(String originalFilename, byte[] arr, String titles) throws IOException {
        ByteArrayInputStream inputStream= new ByteArrayInputStream(arr);
        Workbook wb = null;
        List<PaymentList> paymentListList=new ArrayList();
        if (isExcel2007(originalFilename)) {
            wb = new XSSFWorkbook(inputStream);
        } else {
            wb = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        for (int i = 1; i <=sheet.getLastRowNum(); i++)
        {
            Row row = sheet.getRow(i);//获取索引为i的行，以0开始
            if(row==null){
                continue;
            }
            //    int y=row.getPhysicalNumberOfCells();
            String content="";
            int sId = (int) row.getCell(0).getNumericCellValue();
            if (sId==0)
            {
                break;
            }
            String pname=row.getCell(1).getStringCellValue();
            String sex=row.getCell(2).getStringCellValue();
            String kinderName=row.getCell(3).getStringCellValue();
            String gradeName=row.getCell(4).getStringCellValue();
            String className=row.getCell(5).getStringCellValue();
            Float tuition=(float)row.getCell(6).getNumericCellValue();
            for(int y=7; y<row.getPhysicalNumberOfCells();y++){
                String value= String.valueOf(row.getCell(y).getNumericCellValue());
                if(value!=null){
                    content+=value+",";
                }
            }
            content = content.substring(0,content.length()-1);
            PaymentList paymentList=new PaymentList();
            paymentList.setsId(sId);
            paymentList.setClassName(className);
            paymentList.setSex(sex);
            paymentList.setPname(pname);
            paymentList.setCreateDate(new Date());
            paymentList.setTuition(tuition);
            paymentList.setContent(content);
            paymentList.setKindName(kinderName);
            paymentList.setGradeName(gradeName);
            paymentListMapper.insertSelective(paymentList);
            paymentListList.add(paymentList);
            String[] strArray = null;
            int j=0;
            strArray = titles.split(",");
            String contents=paymentList.getContent();
            String[] strContetn=contents.split(",");
            int l=strArray.length;
            for(int z=7;z<l;z++){
                StuPayList stuPayList=new StuPayList();
                String conten=strArray[z];
                Float realWa=Float.parseFloat(strContetn[j]);
                stuPayList.setContent(conten);
                stuPayList.setCreateDate(new Date());
                stuPayList.setpId(paymentList.getId());
                stuPayList.setsId(paymentList.getsId());
                stuPayList.setRealWa(realWa);
                stuPayListMapper.insertSelective(stuPayList);
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
//                , originalFilename, inputStream);
        return paymentListList;
    }

    @Override
    public PageInfo<PaymentList> choosePaymentList(Integer sId, String pname, String kindergartenName,int currentPage) {
        List<PaymentList> paymentListList=paymentListMapper.selectBypNameAndsId(pname,sId,kindergartenName);
        PageHelper.startPage(currentPage,5);
        PageInfo<PaymentList> pageInfo=new PageInfo<PaymentList>(paymentListList);
        return pageInfo;
    }
}
