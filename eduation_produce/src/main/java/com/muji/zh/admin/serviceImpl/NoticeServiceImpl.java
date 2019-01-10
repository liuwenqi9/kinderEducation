package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.NoticeMapper;
import com.muji.zh.admin.mapper.NoticeTypeMapper;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class NoticeServiceImpl implements NoticeService
{
    @Autowired
    private NoticeTypeMapper noticeTypeMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public long countByExample(NoticeExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(NoticeExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Notice record) {
        return 0;
    }

    @Override
    public int insertSelective(Notice record) {
        return noticeMapper.insertSelective(record);
    }

    @Override
    public List<Notice> selectByExample(NoticeExample example) {
        return null;
    }

    @Override
    public Notice selectByPrimaryKey(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Notice record, NoticeExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Notice record, NoticeExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Notice record) {
        return noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return 0;
    }

    @Override
    public List<NoticeType> distinctName() {
        NoticeTypeExample example=new NoticeTypeExample();
        return noticeTypeMapper.selectByExample(example);

    }


    @Override
    public Notice findBy(int i, Integer epId) {
        NoticeExample example=new NoticeExample();
        NoticeExample.Criteria criteria=example.createCriteria();
        criteria.andNnameEqualTo(i+"");
        criteria.andWhoIdEqualTo(epId);
        List<Notice> list=  noticeMapper.selectByExample(example);

        try {
            return list.get(0);
        }catch (Exception e){
            
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notice> findByParent(Parent parent,String area_id) {
        NoticeExample example=new NoticeExample();
        NoticeExample.Criteria criteria=example.createCriteria();




        criteria.andAimLike("2");
        criteria.andNnameEqualTo("0");
        criteria.andAreaIdEqualTo(area_id);
        criteria.andSignEqualTo(2);

        return noticeMapper.selectByExample(example);
    }


    @Override
    public List<Notice> selectByAimAndSign() {
        return noticeMapper.selectByAimAndSign();
    }





    @Override
    public List<Notice> findKinderNotice(Integer areaId) {
        List<Notice> noticeList=noticeMapper.findKinderNotice(areaId);
        List<Notice> list=new ArrayList<Notice>();
        for(Notice notice:noticeList){
            String aim=notice.getAim();
            String[] strArray = null;
            strArray = aim.split(",");
            for (String a:strArray){
                if(a.equals("4")){
                    list.add(notice);
                }
            }
        }
        return list;
    }
}
