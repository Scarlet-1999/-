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

    @Override

    public void saveOrUpdate(Region region) throws RuntimeException {
        if (region == null) {
            throw new RuntimeException("参数为空");
        }

        if (region.getId() == null) {
            regionMapper.insert(region);
        } else {
            regionMapper.updateByPrimaryKey(region);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
     regionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Region selectById(int id) throws RuntimeException {
        Region region=new Region();

        return region;
    }


}
