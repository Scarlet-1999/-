package com.briup.school.service;

import com.briup.school.bean.Region;
import com.briup.school.bean.RegionExample;

import java.util.List;


public interface IRegionService {
    List<Region> findAll() throws RuntimeException;
    void  saveOrUpdate(Region region) throws  RuntimeException;
    void deleteById(int id) throws  RuntimeException;
    Region selectById(int id) throws RuntimeException;

}
