package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.ComplaintMapper;
import com.muji.zh.admin.model.Complaint;
import com.muji.zh.admin.model.ComplaintExample;
import com.muji.zh.admin.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public long countByExample(ComplaintExample example) {
        return complaintMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ComplaintExample example) {
        return complaintMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return complaintMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Complaint record) {
        return complaintMapper.insert(record);
    }

    @Override
    public int insertSelective(Complaint record) {
        return complaintMapper.insertSelective(record);
    }

    @Override
    public List<Complaint> selectByExample(ComplaintExample example) {
        return complaintMapper.selectByExample(example);
    }

    @Override
    public Complaint selectByPrimaryKey(Integer id) {
        return complaintMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Complaint record, ComplaintExample example) {
        return complaintMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Complaint record, ComplaintExample example) {
        return complaintMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Complaint record) {
        return complaintMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Complaint record) {
        return complaintMapper.updateByPrimaryKey(record);
    }

    @Override
    public Map<String, Object> findBY(Integer areaId, Integer sign) throws ParseException {
        if (sign == 1) {
            Map<String, Object> map = new HashMap<>();
            List<Complaint> list = complaintMapper.findBy(areaId);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < list.size(); i++) {
                String s = simpleDateFormat.format(list.get(i).getCreateDate());
                Date d = simpleDateFormat.parse(s);
                list.get(i).setCreateDate(d);
                list.get(i).setFlag1(s);

            }
            List<Complaint> complaints = complaintMapper.findByPartCom(areaId);

            for (int i = 0; i < complaints.size(); i++) {
                String s = simpleDateFormat.format(complaints.get(i).getCreateDate());
                Date d = simpleDateFormat.parse(s);
                complaints.get(i).setCreateDate(d);
                complaints.get(i).setFlag1(s);

            }


            //map.put("complaint", list);

            //list.addAll(complaints);
            map.put("complaintParent", list);
            map.put("complaints", complaints);
            map.put("comlistsizesS", list.size());
            map.put("comlistsizesP", complaints.size());


            return map;
        } else {
            Map<String, Object> map = new HashMap<>();
            List<Complaint> list = complaintMapper.findByAreaId(areaId);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (int i = 0; i < list.size(); i++) {
                String s = simpleDateFormat.format(list.get(i).getCreateDate());
                Date d = simpleDateFormat.parse(s);
                list.get(i).setCreateDate(d);
                list.get(i).setFlag1(s);

            }
            List<Complaint> complaints = complaintMapper.findByPartComAreaId(areaId);


            for (int i = 0; i < complaints.size(); i++) {
                String s = simpleDateFormat.format(complaints.get(i).getCreateDate());
                Date d = simpleDateFormat.parse(s);
                complaints.get(i).setCreateDate(d);
                complaints.get(i).setFlag1(s);

            }
            map.put("complaintParent", list);
            map.put("complaints", complaints);
            map.put("comlistsizesS", list.size());
            map.put("comlistsizesP", complaints.size());
            return map;
        }


    }

    @Override
    public Map<String, Object> findByKid(Integer kid) throws ParseException {
        Map<String, Object> map = new HashMap<>();
        List<Complaint> list = complaintMapper.findByKidToParent(kid);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < list.size(); i++) {
            String s = simpleDateFormat.format(list.get(i).getCreateDate());
            Date d = simpleDateFormat.parse(s);
            list.get(i).setCreateDate(d);
            list.get(i).setFlag1(s);
        }
        List<Complaint> complaints = complaintMapper.findByKidToPractioner(kid);


        for (int i = 0; i < complaints.size(); i++) {
            String s = simpleDateFormat.format(complaints.get(i).getCreateDate());
            Date d = simpleDateFormat.parse(s);
            complaints.get(i).setCreateDate(d);
            complaints.get(i).setFlag1(s);

        }


        map.put("complaintParent", list);
        map.put("complaints", complaints);
        map.put("comlistsizesS", list.size());
        map.put("comlistsizesP", complaints.size());
        return map;
    }

    @Override
    public List<Complaint> findByPidBeOid(Integer id) throws ParseException {
        ComplaintExample complaintExample = new ComplaintExample();
        ComplaintExample.Criteria criteria = complaintExample.createCriteria();
        criteria.andOIdEqualTo(id);
        //complaintMapper.selectByExample(complaintExample);
        List<Complaint> list = complaintMapper.selectByExample(complaintExample);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < list.size(); i++) {
            String s = simpleDateFormat.format(list.get(i).getCreateDate());
            Date d = simpleDateFormat.parse(s);
            list.get(i).setCreateDate(d);
            list.get(i).setFlag1(s);
        }
        return list;
    }

    @Override
    public List<Complaint> findByFromWhoId(Integer id) throws ParseException {
        ComplaintExample complaintExample = new ComplaintExample();
        complaintExample.setOrderByClause("create_date DESC");
        ComplaintExample.Criteria criteria = complaintExample.createCriteria();
        criteria.andWhoIdEqualTo(id);
        //complaintMapper.selectByExample(complaintExample);
        List<Complaint> list = complaintMapper.selectByExample(complaintExample);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < list.size(); i++) {
            String s = simpleDateFormat.format(list.get(i).getCreateDate());
            Date d = simpleDateFormat.parse(s);
            list.get(i).setCreateDate(d);
            list.get(i).setFlag1(s);
        }
        return list;
    }

    @Override
    public List<Complaint> findByFromWhoIdFlags(Integer pid, String flag1) {
        ComplaintExample complaintExample = new ComplaintExample();

        complaintExample.setOrderByClause("create_date DESC");
        ComplaintExample.Criteria criteria = complaintExample.createCriteria();
        criteria.andWhoIdEqualTo(pid);
        criteria.andFlag1EqualTo(flag1);

       List<Complaint> list= complaintMapper.selectByExample(complaintExample);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        for (int i=0;i<list.size();i++)
        {
            String s=simpleDateFormat.format(list.get(i).getCreateDate());

            list.get(i).setFlag1(s);

        }
        return list;


    }


















    @Override
    public Map<String, List<Complaint>> findBY(Integer areaId) {

        Map<String, List<Complaint>> map=new HashMap<>();
        List<Complaint> list= complaintMapper.findBy(areaId);
        List<Complaint> complaints=complaintMapper.findByPartCom(areaId);
        map.put("complaint",list);

        list.addAll(complaints);
        map.put("complaint",list);
        return map;
    }

    @Override
    public List<Complaint> selectHistoryComplaintInfo(Integer whoId) {
        return complaintMapper.selectHistoryComplaintInfo(whoId);
    }

    @Override
    public int deleteByIdAndWhoId(Integer id, Integer whoId) {
        return complaintMapper.deleteByIdAndWhoId(id,whoId);
    }

    @Override
    public Complaint selectByIdAndWhoId(Integer id, Integer whoId) {
        return complaintMapper.selectByIdAndWhoId(id,whoId);
    }


}
