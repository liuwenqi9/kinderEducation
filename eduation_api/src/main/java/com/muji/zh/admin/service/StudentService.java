package com.muji.zh.admin.service;

import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.model.*;

import java.util.List;
import java.util.Map;

public interface StudentService {


    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    public Student login(Student student);

    Long findAll(Integer areaId,Integer sign);


    Map<String, String> findClasTypeSex(List<List<Clas>> clasList,Integer area_id, String sex,Integer id);

    List<Student> studentView(Integer kindId);

    int deleteStudent(Integer id);
    int updateStudent(Student student);

    Map<String, Object>  findKidToType(Integer kid, List<ClassType> classTypeList);

    Integer findKidToSex(String sex, Integer kid);

    PageInfo<Student> findByLikeName(String kinderName, String studentname, String phone, EduUser eduUser, Integer pn);




    List<Student> findByPid(Integer id);

    Student findBYStuID(Integer stuId);

    Map<String, String> findByCtype(List<ClassType> typeList, EduUser eduUser,String sex);

    long findByDate(EduUser eduUser);

    Long countStudent(Integer getkId);

    Map<String, Object> findByClasTypeStudent(List<ClassType> finds, Integer kid);















    Map<String, String> findClasTypeSex(List<List<Clas>> clasList, String sex);

//    List<Student> studentView(Integer kindId);
//
//    int deleteStudent(Integer id);
//    int updateStudent(Student student);

    PageInfo<StudentVo> getStudentVo(Integer kindId, int currentPage, int pageSize);

    PageInfo<StudentVo> chooseStudent(String sname, Integer integer, Integer kindId,int currentPage);

    long chooseCount(String sname, Integer stuId, Integer kindId);
}
