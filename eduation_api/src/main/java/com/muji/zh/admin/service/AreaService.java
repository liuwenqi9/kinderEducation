package com.muji.zh.admin.service;

import com.muji.zh.admin.model.Area;

import java.util.List;

public interface AreaService {
    List<Area> dinstinctName(Integer id);

    List<Area> findAll();
}
