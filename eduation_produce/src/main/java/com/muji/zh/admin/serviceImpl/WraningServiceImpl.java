package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.WarningMapper;
import com.muji.zh.admin.model.Warning;
import com.muji.zh.admin.model.WarningExample;
import com.muji.zh.admin.service.WraningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class WraningServiceImpl implements WraningService {
    @Autowired
    private WarningMapper warningMapper;
    @Override
    public List<Warning> findAll() {
        WarningExample example=new WarningExample();
        return warningMapper.selectByExample(example);
    }
}
