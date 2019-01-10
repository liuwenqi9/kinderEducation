package com.muji.zh.admin.service;

import com.muji.zh.admin.model.Notice;
import com.muji.zh.admin.model.NoticeExample;
import com.muji.zh.admin.model.NoticeType;
import com.muji.zh.admin.model.Parent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeService {

    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
    List<NoticeType> distinctName();

    List<Notice> findByParent(Parent parent,String areaId);

    Notice findBy(int i, Integer epId);






    //查询所有的通知公告
    List<Notice> selectByAimAndSign();










    List<Notice> findKinderNotice(Integer areaId);
}
