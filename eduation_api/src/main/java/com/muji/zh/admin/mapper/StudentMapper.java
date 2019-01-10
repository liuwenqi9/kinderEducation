package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.Student;
import com.muji.zh.admin.model.StudentExample;
import com.muji.zh.admin.model.StudentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);




    List<Student> selectBykId(Integer kId);//查询幼儿园
    Integer findClasType(@Param("kid")Integer kid, @Param("c_type")Integer c_type);

    Integer findClasTypeCount(@Param("kid")Integer kid, @Param("c_type")Integer ctId);//查询某个班级个数

    List<Student> findByLikeName(@Param("pattern") String pattern,
                                 @Param("id") Integer id,
                                 @Param("studentname") String studentname,
                                 @Param("phone") String phone,
                                 @Param("sign") Integer sign,
                                 @Param("ubran_id") Integer ubran_id
    );


    List<Student> findByPid(Integer id);


    Integer findByCtypeCount(@Param("c_type") Integer pattern,
                             @Param("flag2") Integer flag2,
                             @Param("sex") String sex);

    Integer findByCtypeCount1(@Param("c_type") Integer pattern,
                             @Param("flag1") Integer flag2,
                             @Param("sex") String sex);










   // List<Student> selectBykId(Integer kId);

    List<StudentVo> findStudentVo(@Param("kId") Integer kId);

    List<StudentVo> selectBysNameAndstuId(@Param("sname") String sname, @Param("stuId") Integer stuId,@Param("kId") Integer kindId);

    long selectCount(@Param("kId") Integer kId);

    long checkCount(@Param("sname") String sname, @Param("stuId") Integer stuId,@Param("kId") Integer kindId);


}