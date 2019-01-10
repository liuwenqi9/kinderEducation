package com.muji.zh.admin.service;

import com.muji.zh.admin.model.PartWinRecord;

import java.util.List;

public interface PartWinRecordService {


    List<PartWinRecord> FindByPid(Integer id);
}
