package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.ParSlarListMapper;
import com.muji.zh.admin.model.ParSlarList;
import com.muji.zh.admin.model.ParSlarListExample;
import com.muji.zh.admin.service.ParSlarListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ParSlarListServiceImpl implements ParSlarListService {
    @Autowired
    private ParSlarListMapper parSlarListMapper;

    @Override
    public List<ParSlarList> findBy(Integer id, Integer id1) {

        ParSlarListExample example=new ParSlarListExample();
        ParSlarListExample.Criteria criteria=example.createCriteria();
        criteria.andPIdEqualTo(id);
        criteria.andSIdEqualTo(id1);
        return parSlarListMapper.selectByExample(example);
    }


    @Override
    public Long findRellay(Integer getsId) {


        ParSlarListExample example=new ParSlarListExample();
        ParSlarListExample.Criteria criteria=example.createCriteria();
        criteria.andSIdEqualTo(getsId);
        criteria.andStateEqualTo(1);

        List<ParSlarList> lists=parSlarListMapper.selectByExample(example);

        long sum=0;
        for (int i=0;i<lists.size();i++)
        {
            sum+=lists.get(i).getRealWages();

        }

        return sum;
    }






    @Override
    public List<ParSlarList> selectParSlarListByPrimaryAndSignId(Integer id, Integer sign,Integer state) {
        return parSlarListMapper.selectParSlarListByPrimaryAndSignId(id,sign,state);
    }

    @Override
    public List<ParSlarList> selectParSlarListByPidAndSign(Integer pid,Integer sign) {
        return parSlarListMapper.selectParSlarListByPidAndSign(pid,sign);
    }

    @Override
    public int ConfirmSlarList(Integer sign,Integer state,Integer pId) {
        return parSlarListMapper.ConfirmSlarList(sign,state,pId);
    }

    @Override
    public List<Integer> selectStateBypIdAndSignAndId(Integer pId, Integer sign) {
        return parSlarListMapper.selectStateBypIdAndSignAndId(pId,sign);
    }

    @Override
    public List<Integer> selectSidBypPidAndId(Integer pId) {
        return parSlarListMapper.selectSidBypPidAndId(pId);
    }

    @Override
    public Integer selectTotalWagesBypIdAndSign(Integer pId, Integer sign) {
        return parSlarListMapper.selectTotalWagesBypIdAndSign(pId,sign);
    }
}
