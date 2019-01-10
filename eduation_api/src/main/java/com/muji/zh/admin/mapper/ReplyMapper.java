package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Reply;
import com.muji.zh.admin.model.ReplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    long countByExample(ReplyExample example);

    int deleteByExample(ReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByExample(@Param("record") Reply record, @Param("example") ReplyExample example);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> selectReplyBycid(Integer cid);














    //从业者查看回复信息
    List<Reply> selectReplyByCIdAndWhoId(@Param("cid") Integer cid,@Param("whoId")Integer whoId);



}