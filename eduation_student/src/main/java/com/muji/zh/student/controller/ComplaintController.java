package com.muji.zh.student.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.muji.zh.admin.model.Complaint;
import com.muji.zh.admin.model.ComplaintExample;
import com.muji.zh.admin.service.ComplaintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@Api(value = "/Complaint" ,description = "这是全部的/Complaint方法")
public class ComplaintController {
    @Reference
    private ComplaintService complaintService;

    @PostMapping(value = "/insertComplaintParent")
    @ApiOperation("家长投诉")
    @ResponseBody
    public int zh_insert_Complaint(Complaint complaint){
        return complaintService.insertSelective(complaint);
    }

    @ApiOperation("删除投诉")
    @PostMapping(value = "/deleteComplaintParent")
    @ResponseBody
    public int zh_delete_Complaint(Integer id){
        return complaintService.deleteByPrimaryKey(id);
    }

    @ApiOperation("查看投诉")
    @PostMapping(value = "/selectComplaintParent")
    @ResponseBody
    public List<Complaint> zh_select_Complaint(){
        ComplaintExample complaintExample=new ComplaintExample();
        complaintExample.setOrderByClause("id asc");
        complaintExample.setDistinct(true);
        return complaintService.selectByExample(complaintExample);
    }
}
