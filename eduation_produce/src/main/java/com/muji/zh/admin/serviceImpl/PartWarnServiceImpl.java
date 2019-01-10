package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.PartWarnMapper;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.PartWarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class PartWarnServiceImpl implements PartWarnService {
    @Autowired
    private PartWarnMapper partWarnMapper;
    @Override
    public Map<String, Object> findWarnByArea(Integer areaId, List<Warning> warningList,Integer sign) {
        if (sign == 1) {
//            PartWarnExample example = new PartWarnExample();
//            // KindWarnExample.Criteria criteria=example.createCriteria();
//            PartWarnExample.Criteria criteria = example.createCriteria();

            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < warningList.size(); i++) {
                PartWarnExample example = new PartWarnExample();
                // KindWarnExample.Criteria criteria=example.createCriteria();
                PartWarnExample.Criteria criteria = example.createCriteria();
                criteria.andFlag2EqualTo(areaId + "");
                criteria.andWIdEqualTo(warningList.get(i).getId());
                List<PartWarn> list = partWarnMapper.selectByExample(example);
                map.put("warning" + warningList.get(i).getId(), list);
                map.put("wraningsize"+warningList.get(i).getId(),list.size()+"");
            }

            return map;
        }else {

            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < warningList.size(); i++) {


                PartWarnExample example = new PartWarnExample();
                // KindWarnExample.Criteria criteria=example.createCriteria();
                PartWarnExample.Criteria criteria = example.createCriteria();
                criteria.andFlag1EqualTo(areaId + "");
                criteria.andWIdEqualTo(warningList.get(i).getId());
                List<PartWarn> list = partWarnMapper.selectByExample(example);
                map.put("warning" + warningList.get(i).getId(), list);
                map.put("wraningsize"+warningList.get(i).getId(),list.size()+"");
            }

            return map;
        }
    }


    @Override
    public int deleteByExample(PartWarnExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PartWarn record) {
        return 0;
    }

    @Override
    public int insertSelective(PartWarn record) {
        return partWarnMapper.insertSelective(record);
    }

    @Override
    public List<PartWarn> findBySid(Integer id) {

        PartWarnExample example=new PartWarnExample();
        PartWarnExample.Criteria criteria=example.createCriteria();

        criteria.andPIdEqualTo(id);

        return partWarnMapper.selectByExample(example);
    }
}
