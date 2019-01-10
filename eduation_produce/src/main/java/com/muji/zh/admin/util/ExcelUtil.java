package com.muji.zh.admin.util;

import com.muji.zh.admin.mapper.ParSlarListMapper;
import com.muji.zh.admin.mapper.SalaryListMapper;
import com.muji.zh.admin.model.ParSlarList;
import com.muji.zh.admin.model.SalaryList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/11/20/020.
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ExcelUtil
{
    @Autowired
    private static SalaryListMapper salaryListMapper;
    @Autowired
    private static ParSlarListMapper parSlarListMapper;
    public static void readExcel(MultipartFile file) throws IOException {

        //将文件读入
        InputStream in  = file.getInputStream();
        //创建工作簿
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        //获取第二行
        Row row = sheet.getRow(1);
        //循环读取科目
        for (int i = 1; i < 6; i++) {

            System.out.println(row.getCell(i).getAddress());
        }
    }
    public static boolean isExcel2003(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    public static List<SalaryList> importData(InputStream inputStream, String fileName) throws IOException {
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
            String content="";
            int id = (int) row.getCell(0).getNumericCellValue();//获取第i行的索引为0的单元格数据
            int pId = (int) row.getCell(1).getNumericCellValue();
            if (id==0 && pId==0)
            {
                break;
            }
            String sname=row.getCell(2).getStringCellValue();
            int age = (int) row.getCell(3).getNumericCellValue();
            String sex=row.getCell(4).getStringCellValue();
            String kinderName=row.getCell(5).getStringCellValue();
            for(int y=6; y<row.getPhysicalNumberOfCells();y++){
                String value= String.valueOf(row.getCell(y).getNumericCellValue());
                if(value!=null){
                    content+=value+",";
                }
            }
            content = content.substring(0,content.length()-1);
            SalaryList salaryListVo=new SalaryList();
            salaryListVo.setId(id);
            salaryListVo.setpId(pId);
            salaryListVo.setSname(sname);
            salaryListVo.setAge(age);
            salaryListVo.setSex(sex);
            salaryListVo.setKinderName(kinderName);
            salaryListVo.setContent(content);
            salaryListVo.setSalary("0");
            salaryListVo.setCreateDate(new Date());
            salaryListList.add(salaryListVo);
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
        return salaryListList;
    }
    public static List<ParSlarList> addpartList(SalaryList salaryList, String titles){
        String[] strArray = null;
        int j=0;
        strArray = titles.split(",");
        String contents=salaryList.getContent();
        String[] strContetn=contents.split(",");
        List<ParSlarList> parSlarLists=new ArrayList<>();
        for(int i=6;i<strArray.length;i++){
            ParSlarList parSlarList =new ParSlarList();
            String content=strArray[i];
            Float realWages=Float.parseFloat(strContetn[j]);
            parSlarList.setContent(content);
            parSlarList.setCreateDate(new Date());
            parSlarList.setpId(salaryList.getpId());
            parSlarList.setRealWages(realWages);
            parSlarList.setState(0);
            parSlarList.setSign(0);
            parSlarLists.add(parSlarList);
            j++;
        }
        return parSlarLists;
    }
    public static String getTitle(MultipartFile file){

        Workbook wb = null;
        List<SalaryList> salaryListList = new ArrayList();
        try
        {
            if (isExcel2007(file.getName())){
                wb = new XSSFWorkbook(file.getInputStream());
            } else {
                wb = new HSSFWorkbook(file.getInputStream());
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }

        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        Row titleRow=sheet.getRow(0);
        String titles="";
        for(int y=0; y<titleRow.getPhysicalNumberOfCells();y++){
            titles+=titleRow.getCell(y).getStringCellValue()+",";
        }
        titles = titles.substring(0,titles.length()-1);
        return titles;
    }
}
