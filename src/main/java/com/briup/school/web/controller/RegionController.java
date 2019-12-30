package com.briup.school.web.controller;

import com.briup.school.bean.Region;
import com.briup.school.service.IRegionService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region")
@Api(description = "校园信息")
public class RegionController {
    @Autowired
private IRegionService regionService;

    @GetMapping("/selectAll")


public Message selectAll(){


        List<Region> regions=regionService.findAll();
        return MessageUtil.success(regions);
}
@PostMapping("/update")
    public Message update(Region region){
regionService.saveOrUpdate(region);
        return MessageUtil.success();
}


@GetMapping("/delete")
    public Message deleteById(int id){
regionService.deleteById(id);
        return MessageUtil.success("chenggong");
}
@GetMapping("/add")
    public  Message addRegion(Region region){
  regionService.saveOrUpdate(region);
        return MessageUtil.success("chenggong");

}
@GetMapping("/find")
    public  Message findById(int id){
Region region=regionService.selectById(id);
        return MessageUtil.success(region);
}
}
