package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.NoticeType;
import com.muji.zh.admin.model.NoticeTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}