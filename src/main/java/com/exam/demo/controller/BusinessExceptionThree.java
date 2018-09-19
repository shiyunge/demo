package com.exam.demo.controller;

import com.exam.demo.bean.PO.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author syg
 * @Date ${Date}  web页面上对于异常的处理机制
 * @Description **
 */

@RestController
public class BusinessExceptionThree {

    @RequestMapping("/exception1")
    public void doException() {
        Student stu = null;
        String name = stu.getName();
    }


}
