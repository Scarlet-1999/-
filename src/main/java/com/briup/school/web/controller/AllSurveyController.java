package com.briup.school.web.controller;

import com.briup.school.bean.ex.SurveyEX;
import com.briup.school.service.IAllSurveyService;
import com.briup.school.service.ISurveyCheckService;
import com.briup.school.util.Message;
import com.briup.school.util.MessageUtil;
import com.sun.deploy.net.URLEncoder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/Allsurvey")
@Api(description = "全部课调管理")
public class AllSurveyController {
    @Autowired
    private IAllSurveyService allSurveyService;

    @Autowired
    private ISurveyCheckService surveyCheckService;


    @GetMapping("/findall")
    @ApiOperation("查询所有")
    public Message findall(){
        List<SurveyEX> list=allSurveyService.findall();

        return MessageUtil.success(list);
    }

    @ApiOperation("通过班级名字查询")
    @GetMapping("/findByClassName")
    public Message findByClassName(String Classname){
        List<SurveyEX> list =allSurveyService.findByClassName(Classname);
        return MessageUtil.success(list);
    }


    @GetMapping("/findByAll")
    @ApiOperation("条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Dname",value = "年级名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "Clname",value = "班级名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "Coname",value = "课程名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "Qname",value = "问卷名",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "word",value = "关键字",paramType = "query",dataType = "String")
    })
    public Message findByAll(String Dname,String Clname,String Coname,String Qname,String word){
        List<SurveyEX> list=allSurveyService.findByAll(Dname,Clname,Coname,Qname,word);
        return MessageUtil.success(list);
    }



    @GetMapping("/seeById")
    @ApiOperation("预览")
    public Message seeById(int id){

        return MessageUtil.success(allSurveyService.seeById(id));
    }


    @GetMapping("/down")
    @ApiOperation("下载")
    public void down(HttpServletResponse response,int id) throws UnsupportedEncodingException {
        SurveyEX surveyEX = allSurveyService.seeById(id);

        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表格
        XSSFSheet sheet=workbook.createSheet("课调信息");
        //创建行
        XSSFRow row=sheet.createRow(0);
        //创建列 创建单元格
        XSSFCell cell=row.createCell(0);
        //设置单元格数据类型
        cell.setCellType(CellType.STRING);
        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,7));
        //设置单元格内容
        cell.setCellValue(surveyEX.getQuestionnaireEX().getName());


        //第二行第一列
        XSSFRow row2 = sheet.createRow(1);
        XSSFCell cell1 = row2.createCell(0);
        cell1.setCellType(CellType.STRING);
        cell1.setCellValue("教师名称");
        //第二行第二列
        XSSFCell cell2 = row2.createCell(1);
        cell2.setCellType(CellType.STRING);
        cell2.setCellValue(surveyEX.getUser().getName());
        row2.createCell(2).setCellValue("班级名称");
        row2.createCell(3).setCellValue(surveyEX.getDepartment().getName());
        row2.createCell(4).setCellValue("课程名称");
        row2.createCell(5).setCellValue(surveyEX.getCourse().getName());
        row2.createCell(6).setCellValue("平均分");
        row2.createCell(7).setCellValue(surveyEX.getAverage());

        for (int i=0;i<surveyEX.getAnswers().size();i++){
            XSSFRow row3 = sheet.createRow(2 + i);
            row3.createCell(0).setCellValue(surveyEX.getAnswers().get(i).getId());
            row3.createCell(1).setCellValue(surveyEX.getAnswers().get(i).getAnswer());
        }




        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(surveyEX.getUser().getName()+"的课调.xlsx", "utf-8"));

        try {
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
