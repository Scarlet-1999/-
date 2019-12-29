package com.briup.school.service;

import com.briup.school.bean.Region;
import com.briup.school.bean.RegionExample;

import java.util.List;


public interface IRegionService {
    List<Region> findAll() throws RuntimeException;

}
