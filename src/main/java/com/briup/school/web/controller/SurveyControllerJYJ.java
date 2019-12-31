package com.briup.school.web.controller;

import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SurveyJYJ")
@Api(description = "课调管理（季渝钧）")
public class SurveyControllerJYJ {

    @GetMapping
    Message selectAll(){
        return MessageUtil.success();
    }
}
