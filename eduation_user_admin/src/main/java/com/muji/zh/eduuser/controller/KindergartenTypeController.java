package com.muji.zh.eduuser.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muji.zh.admin.model.KindergartenType;
import com.muji.zh.admin.service.KindergrationTypeService;
import com.muji.zh.config.service.FastefsClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Api(value = "/KinderType",description = "这是全部的幼儿园类别方法")
public class KindergartenTypeController {

    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;

    @Autowired
    private FastefsClient fastefsClient;

    @Reference
    private KindergrationTypeService kindergrationTypeService;
    @RequestMapping(value = "/addType",method = RequestMethod.POST)
    @ApiOperation("添加类别")
    @ApiParam(value = "ki")
    public String addType(KindergartenType kindergartenType)
    {

        kindergrationTypeService.insertSelective(kindergartenType);
        return kindergartenType.toString();

    }
    @RequestMapping("/main/index")
    public String test(){

        return "/main/index";
    }



}
