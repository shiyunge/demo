package com.exam.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class demon {

    @RequestMapping("/")
    public String index() {
        return "这是我的第一个spring boot 的入门的例子";
    }

}
