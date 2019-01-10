package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muji.zh.admin.model.StuParent;
import com.muji.zh.admin.service.StuParentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(value = "StuParent",description = "这是StuParent所有的方法")
public class StuParentController {

    @Reference
    private StuParentService stuParentService;

    @PostMapping("/insertStuParent")
    @ApiOperation("添加学生和家长的关系")
    @ResponseBody
    public int zh_insert_StuParent(StuParent stuParent){
        return stuParentService.insert(stuParent);
    }

    @PostMapping("/deleteStuParent")
    @ApiOperation("删除家长和学生的关系")
    @ResponseBody
    public int zh_delete_StuParent(Integer id){
        return stuParentService.deleteByPrimaryKey(id);
    }

    @PostMapping("/selectStuParent")
    @ApiOperation("查询家长和学生的关系")
    @ResponseBody
    public StuParent zh_select_StuParent(Integer id){
        return stuParentService.selectByPrimaryKey(id);
    }

    @PostMapping("/updateStuParent")
    @ApiOperation("更新家长和学生的关系")
    @ResponseBody
    public int zh_update_StuParent(StuParent stuParent){
        return stuParentService.updateByPrimaryKeySelective(stuParent);
    }


}
