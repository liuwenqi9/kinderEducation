package com.muji.zh.student.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muji.zh.admin.model.Reply;
import com.muji.zh.admin.service.ReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "/Reply",description = "这是Reply的方法")
public class ReplyController {

    @Reference
    private ReplyService replyService;


    @PostMapping("/selectReply")
    @ApiOperation("家长查看投诉回复")
    @ResponseBody
    public List<Reply> zh_select_Reply_By_cid(Integer cid){
        return replyService.selectReplyBycid(cid);
    }
}
