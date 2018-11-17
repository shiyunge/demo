package com.exam.demo.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Collection;

public class ExportExcelWrapper<T> extends ExportExcelUtil {

    /* 根据Java的继承思想，我们不在ExportExcelUtil类上修改添加，我们创建一个ExportExcelUtil类的子类ExportExcelWrapper，
    这个类继承ExportExcelUtil的所有功能，同时，扩展了网页生成Excel的功能*/
    public void exportExcel(String fileName, String title, String[] headers, Collection<T> dataset, HttpServletResponse response, String version) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8") + ".xls");
            if(StringUtils.isBlank(version) || EXCEl_FILE_2003.equals(version.trim())){
                exportExcel2003(title, headers, dataset, response.getOutputStream(), "yyyy-MM-dd hh:mm:ss");
            }else{
                exportExcel2007(title, headers, dataset, response.getOutputStream(), "yyyy-MM-dd hh:mm:ss");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
