package com.muji.zh.admin.service;

import com.muji.zh.admin.model.Admin;
import com.muji.zh.admin.model.AdminExample;

import java.util.List;

public interface AdminService {

    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer id);

    public Admin login(Admin admin);


}
