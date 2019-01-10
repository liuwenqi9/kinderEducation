package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Notice;
import com.muji.zh.admin.model.NoticeType;
import com.muji.zh.admin.model.NoticeTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeTypeMapper {
    long countByExample(NoticeTypeExample example);

    int deleteByExample(NoticeTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeType record);

    int insertSelective(NoticeType record);

    List<NoticeType> selectByExample(NoticeTypeExample example);

    NoticeType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeType record, @Param("example") NoticeTypeExample example);

    int updateByExample(@Param("record") NoticeType record, @Param("example") NoticeTypeExample example);

    int updateByPrimaryKeySelective(NoticeType record);

    int updateByPrimaryKey(NoticeType record);


    List<Notice> findKinderNotice(@Param("aId") Integer aId);
}