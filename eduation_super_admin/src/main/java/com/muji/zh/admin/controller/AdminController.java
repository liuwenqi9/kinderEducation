package com.muji.zh.admin.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.Admin;
import com.muji.zh.admin.model.Education;
import com.muji.zh.admin.service.AdminService;
import com.muji.zh.admin.service.EducationService;
import config.redis.DashboardKey;
import config.redis.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController

@Api(value = "/Admin",description = "这是全部的/Admin方法")
public class AdminController {

    @Reference
    private AdminService adminService;
    @Reference
    private EducationService educationService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/admin",method = POST)
    @ApiOperation(value = "添加教育局",httpMethod = "POST")
    public String admin(Education education)
    {
        educationService.insertSelective(education);
        return "/test";
    }


    @RequestMapping(value = "/baidu",method = POST)
    @ApiOperation(value = "添s",httpMethod = "POST")
    public String admin(@RequestParam String parms)
    {

        JSONObject jsonObject=new JSONObject();
        jsonObject.toJSONString(parms);
       // educationService.insertSelective(education);
        return jsonObject.toJSONString(parms);
    }

    @RequestMapping(value = "/findById",method = POST)
    @ResponseBody
    @ApiOperation(value = "根据id查询教育局")
    public String findById(@RequestParam(value="pn",defaultValue="1") int pn,Integer id)
    {
        PageInfo<Education> lis= educationService.findByUbranID(1,4,id);
       for (int i=0;i<lis.getSize();i++)
       {
           System.out.println(lis.getList().get(i));
       }

        return  educationService.findByUbranID(pn,3,id).toString();
    }

    @RequestMapping(value = "/login",method = POST)
    public ModelAndView login(@RequestParam(value="pn",defaultValue="1") Integer pn, Admin admin, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws IOException {
        System.out.println(admin.toString());
        Admin ad = adminService.login(admin);
        if (ad != null) {
            System.out.println(ad);
            if (ad.getPhone() != null && ad.getPhone() != "") {
                request.getSession().setAttribute("ad ", ad);
                session.setAttribute("ad",ad);
                Admin admin1= (Admin) request.getSession().getAttribute("ad");
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.setViewName("admin/student/student");
                return modelAndView;
            } else {
                System.out.println("请完善个人信息");
                ModelAndView modelAndView=new ModelAndView();
                modelAndView.setViewName("/admin/index");
                return modelAndView;
            }
        }

        else {
            System.out.println("用户名密码错误");
            System.out.println("请输入正确的密码");
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("/admin/index");
            return modelAndView;
        }
    }



}
