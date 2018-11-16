package com.exam.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;

import java.io.OutputStream;
import java.util.Collection;

/**
 * Created by syg on 2018-11-16
 */
public class ExportExcelUtil<T> {

    //2007 版本以上 最大支持1048576行
    private final static String EXCEl_FILE_2007 = "2007";
    // 2003 版本 最大支持65536 行
    private final static String EXCEl_FILE_2003 = "2003";

    /**
     * 导出无头部信息excel
     *
     * @param title   表格标题
     * @param data    数据
     * @param out     输出流
     * @param version excel版本 2003或者2007 不传默认的是2003版本
     */
    public void exportExcel(String title, Collection<T> data, OutputStream out, String version) {
        if (JudgeEmptyUtil.StringEmpty(version) || EXCEl_FILE_2003.equals(version)) {
            exportExcel2003(title, null, data, out, "yyyy-MM-dd HH:mm:ss");
        } else {
            exportExcel2007(title, null, data, out, "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 导出有头部信息excel
     *
     * @param title   表格标题
     * @param data    数据
     * @param out     输出流
     * @param version excel版本 2003或者2007 不传默认的是2003版本
     */
    public void exportExcel(String title, String[] headers, Collection<T> data, OutputStream out, String version) {
        if (StringUtils.isBlank(version) || EXCEl_FILE_2003.equals(version)) {
            exportExcel2003(title, headers, data, out, "yyyy-MM-dd HH:mm:ss");
        } else {
            exportExcel2007(title, headers, data, out, "yyyy-MM-dd HH:mm:ss");
        }

    }

    /**
     * 2007版本以上
     */
    public void exportExcel2007(String title, String[] headers, Collection<T> data, OutputStream out, String version) {
        //声明一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //生成一个表格 循环的话可以生成多个excel表格 方法重载参数为表格名
        XSSFSheet sheet = workbook.createSheet();
        //设置标的列的默认宽度为15个字节
        sheet.setDefaultColumnWidth(20);

        //生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(new XSSFColor(java.awt.Color.gray));//灰色 单元格背景
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);//单元格底边框横线加黑 下面以此类推
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);

        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        font.setFontName("宋体");
        font.setColor(new XSSFColor(java.awt.Color.BLACK));//字体颜色设置成黑色 其他不需要的可以不去设置
        font.setFontHeightInPoints((short)11);//设置字体大小
        //样式应用字体
        style.setFont(font);

        // 生成并设置另一个样式 样式二
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(new XSSFColor(java.awt.Color.WHITE));
        style2.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        XSSFFont font2 = workbook.createFont();
        font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);//粗体显示
        // 把字体应用到当前的样式
        style2.setFont(font2);











    }


}
