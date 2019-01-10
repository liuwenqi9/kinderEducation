package com.muji.zh.admin.serviceImpl;


import com.muji.zh.admin.mapper.AdminMapper;
import com.muji.zh.admin.model.Admin;
import com.muji.zh.admin.model.AdminExample;
import com.muji.zh.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public long countByExample(AdminExample example) {
        return adminMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AdminExample example) {
        return adminMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public List<Admin> selectByExample(AdminExample example) {
        return adminMapper.selectByExample(example);
    }

    @Override
    public Admin selectByPrimaryKey(Integer id) {
        System.out.println(id);
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin login(Admin admin) {
        AdminExample example=new AdminExample();
        AdminExample.Criteria criteria=example.createCriteria();
        criteria.andPasswordEqualTo(admin.getPassword());
        criteria.andIdEqualTo(admin.getId());
       // List<Admin> admins=adminMapper.selectByExample(example);
        Admin admin1=adminMapper.selectByPrimaryKey(admin.getId());
       // return admins.get(0);
        return admin1;

    }
}
