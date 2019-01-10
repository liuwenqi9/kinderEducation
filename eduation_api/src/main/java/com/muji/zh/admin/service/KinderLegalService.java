package com.muji.zh.admin.service;

import com.muji.zh.admin.model.KinderFile;
import com.muji.zh.admin.model.KinderLegal;

import java.util.List;

public interface KinderLegalService {
    KinderLegal login(Integer id, String password);

    void updatePassword(KinderLegal kinder);
    List<KinderLegal> findAll();
    KinderLegal findById(Integer legalId);

}
