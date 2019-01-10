package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.StuWinRecordMapper;
import com.muji.zh.admin.model.StuWinRecord;
import com.muji.zh.admin.model.StuWinRecordExample;
import com.muji.zh.admin.service.StuWinRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class StuWinRecordServiceImpl implements StuWinRecordService {
    @Autowired
    private StuWinRecordMapper stuWinRecordMapper;
    @Override
    public List<StuWinRecord> findBySid(Integer id) {
        StuWinRecordExample stuWinRecordExample=new StuWinRecordExample();
        StuWinRecordExample.Criteria criteria=stuWinRecordExample.createCriteria();
        criteria.andSidEqualTo(id);

       List <StuWinRecord> list=stuWinRecordMapper.selectByExample(stuWinRecordExample);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        for (int i=0;i<list.size();i++)
        {
            String s=simpleDateFormat.format(list.get(i).getDate());

            list.get(i).setFlag1(s);

        }
        return list;
    }


    @Override
    public long countByExample(StuWinRecordExample example) {
        return stuWinRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return stuWinRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(StuWinRecord record) {
        return stuWinRecordMapper.insertSelective(record);
    }

    @Override
    public List<StuWinRecord> selectByExample(StuWinRecordExample example) {
        return stuWinRecordMapper.selectByExample(example);
    }

    @Override
    public int updateByPrimaryKeySelective(StuWinRecord record) {
        return stuWinRecordMapper.updateByPrimaryKeySelective(record);
    }
}
