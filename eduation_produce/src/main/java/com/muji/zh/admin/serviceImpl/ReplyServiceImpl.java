package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.ReplyMapper;
import com.muji.zh.admin.model.Reply;
import com.muji.zh.admin.model.ReplyExample;
import com.muji.zh.admin.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public List<Reply> selectByExample(ReplyExample example) {
        return replyMapper.selectByExample(example);
    }

    @Override
    public List<Reply> selectReplyBycid(Integer cid) {
        return replyMapper.selectReplyBycid(cid);
    }


    @Override
    public long countByExample(ReplyExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(ReplyExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(Reply record) {
        return replyMapper.insert(record);
    }

    @Override
    public int insertSelective(Reply record) {
        return replyMapper.insertSelective(record);
    }

    @Override
    public Reply selectByPrimaryKey(Integer id) {
        return replyMapper.selectByPrimaryKey(id);
    }


















    @Override
    public List<Reply> selectReplyByCIdAndWhoId(Integer cid,Integer whoId) {
        return replyMapper.selectReplyByCIdAndWhoId(cid,whoId);
    }
}
