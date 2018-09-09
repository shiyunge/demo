package com.exam.demo.controller;

import com.exam.demo.util.ExcelUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Export {

    @RequestMapping("exportWordData")
    public void exportExcelData(HttpServletRequest request, HttpServletResponse response) {
        // 定义表的标题
        String title = "员工列表一览";
        //定义表的列名
        String[] rowsName = new String[]{"序号", "姓名", "性别", "特长", "学历", "入职时间", "简历", "照片", "部门"};
        //定义表的内容
        List<Object[]> dataList = new ArrayList<Object[]>();
        Object[] objs = new Object[9];
        objs[0] = "测试";
        objs[1] = 11;
        objs[2] = "111";
        objs[3] = "测试";
        objs[4] = "测试";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(2018 - 12 - 24);
        objs[5] = date;
        objs[6] = "测试";
        objs[7] = "测试";
        objs[8] = "测试";
        dataList.add(objs);
        // 创建ExportExcel对象
        ExcelUtil excelUtil = new ExcelUtil();

        try {
            String fileName = new String("测试excel文档.xls".getBytes("UTF-8"), "iso-8859-1");    //生成word文件的文件名
            excelUtil.exportExcel(title, rowsName, dataList, fileName, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
