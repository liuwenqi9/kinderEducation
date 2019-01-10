package com.muji.zh.eduuser.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.muji.zh.admin.model.*;
import com.muji.zh.admin.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EnableScheduling
@Controller
public class AlarmController {

    @Reference
    private KindergartenService kindergartenService;
    @Reference
    private KindWarnService kindWarnService;
    @Reference
    private ClasService clasService;

    @Reference
    private SalaryListService salaryListService;

    @Reference
    private StudentService studentService;
    @Reference
    private StationService stationService;
    @Reference
    private PractitionerService practitPionerService;

    @Reference
    private PartWarnService partWarnService;

    @Reference
    private ParSlarListService parSlarListService;


    @ApiOperation(value = "警告的触发")
     @Scheduled(cron="0 0 1 ? * MON")
    //@Scheduled(cron = "0/20 * *  * * ? ")
    public void findByKid() {

        System.out.println(kindergartenService);
        List<Kindergarten> kindergartenList = kindergartenService.sel();
        System.out.println(kindergartenList.size());
        for (int i = 0; i < kindergartenList.size(); i++) {
            Kindergarten kindergarten = kindergartenList.get(i);
            KindWarn kindWarn = new KindWarn();
            kindWarn.setAreaId(kindergarten.getAreaId() + "");
            kindWarn.setkId(kindergarten.getkId());
            System.out.println(kindergarten);
            kindergarten.setKname(kindergarten.getKname());
            if (kindergarten.getPhone() == null) {


                kindWarn.setContent("负责人手机号为空");
                kindWarn.setField("phone");
                kindWarn.setFlag1("410100");

                kindWarn.setwId(4);

                kindWarnService.insertSelective(kindWarn);
            }
            if (kindergarten.getLicenseNumber() == null) {


                kindWarn.setContent("缺少许可证");
                kindWarn.setField("license_number");
                kindWarn.setFlag1("410100");
                kindWarn.setwId(1);

                kindWarnService.insertSelective(kindWarn);
            }
            Long countClas=clasService.countToClas(kindergarten.getkId());
            if(kindergarten.getPlanClass().equals(countClas))
            {


                kindWarn.setContent("实际办班个数与计划不符");
                kindWarn.setField("plan_clas");
                kindWarn.setFlag1("410100");
                kindWarn.setwId(3);

                kindWarnService.insertSelective(kindWarn);
            }
            Long countStudent = studentService.countStudent(kindergarten.getkId());
            System.out.println(!kindergarten.getPlanPeople().equals(countStudent));
            System.out.println(kindergarten.getPlanPeople() + "_______________" + countStudent);
            System.out.println("-----------------------------");
            if (!kindergarten.getPlanPeople().equals(countStudent)) {
                kindWarn.setContent("实际招收学生人数与计划不符");
                kindWarn.setField("plan_student");
                kindWarn.setFlag1("410100");
                kindWarn.setwId(3);

                kindWarnService.insertSelective(kindWarn);
            }
            List<Station> stationList = stationService.find();
            Map<String, Long> map = practitPionerService.findCountBY(kindergarten.getkId(), stationList);


            if (!kindergarten.getPlanPeople().equals(map.get("cont0") + map.get("cont1"))) {
                kindWarn.setContent("在职教师人数与计划不符");
                kindWarn.setField("plan_teacher");
                kindWarn.setwId(2);
                kindWarn.setFlag1("410100");
                kindWarnService.insertSelective(kindWarn);
            }
            if (!kindergarten.getPlanPeople().equals(map.get("cont3") + map.get("cont2"))) {
                kindWarn.setContent("保育员人数与计划不符");
                kindWarn.setField("governess");
                kindWarn.setwId(2);
                kindWarn.setFlag1("410100");
                kindWarnService.insertSelective(kindWarn);
            }
            if (!kindergarten.getOtherPeople().equals(map.get("cont5"))) {
                kindWarn.setContent("其他员工人数与计划不符");
                kindWarn.setField("other_people");
                kindWarn.setwId(2);
                kindWarn.setFlag1("410100");
                kindWarnService.insertSelective(kindWarn);
            }


        }

    }
   // @Scheduled(cron = "0/20 * *  * * ? ")
    public void prat() {

        List<Practitioner> practitionerList = practitPionerService.findAll();
        System.out.println(practitionerList.size());

        for (int i = 0; i < practitionerList.size(); i++) {
            System.out.println(i);
            Practitioner practitioner = practitionerList.get(i);
            System.out.println(practitioner);
            PartWarn partWarn = new PartWarn();
            partWarn.setFlag1(practitioner.getAreaId() + "");
            practitioner.setFlag2(practitioner.getUbranId() + "");
            if (practitioner.getCertificate() == null) {
                partWarn.setContent("资格证缺失");
                partWarn.setwId(1);
                partWarn.setpId(practitioner.getId());
                partWarn.setField("ceritificate");
                partWarn.setFlag1("410100");
                partWarnService.insertSelective(partWarn);
            }
            Double realwages = 0.0;
            SalaryList salaryList=salaryListService.findTosid(practitioner.getId());
            List<ParSlarList> parSlarListList=new ArrayList<>();

            try {
                parSlarListList = parSlarListService.findBy(practitioner.getId(),salaryList.getId());
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(parSlarListList.size());
            for (int j = 0; j < parSlarListList.size(); j++) {
                System.out.println(parSlarListList.get(j).getRealWages());
                realwages += parSlarListList.get(j).getRealWages();

                System.out.println(realwages);
            }
            System.out.println(realwages);
            if (!practitioner.getWages().equals(realwages)) {
                partWarn.setContent("工资申报与实发不符");
                partWarn.setwId(1);
                partWarn.setpId(practitioner.getpId());
                partWarn.setField("wages");
                partWarn.setFlag1("410100");
                partWarnService.insertSelective(partWarn);
            }

            if (practitioner.getSocialSecurity()==null)
            {
                partWarn.setContent("社保资格证缺失");
                partWarn.setwId(1);
                partWarn.setpId(practitioner.getpId());
                partWarn.setField("wages");
                partWarn.setFlag1("410100");
                partWarnService.insertSelective(partWarn);
            }

            if (practitioner.getMentalHealth()==null)
            {
                partWarn.setContent("心理健康证缺失");
                partWarn.setwId(4);
                partWarn.setpId(practitioner.getpId());
                partWarn.setField("wages");
                partWarn.setFlag1("410100");
                partWarnService.insertSelective(partWarn);
            }

            if (practitioner.getPhysicalHealth()==null)
            {
                partWarn.setContent("生理健康证缺失");
                partWarn.setwId(4);
                partWarn.setpId(practitioner.getpId());
                partWarn.setField("wages");
                partWarn.setFlag1("410100");
                partWarnService.insertSelective(partWarn);
            }
        }


    }


}
