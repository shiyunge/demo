package com.exam.demo.test;

import com.exam.demo.util.ExportExcelUtil;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestExportExcelUtil {


    /**
     * 测试的数据类
     *
     * @param args 参数
     * @throws Exception 异常
     */
    public static void main(String[] args) throws Exception {
        ExportExcelUtil<Student> util = new ExportExcelUtil<Student>();//指定类型  反射的先后顺序需要固定按bean类型的先后的顺序去固定
        // 准备数据
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Student(111, "张三asdf", "男"));
            list.add(new Student(111, "李四asd", "男"));
            list.add(new Student(111, "王五", "女"));
        }
        //这中情况下只能表示集合
        String[] columnNames = {"ID", "姓名", "性别"};
        util.exportExcel("用户导出", columnNames, list, new FileOutputStream("E:/test.xls"), ExportExcelUtil.EXCEl_FILE_2003);
    }
}
