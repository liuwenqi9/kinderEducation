package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.PartWinRecordMapper;
import com.muji.zh.admin.model.PartWinRecord;
import com.muji.zh.admin.model.PartWinRecordExample;
import com.muji.zh.admin.service.PartWinRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class PartWinRecordServiceImpl implements PartWinRecordService {
    @Autowired
    private PartWinRecordMapper partWinRecordMapper;
    @Override
    public List<PartWinRecord> FindByPid(Integer id) {
        PartWinRecordExample example=new PartWinRecordExample();
        PartWinRecordExample.Criteria criteria=example.createCriteria();
        return partWinRecordMapper.selectByExample(example);
    }
}
