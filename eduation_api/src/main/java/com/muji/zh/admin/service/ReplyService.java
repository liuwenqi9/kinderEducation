package com.muji.zh.admin.service;

import com.muji.zh.admin.model.Reply;
import com.muji.zh.admin.model.ReplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyService {

    List<Reply> selectByExample(ReplyExample example);

    List<Reply> selectReplyBycid(Integer cid);


    long countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);






















    //从业者查看回复信息
    List<Reply> selectReplyByCIdAndWhoId(@Param("cid") Integer cid, @Param("whoId")Integer whoId);

}
