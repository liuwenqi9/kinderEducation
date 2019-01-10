package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.KinderLegalMapper;
import com.muji.zh.admin.model.KinderLegal;
import com.muji.zh.admin.service.KinderLegalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/11/13/013.
 */

@Service
@com.alibaba.dubbo.config.annotation.Service
public class KinderLegalServiceImpl implements KinderLegalService {
    @Autowired
    private KinderLegalMapper kinderLegalMapper;
    @Override
    public KinderLegal login(Integer id, String password) {
        return kinderLegalMapper.selectByklnameAndpassword(id,password);
    }

    @Override
    public void updatePassword(KinderLegal kinderLegal) {
        kinderLegalMapper.updateByPrimaryKeySelective(kinderLegal);
    }











    @Override
    public List<KinderLegal> findAll() {
        return kinderLegalMapper.findAll();
    }

    public KinderLegal findById(Integer id) {
        return kinderLegalMapper.selectByPrimaryKey(id);
    }
}
