package com.muji.zh.admin.service;

import com.muji.zh.admin.model.KinderFile;

/**
 * Created by Administrator on 2019/1/7/007.
 */
public interface KinderFileService {

    KinderFile findKinderFile(String i, Integer kindId);

    KinderFile insertFile(String originalFilename, String fileUrl, String type, Integer kindId);

    void deleteFile(Integer fId);
}
