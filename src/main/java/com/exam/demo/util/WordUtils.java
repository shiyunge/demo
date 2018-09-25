package com.exam.demo.util;

import com.exam.demo.pojo.Co;
import com.exam.demo.pojo.Idx;
import com.exam.demo.pojo.Table;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordUtils {

    //配置信息
    private static Configuration configuration;
    private static Template template;
    //这里注意的是利用WordUtils的类加载器动态获得模板文件的位置
    // private static final String templateFolder = WordUtils.class.getClassLoader().getResource("../../").getPath() + "WEB-INF/templetes/";

    static {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
    }

    //这里可以去学习一下类的加顺序 这个要注意一下
    public void exportMillCertificateWord( HttpServletResponse
            response, Map map, String title) throws IOException {
        configuration.setClassForTemplateLoading(WordUtils.class, "/template");
        String templateFolder = " E:/syggit/demo/src/main/java/com/exam/demo/util/template";
        configuration.setDirectoryForTemplateLoading(new File(templateFolder));
        template = configuration.getTemplate("/test.ftl");
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类的createDoc方法生成Word文档
            file = createDoc(map, template);
            fin = new FileInputStream(file);

            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件名
            String fileName = title /*+ DateUtil.formatDateDetailTime(new Date())*/ + ".doc";
            response.setHeader("Content-Disposition", "attachment;filename="
                    .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));

            out = response.getOutputStream();
            byte[] buffer = new byte[512];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } finally {
            if (fin != null) fin.close();
            if (out != null) out.close();
            if (file != null) file.delete(); // 删除临时文件
        }

    }

    //??????????????
    private static File createDoc(Map<?, ?> dataMap, Template template) {
        String name = "sellPlan.doc";
        File f = new File(name);
        Template t = template;
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }

    public void data2Word() {
        //要填写的模板数据 只能是这样的数据类型
        Map<String, Object> params = new HashMap<>();
        getData(params);
        //加载模板


        //输出文档的路径和名称
        File file = new File("D:/outword1.doc");
        Writer wt = null;
        try {
            wt = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //把内容输出到页面上去
        try {
            template.process(params, wt);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 需要注意的是params里面的key 的值一定要和模板里面的参数相对应
     *
     * @param params
     */
    private void getData(Map<String, Object> params) {

        List list = new ArrayList();
        for (int j = 0; j < 3; j++) {

            Table tb = new Table();
            tb.setNo("1." + j);
            tb.setTb_name("T_SYS_USER" + j);
            tb.setTb_comment("系统用户表" + j);


            List cols = new ArrayList();
            for (int i = 0; i < 5; i++) {
                Co col = new Co();
                col.setCol_name("ID" + i);
                col.setCol_comment("序号" + i);
                col.setCol_datatype("VARCHAR2(20)");
                col.setP_enable("Y");
                col.setM_enable("Y");
                col.setF_enable("N");
                col.setU_enable("N");
                col.setC_enable("N");
                cols.add(col);
            }

            params.put("cols", cols);

            List idxs = new ArrayList();
            for (int i = 0; i < 2; i++) {
                Idx idx = new Idx();
                idx.setContents("CREATE INDEX index_name" + i
                        + " on table_name (col_name" + i + ")");
                idxs.add(idx);
            }

            params.put("idxs", idxs);

            list.add(tb);
        }
        params.put("tbs", list);
    }

}
