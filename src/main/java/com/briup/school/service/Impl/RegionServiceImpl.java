package com.briup.school.service.Impl;

import com.briup.school.bean.Region;
import com.briup.school.bean.RegionExample;
import com.briup.school.mapper.RegionMapper;
import com.briup.school.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl  implements IRegionService {
    @Autowired
    private  RegionMapper regionMapper;

    @Override
    public List<Region> findAll() throws RuntimeException {
        RegionExample regionExample=new RegionExample();
        List<Region> regions=regionMapper.selectByExample(regionExample);
        return regions;
    }




}
