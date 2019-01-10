package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.KindWarnMapper;
import com.muji.zh.admin.model.KindWarn;
import com.muji.zh.admin.model.KindWarnExample;
import com.muji.zh.admin.model.Warning;
import com.muji.zh.admin.service.KindWarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class KindWarnServiceImpl implements KindWarnService {

    @Autowired
    private KindWarnMapper kindWarnMapper;
    @Override
    public Map<String, Object> findWarnByArea(Integer areaId, List<Warning> warningList,Integer sign) {
        if(sign==1)
        {

            Map<String ,Object> map=new HashMap<>();
            for (int i=0;i<warningList.size();i++)
            {
                KindWarnExample example=new KindWarnExample();
                KindWarnExample.Criteria criteria=example.createCriteria();
                criteria.andFlag1EqualTo(areaId+"");
                criteria.andWIdEqualTo(warningList.get(i).getId());
                List<KindWarn> list=kindWarnMapper.selectByExample(example);
                map.put("warning"+warningList.get(i).getId(),list);
                map.put("wraningsize"+warningList.get(i).getId(),list.size()+"");
            }

            return map;
        }else{

            Map<String ,Object> map=new HashMap<>();
            for (int i=0;i<warningList.size();i++)
            {
                KindWarnExample example=new KindWarnExample();
                KindWarnExample.Criteria criteria=example.createCriteria();

                criteria.andAreaIdEqualTo(areaId+"");
                criteria.andWIdEqualTo(warningList.get(i).getId());
                List<KindWarn> list=kindWarnMapper.selectByExample(example);
                map.put("warning"+warningList.get(i).getId(),list);
                map.put("wraningsize"+warningList.get(i).getId(),list.size()+"");
            }

            return map;
        }


    }

    @Override
    public Map<String,Object> findByKid(Integer kid,List<Warning> warningList) {
        Map<String,Object>map=new HashMap<>();
        for(int i=0;i<warningList.size();i++)
        {
            KindWarnExample example=new KindWarnExample();
            KindWarnExample.Criteria criteria=example.createCriteria();
            criteria.andKIdEqualTo(kid);
            criteria.andWIdEqualTo(warningList.get(i).getId());

            List<KindWarn> list=kindWarnMapper.selectByExample(example);
            map.put("warning"+warningList.get(i).getId(),list);
            map.put("wraningsize"+warningList.get(i).getId(),list.size()+"");
        }
        return map;


        //return kindWarnMapper.selectByExample(example);

    }

    @Override
    public int deleteByPrimaryKey(Integer id) {


        return 0;
    }

    @Override
    public int insert(KindWarn record) {
        return 0;
    }

    @Override
    public int insertSelective(KindWarn record) {
        return kindWarnMapper.insertSelective(record);
    }
}
