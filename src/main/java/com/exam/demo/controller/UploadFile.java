package com.exam.demo.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadFile {
    @RequestMapping(value = "/uploadFile.do", produces = "text/html;charset=utf-8")
    public Map importPicFile1(@RequestParam MultipartFile file, HttpServletRequest request) {
        Map<String, Object> params = new HashMap<>();
        if (file.isEmpty()) {
            params.put("result", "error");
            params.put("msg", "文件上传不能为空");
        } else {
            String originalFileName = file.getOriginalFilename();
            System.out.println(originalFileName + "=originalFileName");
            String fileBaseName = FilenameUtils.getBaseName(originalFileName);
            System.out.println(fileBaseName + "=fileBaseName");
            SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //创建文件要上传的路径下面
            File file1 = new File("D://file");
            if (!file1.exists()) {
                file1.mkdirs();//区别
            }
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(file1, originalFileName));
                params.put("result", "success");
            } catch (IOException e) {
                e.printStackTrace();
                params.put("result", "error");
                params.put("msg", e.getMessage());
            }
        }
        return params;
    }
}
