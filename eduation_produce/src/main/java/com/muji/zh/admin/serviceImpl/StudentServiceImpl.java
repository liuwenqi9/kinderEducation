package com.muji.zh.admin.serviceImpl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.muji.zh.admin.mapper.KindergartenMapper;
import com.muji.zh.admin.mapper.StudentCopyMapper;
import com.muji.zh.admin.mapper.StudentMapper;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentCopyMapper studentCopyMapper;


    @Autowired
    private KindergartenMapper kindergartenMapper;

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
          return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public Student login(Student student) {
        return null;
    }

    @Override
    public Long findAll(Integer areaId,Integer sign) {
        if(sign==1) {


            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andUbranIdEqualTo(areaId);
            long c = studentMapper.countByExample(studentExample);
            return c;
        }else{
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andAreaIdEqualTo(areaId);
            long c = studentMapper.countByExample(studentExample);
            return c;
        }
    }

    @Override
    public Map<String, String> findClasTypeSex(List<List<Clas>> clasList,Integer area_id, String sex,Integer sign) {
            if(sign==1){
            System.out.println(sex);
            if (sex != null && !sex.equals("")) {
                HashMap<String, String> map = new HashMap<>();
                for (int i = 0; i < clasList.size(); i++) {
                    long sum = 0;
                    List<Clas> clasList1 = clasList.get(i);//同一类别的班级id
                    for (int j = 0; j < clasList1.size(); i++) {
                        StudentExample studentExample = new StudentExample();
                        StudentExample.Criteria criteria = studentExample.createCriteria();
                        criteria.andClasIdEqualTo(clasList1.get(j).getcId());
                        criteria.andSexEqualTo(sex);
                        criteria.andUbranIdEqualTo(area_id);
                        Long s = studentMapper.countByExample(studentExample);
                        sum = sum + s;//计算出同一类别的学生人数
                    }
                    map.put("student_clastotal" + i, sum + "");
                }
                return map;
            } else {

                HashMap<String, String> map = new HashMap<>();
                for (int i = 0; i < clasList.size(); i++) {
                    long sum = 0;
                    List<Clas> clasList1 = clasList.get(i);//同一类别的班级id
                    for (int j = 0; j < clasList1.size(); i++) {
                        StudentExample studentExample = new StudentExample();
                        StudentExample.Criteria criteria = studentExample.createCriteria();
                        criteria.andClasIdEqualTo(clasList1.get(j).getcId());
                        criteria.andUbranIdEqualTo(area_id);
                        Long s = studentMapper.countByExample(studentExample);
                        sum = sum + s;//计算出同一类别的学生人数
                    }
                    map.put("student_clastotal" + i, sum + "");
                }
                return map;
            }
        }else {
                System.out.println(sex);
                if (sex != null && !sex.equals("")) {
                    HashMap<String, String> map = new HashMap<>();
                    for (int i = 0; i < clasList.size(); i++) {
                        long sum = 0;
                        List<Clas> clasList1 = clasList.get(i);//同一类别的班级id
                        for (int j = 0; j < clasList1.size(); i++) {
                            StudentExample studentExample = new StudentExample();
                            StudentExample.Criteria criteria = studentExample.createCriteria();
                            criteria.andClasIdEqualTo(clasList1.get(j).getcId());
                            criteria.andSexEqualTo(sex);
                            criteria.andAreaIdEqualTo(area_id);
                            Long s = studentMapper.countByExample(studentExample);
                            sum = sum + s;//计算出同一类别的学生人数
                        }
                        map.put("student_clastotal" + i, sum + "");
                    }
                    return map;
                } else {

                    HashMap<String, String> map = new HashMap<>();
                    for (int i = 0; i < clasList.size(); i++) {
                        long sum = 0;
                        List<Clas> clasList1 = clasList.get(i);//同一类别的班级id
                        for (int j = 0; j < clasList1.size(); i++) {
                            StudentExample studentExample = new StudentExample();
                            StudentExample.Criteria criteria = studentExample.createCriteria();
                            criteria.andClasIdEqualTo(clasList1.get(j).getcId());
                            criteria.andAreaIdEqualTo(area_id);
                            Long s = studentMapper.countByExample(studentExample);
                            sum = sum + s;//计算出同一类别的学生人数
                        }
                        map.put("student_clastotal" + i, sum + "");
                    }
                    return map;
                }
            }

    }

    @Override
    public Map<String, String> findByCtype(List<ClassType> typeList, EduUser eduUser,String sex) {

        System.out.println(eduUser.getAreaId());
        if (eduUser.getSign()==1) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < typeList.size(); i++) {
                Integer s = studentMapper.findByCtypeCount(typeList.get(i).getCtId(), eduUser.getAreaId(), sex);
                map.put("clasTypeTotal" + i, s + "");
            }
            return map;
        }else {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < typeList.size(); i++) {
                Integer s = studentMapper.findByCtypeCount1(typeList.get(i).getCtId(), eduUser.getAreaId(), sex);
                map.put("clasTypeTotal" + i, s + "");
            }

            return map;
        }




    }

    @Override
    public long findByDate(EduUser eduUser) {



        if(eduUser.getSign()==1) {


            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andUbranIdEqualTo(eduUser.getAreaId());
            Date date=new Date();
            criteria.andCreateDateBetween(new Date(date.getTime()-120*24*60*60*1000),date);
            long c = studentMapper.countByExample(studentExample);
            return c;
        }else{
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andAreaIdEqualTo(eduUser.getAreaId());
            Date date=new Date();
            criteria.andCreateDateBetween(new Date(date.getTime()-120*24*60*60*1000),date);
            long c = studentMapper.countByExample(studentExample);
            return c;
        }
    }

    public int deleteStudent(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStudent(Student stu) {
        Student student = studentMapper.selectByPrimaryKey(stu.getId());
        StudentCopy studentCopy = new StudentCopy();
        studentCopy.setAreaId(student.getAreaId());
        studentCopy.setBirthday(student.getBirthday());
        studentCopy.setClasId(student.getClasId());
        studentCopy.setCreateDate(student.getCreateDate());
        studentCopy.setEduId(student.getEduId());
        studentCopy.setIcId(student.getIcId());
        studentCopy.setImage(student.getImage());
        studentCopy.setKid(student.getKid());
        studentCopy.setNativePlace(student.getNativePlace());
        studentCopy.setSex(student.getSex());
        studentCopy.setSid(student.getId());
        studentCopy.setSname(student.getSname());
        studentCopy.setStuId(student.getStuId());
        studentCopy.setTuition(student.getTuition());
        studentCopy.setUbranId(student.getUbranId());
        studentCopyMapper.insert(studentCopy);
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andIdEqualTo(student.getId());
        return studentMapper.updateByExampleSelective(stu, studentExample);
    }

    @Override
    public List<Student> studentView(Integer kId) {
        return studentMapper.selectBykId(kId);
    }


    @Override
    public Map<String, Object> findKidToType(Integer kid, List<ClassType> classTypeList) {
        Map<String, Object> map = new HashMap<>();

        System.out.println(kid);
        Map<String, String> map1 = new HashMap<>();
        for (int i = 0; i < classTypeList.size(); i++) {

            //班级类型人数
            Integer count = studentMapper.findClasType(kid, classTypeList.get(i).getCtId());
            //班级类型个数
            Integer clasTypeCount = studentMapper.findClasTypeCount(kid, classTypeList.get(i).getCtId());

            map1.put("StudentCountType" + i, count + "");
            map1.put("clasTypeCount" + i, clasTypeCount + "");
            map1.put("teacherCountType" + i, clasTypeCount + "");
            System.out.println(count);
        map.put("pr",map1);
        }




        return map;
    }


    @Override
    public Integer findKidToSex(String sex, Integer kid) {
        //统计这个幼儿园的男生人数
        if (sex != null && !sex.equals("")) {
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andSexEqualTo(sex);
            criteria.andKidEqualTo(kid);
            Long lo = studentMapper.countByExample(studentExample);
            String ls = lo + "";
            return Integer.parseInt(ls);
        }
        else {
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
          //  criteria.andSexEqualTo(sex);
            criteria.andKidEqualTo(kid);
            Long lo = studentMapper.countByExample(studentExample);
            String ls = lo + "";
            return Integer.parseInt(ls);
        }
        //return null;
    }



    @Override
    public PageInfo<Student> findByLikeName(String kinderName, String studentname, String phone, EduUser eduUser,Integer pn) {

        String s = null;
        Integer c = null;
        int i = 0;
        Integer pagesize = 7;
        PageHelper.startPage(pn,pagesize);
        System.out.println(eduUser);
        System.out.println(studentname);
        if (studentname != null) {


            boolean isNum = studentname.matches("[0-9]+");
            System.out.println(isNum);
            if (isNum ) {

                PageHelper.startPage(pn, pagesize);
                List <Student> list =studentMapper.findByLikeName(kinderName, Integer.parseInt(studentname), s, phone, eduUser.getSign(), eduUser.getAreaId());

                for(int j=0;j<list.size();j++)
                {Student student =new Student();
                 student=list.get(j);
                    student.setImage(kindergartenMapper.selectByPrimaryKey(student.getKid()).getKname());
                    student.setFlag1("学生");

                }

                PageInfo<Student> info = new PageInfo<Student>(list);


                return info;
            } else {
                PageHelper.startPage(pn, pagesize);
                List <Student> list =studentMapper.findByLikeName(kinderName, c, studentname, phone, eduUser.getSign(), eduUser.getAreaId());

                for(int j=0;j<list.size();j++)
                {Student student =new Student();
                    student=list.get(j);
                    student.setImage(kindergartenMapper.selectByPrimaryKey(student.getKid()).getKname());
                    student.setFlag1("学生");

                }
                PageInfo<Student> info = new PageInfo<Student>(list);
                return info;
            }
        } else {
            List <Student> list =studentMapper.findByLikeName(kinderName, c, studentname, phone, eduUser.getSign(), eduUser.getAreaId());

            for(int j=0;j<list.size();j++)
            {   Student student =new Student();
                student=list.get(j);
                student.setImage(kindergartenMapper.selectByPrimaryKey(student.getKid()).getKname());
                student.setFlag1("学生");

            }
            //List <Student> list =studentMapper.findByLikeName(kinderName, c, studentname, phone, eduUser.getSign(), eduUser.getAreaId());
            PageInfo<Student> info = new PageInfo<Student>(list);
            return info;
        }
    }

    @Override
    public List<Student> findByPid(Integer id) {
        return studentMapper.findByPid(id);
    }

    @Override
    public Student findBYStuID(Integer stuId) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

        criteria.andStuIdEqualTo(stuId);

        return studentMapper.selectByExample(studentExample).get(0);
    }


    @Override
    public Long countStudent(Integer getkId) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

        criteria.andKidEqualTo(getkId);
        return studentMapper.countByExample(studentExample);
    }


    @Override
    public Map<String, Object> findByClasTypeStudent(List<ClassType> finds, Integer kid) {
       Map<String,Object> map=new HashMap<>();
        for(int i=0;i<finds.size();i++)
        {
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();

            criteria.andKidEqualTo(kid);


        }
        return null;
    }

















    @Override
    public Map<String, String> findClasTypeSex(List<List<Clas>> clasList, String sex) {
        System.out.println(sex);
        if (sex != null && !sex.equals("")) {
            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < clasList.size(); i++) {
                long sum = 0;
                List<Clas> clasList1 = clasList.get(i);//同一类别的班级id
                for (int j = 0; j < clasList1.size(); i++) {
                    StudentExample studentExample = new StudentExample();
                    StudentExample.Criteria criteria = studentExample.createCriteria();
                    criteria.andClasIdEqualTo(clasList1.get(j).getcId());
                    criteria.andSexEqualTo(sex);
                    Long s = studentMapper.countByExample(studentExample);
                    sum = sum + s;//计算出同一类别的学生人数
                }
                map.put("student_clastotal" + i, sum + "");
            }
            return map;
        } else {

            HashMap<String, String> map = new HashMap<>();
            for (int i = 0; i < clasList.size(); i++) {
                long sum = 0;
                List<Clas> clasList1 = clasList.get(i);//同一类别的班级id
                for (int j = 0; j < clasList1.size(); i++) {
                    StudentExample studentExample = new StudentExample();
                    StudentExample.Criteria criteria = studentExample.createCriteria();
                    criteria.andClasIdEqualTo(clasList1.get(j).getcId());

                    Long s = studentMapper.countByExample(studentExample);
                    sum = sum + s;//计算出同一类别的学生人数
                }
                map.put("student_clastotal" + i, sum + "");
            }
            return map;
        }
    }


//    public int deleteStudent(Integer id) {
//        return studentMapper.deleteByPrimaryKey(id);
//    }
//
//    @Override
//    public int updateStudent(Student stu) {
//        Student student = studentMapper.selectByPrimaryKey(stu.getId());
//        StudentCopy studentCopy = new StudentCopy();
//        studentCopy.setAreaId(student.getAreaId());
//        studentCopy.setBirthday(student.getBirthday());
//        studentCopy.setClasId(student.getClasId());
//        studentCopy.setCreateDate(student.getCreateDate());
//        studentCopy.setEduId(student.getEduId());
//        studentCopy.setIcId(student.getIcId());
//        studentCopy.setImage(student.getImage());
//        studentCopy.setKid(student.getKid());
//        studentCopy.setNativePlace(student.getNativePlace());
//        studentCopy.setSex(student.getSex());
//        studentCopy.setSid(student.getId());
//        studentCopy.setSname(student.getSname());
//        studentCopy.setStuId(student.getStuId());
//        studentCopy.setTuition(student.getTuition());
//        studentCopy.setUbranId(student.getUbranId());
//        studentCopyMapper.insert(studentCopy);
//        StudentExample studentExample = new StudentExample();
//        StudentExample.Criteria criteria = studentExample.createCriteria();
//        criteria.andIdEqualTo(student.getId());
//        return studentMapper.updateByExampleSelective(stu, studentExample);
//    }

    @Override
    public PageInfo<StudentVo> getStudentVo(Integer kindId, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<StudentVo> studentVoList=studentMapper.findStudentVo(kindId);
        PageInfo<StudentVo> pageInfo=new PageInfo<StudentVo>(studentVoList);
        return pageInfo;
    }

    @Override
    public PageInfo<StudentVo> chooseStudent(String sname, Integer integer, Integer kindId,int currentPage) {
        PageHelper.startPage(currentPage,5);
        List<StudentVo> studentVoList=studentMapper.selectBysNameAndstuId(sname,integer,kindId);
        PageInfo<StudentVo> pageInfo=new PageInfo<StudentVo>(studentVoList);
        return pageInfo;
    }

    @Override
    public long chooseCount(String sname, Integer stuId, Integer kindId) {
        return studentMapper.checkCount(sname,stuId,kindId);
    }

//    @Override
//    public List<Student> studentView(Integer kId) {
//        return studentMapper.selectBykId(kId);
//    }


}