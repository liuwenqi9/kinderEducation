package com.muji.zh.admin.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.mapper.KindergartenMapper;
import com.muji.zh.admin.mapper.PartLoginMapper;
import com.muji.zh.admin.mapper.PractitionerMapper;
import com.muji.zh.admin.mapper.StationMapper;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.ParentService;
import com.muji.zh.admin.service.PractitionerService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.muji.zh.admin.util.ExcelUtil.isExcel2007;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class PractitionerServiceImpl implements PractitionerService {


    @Autowired
    private PractitionerMapper practitionerMapper;

    @Autowired
    private KindergartenMapper kindergartenMapper;



    @Autowired
    private PartLoginMapper partLoginMapper;

    @Autowired
    private StationMapper stationMapper;

    @Override
    public long countByExample(PractitionerExample example) {
        return practitionerMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(PractitionerExample example) {
        return practitionerMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return practitionerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Practitioner record) {
        return practitionerMapper.insert(record);
    }

    @Override
    public int insertSelective(Practitioner record) {
        return practitionerMapper.insertSelective(record);
    }

    @Override
    public List<Practitioner> selectByExample(PractitionerExample example) {
        return practitionerMapper.selectByExample(example);
    }

    @Override
    public Practitioner selectByPrimaryKey(Integer id) {
        return practitionerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Practitioner record, PractitionerExample example) {
        return practitionerMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Practitioner record, PractitionerExample example) {
        return updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Practitioner record) {
        return practitionerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Practitioner record) {
        return practitionerMapper.updateByPrimaryKey(record);
    }


    @Override
    public Map<String, String> findByAreaIDToSex(Integer areaId, List<Station> list, String s, Integer sign) {
        if (sign == 1) {


            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                PractitionerExample example = new PractitionerExample();
                PractitionerExample.Criteria criteria = example.createCriteria();
                criteria.andSexEqualTo(s);
                criteria.andUbranIdEqualTo(areaId);
                criteria.andPIdEqualTo(list.get(i).getsId());
                Long sum = practitionerMapper.countByExample(example);

                map.put("part_" + list.get(i).getsId(), sum + "");
            }
            System.out.println(map);
            return map;
        } else {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                PractitionerExample example = new PractitionerExample();
                PractitionerExample.Criteria criteria = example.createCriteria();
                criteria.andSexEqualTo(s);
                criteria.andAreaIdEqualTo(areaId);
                criteria.andPIdEqualTo(list.get(i).getsId());
                Long sum = practitionerMapper.countByExample(example);

                map.put("part_" + list.get(i).getsId(), sum + "");
            }
            System.out.println(map);
            return map;
        }
    }

    @Override
    public Map<String, String> findByAreaIDToSexTotal(Integer areaId, List<Station> list, Integer sign) {


        if (sign == 1) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                PractitionerExample example = new PractitionerExample();
                PractitionerExample.Criteria criteria = example.createCriteria();
                //criteria.andSexEqualTo(s);
                criteria.andUbranIdEqualTo(areaId);
                criteria.andPIdEqualTo(list.get(i).getsId());
                Long sum = practitionerMapper.countByExample(example);

                map.put("part_total" + list.get(i).getsId(), sum + "");
            }
            System.out.println(map);
            return map;
        } else {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                PractitionerExample example = new PractitionerExample();
                PractitionerExample.Criteria criteria = example.createCriteria();
                //criteria.andSexEqualTo(s);
                criteria.andAreaIdEqualTo(areaId);
                criteria.andPIdEqualTo(list.get(i).getsId());
                Long sum = practitionerMapper.countByExample(example);

                map.put("part_total" + list.get(i).getsId(), sum + "");
            }
            System.out.println(map);
            return map;
        }
    }

    @Override
    public int findCertificateYes(Integer areaId, int typeid, Integer sign) {
        if (sign == 1) {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andUbranIdEqualTo(areaId);
            criteria.andPIdEqualTo(typeid);
            criteria.andCertificateIsNotNull();
            return (int) practitionerMapper.countByExample(example);
        } else {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andAreaIdEqualTo(areaId);
            criteria.andPIdEqualTo(typeid);
            criteria.andCertificateIsNotNull();
            return (int) practitionerMapper.countByExample(example);
        }

    }

    @Override
    public int findCertificateTotal(Integer areaId, int typeid, Integer sign) {
        if (sign == 1) {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andUbranIdEqualTo(areaId);
            criteria.andPIdEqualTo(typeid);

            return (int) practitionerMapper.countByExample(example);
        } else {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andAreaIdEqualTo(areaId);
            criteria.andPIdEqualTo(typeid);
            return (int) practitionerMapper.countByExample(example);
        }

    }


    public Map<String, Object> findByKid(Integer kid, String sex, List<Station> stationList) {

        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < stationList.size(); i++) {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();

            criteria.andSexEqualTo(sex);
            criteria.andKinderIdEqualTo(kid);
            criteria.andPIdEqualTo(stationList.get(i).getsId());


            Long cont = practitionerMapper.countByExample(example);


            map.put("count" + i, cont);

        }


        return map;
    }

    @Override
    public long findByQs(String flag1, Integer kid, String type) {

        if (flag1.equals("2")) {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();


            criteria.andKinderIdEqualTo(kid);
            criteria.andPIdEqualTo(Integer.parseInt(type));
            criteria.andCertificateIsNotNull();


            Long cont = practitionerMapper.countByExample(example);





            return cont;

        }
        else {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();


            criteria.andKinderIdEqualTo(kid);
            criteria.andPIdEqualTo(Integer.parseInt(type));
            criteria.andCertificateIsNull();


            Long cont = practitionerMapper.countByExample(example);
            return cont;
        }


    }


    @Override
    public PageInfo<Practitioner> findByLikeName(String kinderName, String studentname, String phone, EduUser eduUser, Integer pn) {

        int i = 0;
        Integer pagesize = 7;
        PageHelper.startPage(pn, pagesize);
        String b = null;
        Integer c = null;
        System.out.println(eduUser);
        System.out.println(studentname);
        if (studentname != null) {


            boolean isNum = studentname.matches("[0-9]+");
            System.out.println(isNum);
            if (isNum) {
                PageHelper.startPage(pn, pagesize);
                List<Practitioner> list = practitionerMapper.findByLikeName(kinderName, Integer.parseInt(studentname), b, phone, eduUser.getSign(), eduUser.getAreaId());
                List<Practitioner> practitionerList = new ArrayList<>();

                for (int j = 0; j < list.size(); j++) {
                    Practitioner practitioner = new Practitioner();
                    practitioner = list.get(j);
                    list.get(j).setEmail(kindergartenMapper.selectByPrimaryKey(practitioner.getKinderId()).getKname());
                    list.get(j).setFalg1(stationMapper.selectByPrimaryKey(practitioner.getpId()).getSname());

                }

                PageInfo<Practitioner> info = new PageInfo<Practitioner>(list);


                return info;
            } else {
                PageHelper.startPage(pn, pagesize);
                List<Practitioner> list = practitionerMapper.findByLikeName(kinderName, c, studentname, phone, eduUser.getSign(), eduUser.getAreaId());

                for (int j = 0; j < list.size(); j++) {
                    Practitioner practitioner = new Practitioner();
                    practitioner = list.get(j);
                   try {
                       practitioner.setEmail(kindergartenMapper.selectByPrimaryKey(practitioner.getKinderId()).getKname());
                   }catch (Exception e)
                   {
                       e.printStackTrace();
                   }
                    practitioner.setFalg1(stationMapper.selectByPrimaryKey(practitioner.getpId()).getSname());

                }

                PageInfo<Practitioner> info = new PageInfo<Practitioner>(list);
                return info;
            }
        } else {
            PageHelper.startPage(pn, pagesize);
            List<Practitioner> list = practitionerMapper.findByLikeName(kinderName, c, studentname, phone, eduUser.getSign(), eduUser.getAreaId());

            for (int j = 0; j < list.size(); j++) {
                Practitioner practitioner = new Practitioner();
                practitioner = list.get(j);
                practitioner.setEmail(kindergartenMapper.selectByPrimaryKey(practitioner.getKinderId()).getKname());
                practitioner.setFalg1(stationMapper.selectByPrimaryKey(practitioner.getpId()).getSname());

            }
            PageInfo<Practitioner> info = new PageInfo<Practitioner>(list);
            return info;
        }


    }

    @Override
    public List<Practitioner> findByKidToPract(Integer getkId) {
        PractitionerExample example = new PractitionerExample();
        PractitionerExample.Criteria criteria = example.createCriteria();
        //criteria.andSexEqualTo(s);
        criteria.andKinderIdEqualTo(getkId);

        return practitionerMapper.selectByExample(example);
    }

    @Override
    public long countTotal(EduUser eduUser) {
        if (eduUser.getSign() == 1) {

            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andUbranIdEqualTo(eduUser.getAreaId());
            criteria.andPIdEqualTo(2);


            return practitionerMapper.countByExample(example);
        } else {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andAreaIdEqualTo(eduUser.getAreaId());
            criteria.andPIdEqualTo(2);
            return practitionerMapper.countByExample(example);
        }
    }

    @Override
    public Map<String, Long> findCountBY(Integer getkId, List<Station> stationList) {

        Map<String, Long> map = new HashMap<>();

        for (int i = 0; i < stationList.size(); i++) {

            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andKinderIdEqualTo(getkId);
            criteria.andPIdEqualTo(stationList.get(i).getsId());

            Long s = practitionerMapper.countByExample(example);

            map.put("cont" + i, s);


        }


        return map;
    }


    @Override
    public List<Practitioner> findAll() {
        PractitionerExample example = new PractitionerExample();
        PractitionerExample.Criteria criteria = example.createCriteria();
        //criteria.andSexEqualTo(s);

        return practitionerMapper.selectByExample(example);
    }

    @Override
    public Integer countByKid(Integer kid) {

        PractitionerExample example = new PractitionerExample();
        PractitionerExample.Criteria criteria = example.createCriteria();
        criteria.andKinderIdEqualTo(kid);

        return practitionerMapper.selectByExample(example).size();

    }


    @Override
    public Map<String, Object> findPart(Integer kid, List<Station> stationList) {
        Map<String,Object> map=new HashMap<>();
        for(int i=0;i<stationList.size();i++)
        {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            criteria.andKinderIdEqualTo(kid);
            criteria.andPIdEqualTo(stationList.get(i).getsId());

            Long count=practitionerMapper.countByExample(example);

            map.put("count"+i,count);

        }
        return map;
    }




















    @Override
    public List<ParentService> findByLikeName(String kinderName, Integer id, String studentnmae) {
        return null;
    }

    @Override
    public Map<String, String> findByAreaIDToSex(Integer areaId, List<Station> list, String s) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            criteria.andSexEqualTo(s);
            criteria.andUbranIdEqualTo(areaId);
            criteria.andPIdEqualTo(list.get(i).getsId());
            Long sum = practitionerMapper.countByExample(example);

            map.put("part_"+list.get(i).getsId(),sum+"");
        }
        System.out.println(map);
        return map;

    }
    @Override
    public Map<String, String> findByAreaIDToSexTotal(Integer areaId, List<Station> list) {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            PractitionerExample example = new PractitionerExample();
            PractitionerExample.Criteria criteria = example.createCriteria();
            //criteria.andSexEqualTo(s);
            criteria.andUbranIdEqualTo(areaId);
            criteria.andPIdEqualTo(list.get(i).getsId());
            Long sum = practitionerMapper.countByExample(example);

            map.put("part_total"+list.get(i).getsId(),sum+"");
        }
        System.out.println(map);
        return map;
    }

    @Override
    public int findCertificateYes(Integer areaId, int typeid) {
        PractitionerExample example = new PractitionerExample();
        PractitionerExample.Criteria criteria = example.createCriteria();
        //criteria.andSexEqualTo(s);
        criteria.andUbranIdEqualTo(areaId);
        criteria.andPIdEqualTo(typeid);
        criteria.andCertificateIsNotNull();
        return (int) practitionerMapper.countByExample(example);
    }

    @Override
    public int findCertificateTotal(Integer areaId, int typeid) {
        PractitionerExample example = new PractitionerExample();
        PractitionerExample.Criteria criteria = example.createCriteria();
        //criteria.andSexEqualTo(s);
        criteria.andUbranIdEqualTo(areaId);
        criteria.andPIdEqualTo(typeid);

        return (int) practitionerMapper.countByExample(example);
    }

    @Override
    public List<Practitioner> findPraList(Integer kindId) {
        List<Practitioner> practitionerList=practitionerMapper.findBykinId(kindId);
        return practitionerList;
    }

    @Override
    public List<Practitioner> choosePra(String pname, String phone, Integer kindId) {
        return practitionerMapper.selectBypNameAndphone(pname,phone,kindId);
    }

    @Override
    public int fileupload(String originalFilename, byte[] arr, KinderLegal kinderLegal) throws IOException {
        ByteArrayInputStream inputStream= new ByteArrayInputStream(arr);
        Workbook wb = null;
        List<SalaryList> salaryListList = new ArrayList();
        if (isExcel2007(originalFilename)) {
            wb = new XSSFWorkbook(inputStream);
        } else {
            wb = new HSSFWorkbook(inputStream);
        }
        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        int j=sheet.getLastRowNum();
        for (int i = 1; i <=j; i++)
        {
            Row row = sheet.getRow(i);//获取索引为i的行，以0开始
            if(row==null){
                continue;
            }
            //    int y=row.getPhysicalNumberOfCells();
            int id = (int) row.getCell(0).getNumericCellValue();
            Practitioner check=practitionerMapper.selectByPrimaryKey(id);
            PartLogin partLogins=partLoginMapper.selectByPrimaryKey(id);
            if (id==0||check!=null||partLogins!=null)
            {
                return 2;
            }
            String pname=row.getCell(1).getStringCellValue();
            int isboss = (int) row.getCell(2).getNumericCellValue();
            //岗位
            String sname = row.getCell(3).getStringCellValue();
            int wages = (int) row.getCell(4).getNumericCellValue();
            Integer pId=stationMapper.getSid(sname);
            if(pId==null){
                return 3;
            }
            PartLogin partLogin=new PartLogin();
            partLogin.setId(id);
            partLogin.setPassword(String.valueOf(id));
            partLoginMapper.insertSelective(partLogin);
            Practitioner practitioner=new Practitioner();
            practitioner.setId(id);
            practitioner.setPname(pname);
            practitioner.setAreaId(kinderLegal.getAreaId());
            practitioner.setKinderId(kinderLegal.getKindId());
            practitioner.setLegalPerson(String.valueOf(kinderLegal.getId()));
            practitioner.setLegalParsonName(kinderLegal.getKlname());
            practitioner.setLegalParsonPhone(kinderLegal.getPhone());
            practitioner.setWages(wages);
            practitioner.setpId(pId);
            practitioner.setClasDirector(isboss);
            practitionerMapper.insertSelective(practitioner);
        }
        try
        {
            wb.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    @Override
    public PageInfo<PraVo> getPraVoList(Integer id, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<PraVo> praVoList=practitionerMapper.selectPraVo(id);
        PageInfo<PraVo> pageInfo= new PageInfo<PraVo>(praVoList);
        return pageInfo;
    }

    @Override
    public long getCount(Integer kindId) {
        return practitionerMapper.selectCount(kindId);
    }

    @Override
    public boolean deletePra(Integer id) {
        Practitioner practitioner=practitionerMapper.selectByPrimaryKey(id);
        if(practitioner!=null){
            practitionerMapper.deleteByPrimaryKey(id);
            return true;
        }
        return false;
    }

    @Override
    public Practitioner findById(Integer cId) {
        return practitionerMapper.selectByPrimaryKey(cId);
    }

    @Override
    public boolean update(Practitioner practitioner) {
        Practitioner practitioner1=practitionerMapper.selectByPrimaryKey(practitioner.getId());
        if(practitioner1!=null){
            practitionerMapper.updateByPrimaryKeySelective(practitioner);
            return true;
        }
        return false;
    }

    @Override
    public void praInster(Practitioner practitioner) {
        PartLogin partLogin=new PartLogin();
        partLogin.setId(practitioner.getId());
        partLogin.setPassword(String.valueOf(practitioner.getId()));
        partLoginMapper.insertSelective(partLogin);
        practitionerMapper.insertSelective(practitioner);
    }

    @Override
    public PageInfo<PraVo> checkPra(Integer kindId, String pname, int currentPage) {
        PageHelper.startPage(1,5);
        List<PraVo> praVoList=practitionerMapper.checkPra(kindId, pname);
        PageInfo<PraVo> pageInfo= new PageInfo<PraVo>(praVoList);
        return pageInfo;
    }

    @Override
    public long checkCount(Integer id,String pname) {
        return practitionerMapper.checkCount(id,pname);
    }
}
