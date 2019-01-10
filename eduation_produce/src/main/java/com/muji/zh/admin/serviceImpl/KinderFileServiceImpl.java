package com.muji.zh.admin.serviceImpl;

import com.muji.zh.admin.mapper.KinderFileMapper;
import com.muji.zh.admin.model.KinderFile;
import com.muji.zh.admin.service.KinderFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/1/7/007.
 */
@Service
@com.alibaba.dubbo.config.annotation.Service
public class KinderFileServiceImpl implements KinderFileService {
    @Autowired
    private KinderFileMapper kinderFileMapper;
    @Override
    public KinderFile findKinderFile(String i, Integer kindId) {
        return kinderFileMapper.selectFile(i,kindId);
    }

    @Override
    public KinderFile insertFile(String originalFilename, String fileUrl, String type, Integer kindId) {
        KinderFile kinderFile=new KinderFile();
        kinderFile.setFname(originalFilename);
        kinderFile.setUrl(fileUrl);
        kinderFile.setType(type);
        kinderFile.setKinderId(kindId);
        kinderFileMapper.insertSelective(kinderFile);
        return kinderFile;
    }

    @Override
    public void deleteFile(Integer fId) {
        kinderFileMapper.deleteByPrimaryKey(fId);
    }
}
