package com.muji.zh.admin.mapper;

import com.muji.zh.admin.model.EduUser;
import com.muji.zh.admin.model.PraVo;
import com.muji.zh.admin.model.Practitioner;
import com.muji.zh.admin.model.PractitionerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PractitionerMapper {
    long countByExample(PractitionerExample example);

    int deleteByExample(PractitionerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Practitioner record);

    int insertSelective(Practitioner record);

    List<Practitioner> selectByExample(PractitionerExample example);

    Practitioner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Practitioner record, @Param("example") PractitionerExample example);

    int updateByExample(@Param("record") Practitioner record, @Param("example") PractitionerExample example);

    int updateByPrimaryKeySelective(Practitioner record);

    int updateByPrimaryKey(Practitioner record);

    List<Practitioner> findByLikeName(@Param("pattern") String pattern,
                                      @Param("id") Integer id,
                                      @Param("studentname") String studentname,
                                      @Param("phone") String phone,
                                      @Param("sign") Integer sign,
                                      @Param("ubran_id") Integer ubran_id
                                     );



















    List<Practitioner> findBykinId(@Param("kId")Integer kId);
    List<Practitioner> selectBypNameAndphone(@Param("pname") String panme,@Param("phone") String phone,@Param("kId") Integer kId);
    List<Practitioner> findClasPra(@Param("kId")Integer kId);
    List<PraVo> selectPraVo(@Param("kId")Integer kId);
    long selectCount(@Param("kId")Integer kId);

    List<PraVo> checkPra(@Param("kId")Integer kId,@Param("pname")String pname);

    long checkCount(@Param("kId")Integer kId,@Param("pname")String pname);

    Practitioner checkSalay(@Param("pId") Integer pId,@Param("pname") String pname);


}