package com.exam.demo.controller;


import com.exam.demo.test.Student;
import com.exam.demo.util.ExportExcelUtil;
import com.exam.demo.util.ExportExcelWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestExportController {

    @RequestMapping("/get/excel")
    public void getExcel(HttpServletResponse response) throws Exception {
        // 准备数据 导出的名字自己需要额外填上 注意ajax上面不好response  所以的话先上是你上传然后在去下载
        //参考考试的导入导出 打住
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111, "张三asdf", "男"));
            list.add(new Student(111, "李四asd", "男"));
            list.add(new Student(111, "王五", "女"));
        }
        String[] columnNames = {"ID", "姓名", " 性别"};
        String fileName = "excel1";
        ExportExcelWrapper<Student> util = new ExportExcelWrapper<Student>();
        util.exportExcel(fileName, fileName, columnNames, list, response, ExportExcelUtil.EXCEl_FILE_2003);
    }
}
