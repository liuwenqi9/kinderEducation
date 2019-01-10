package com.muji.zh.admin.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.mapper.ClasMapper;
import com.muji.zh.admin.mapper.ClassTypeMapper;
import com.muji.zh.admin.mapper.PractitionerMapper;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.ClasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@com.alibaba.dubbo.config.annotation.Service

public class ClasServiceImpl implements ClasService {
    @Autowired
    private ClasMapper clasMapper;


    @Autowired
    private ClassTypeMapper classTypeMapper;



    @Autowired
    private PractitionerMapper practitionerMapper;


    @Override
    public long countByExample(ClasExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ClasExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer cId) {
        return 0;
    }

    @Override
    public int insert(Clas record) {
        return 0;
    }

    @Override
    public int insertSelective(Clas record) {
        return 0;
    }

    @Override
    public List<Clas> selectByExample(ClasExample example) {
        return null;
    }

    @Override
    public Clas selectByPrimaryKey(Integer cId) {
        return clasMapper.selectByPrimaryKey(cId);
    }

    @Override
    public int updateByExampleSelective(Clas record, ClasExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Clas record, ClasExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Clas record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Clas record) {
        return 0;
    }


    @Override
    public Map<String, String> findBySex(Integer areaId, List<ClassType> typeList, String sex) {
        return null;
    }

    @Override
    public List<List<Clas>> findBy(Integer areaId, List<ClassType> typeList, Integer sign) {
        if (sign == 1) {
            HashMap<String, String> map = new HashMap<>();
            List<List<Clas>> clasList = new ArrayList<>();
            ClasExample clasExample = new ClasExample();
            ClasExample.Criteria criteria = clasExample.createCriteria();
            for (int i = 0; i < typeList.size(); i++) {

                criteria.andFlag2EqualTo(areaId + "");
                criteria.andCTypeEqualTo(typeList.get(i).getCtId());
                clasList.add(i, clasMapper.selectByExample(clasExample));

            }
            return clasList;
        } else {
            HashMap<String, String> map = new HashMap<>();
            List<List<Clas>> clasList = new ArrayList<>();
            for (int i = 0; i < typeList.size(); i++) {
                ClasExample clasExample = new ClasExample();
                ClasExample.Criteria criteria = clasExample.createCriteria();
                criteria.andFlag1EqualTo(areaId + "");
                criteria.andCTypeEqualTo(typeList.get(i).getCtId());
                clasList.add(i, clasMapper.selectByExample(clasExample));

            }
            return clasList;
        }


    }

    @Override
    public List<Clas> findByToKid(int parseInt) {

        ClasExample clasExample = new ClasExample();
        ClasExample.Criteria criteria = clasExample.createCriteria();
        criteria.andKidEqualTo(parseInt);
        return  clasMapper.selectByExample(clasExample);
    }




    @Override
    public Long countToClas(Integer getkId) {
        ClasExample clasExample = new ClasExample();
        ClasExample.Criteria criteria = clasExample.createCriteria();
        criteria.andKidEqualTo(getkId);
        return  clasMapper.countByExample(clasExample);
    }







    @Override
    public  List<List<Clas>> findBy(Integer areaId, List<ClassType> typeList) {
        HashMap<String, String> map = new HashMap<>();
        List<List<Clas>> clasList=new ArrayList<>();
        for (int i = 0; i < typeList.size(); i++) {
            ClasExample clasExample = new ClasExample();
            ClasExample.Criteria criteria = clasExample.createCriteria();
            criteria.andFlag2EqualTo(areaId + "");
            criteria.andCTypeEqualTo(typeList.get(i).getCtId());
            clasList.add(i,clasMapper.selectByExample(clasExample));

        }
        return  clasList;

    }


    @Override
    public PageInfo<ClassVo> selectClass(Integer kindId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<ClassVo> classVoList=clasMapper.selectClassVo(kindId);
        PageInfo<ClassVo> pageInfo=new PageInfo<ClassVo>(classVoList);
        return pageInfo;
    }


    @Override
    public long selectCount(Integer kindId) {
        return clasMapper.selectCount(kindId);
    }

    @Override
    public boolean deleteClass(Integer id) {
        Clas clas=clasMapper.selectByPrimaryKey(id);
        if(clas!=null){
            clasMapper.deleteByPrimaryKey(id);
            return true;
        }
        return false;
    }

    @Override
    public Clas findById(Integer cId) {
        return clasMapper.selectByPrimaryKey(cId);
    }

    @Override
    public List<ClassType> getClassType() {
        return classTypeMapper.findAll();
    }

    @Override
    public List<Practitioner> findPractitionerList(Integer kid) {
        return practitionerMapper.findClasPra(kid);
    }

    @Override
    public int update(Clas clas) {
        Clas clas1=clasMapper.selectByPrimaryKey(clas.getcId());
        if(clas1==null){
            return 1;
        }else{
            Clas clas2=clasMapper.UpdateCheckBypId(clas.getpId(),clas1.getcId());
            if(clas2!=null){
                return 2;
            }
            Clas clas3=clasMapper.UpdateCheckByCname(clas.getCname(),clas1.getcId());
            if(clas3!=null){
                return 3;
            }
        }
        clasMapper.updateByPrimaryKeySelective(clas);
        return 0;
    }

    @Override
    public int insterClass(Clas clas) {
        Clas clas1=clasMapper.selectBypId(clas.getpId());
        if(clas1!=null){
            return 1;
        }
        Clas clas2=clasMapper.selectByCname(clas.getCname());
        if(clas2!=null){
            return 2;
        }
        clasMapper.insertSelective(clas);
        return 0;
    }

    @Override
    public PageInfo<ClassVo> selectClassByName(Integer kindId, String cname,int currentPage) {
        PageHelper.startPage(currentPage,5);
        List<ClassVo> classVoList=clasMapper.checkClassVo(kindId,cname);
        PageInfo<ClassVo> pageInfo=new PageInfo<ClassVo>(classVoList);
        return pageInfo;
    }

    @Override
    public long checkCount(Integer kindId, String cname) {
        return clasMapper.checkCount(kindId,cname);
    }


}
