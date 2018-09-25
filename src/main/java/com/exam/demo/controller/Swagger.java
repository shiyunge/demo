package com.exam.demo.controller;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "swagger测试", description = "对于swagger2的第一个基本的列子")
@RestController
@RequestMapping("/cn/syg/ceshi")
public class Swagger {

    @RequestMapping(value = "ceshi", method = RequestMethod.POST)
    public String ceshi() {
        return "abcde";
    }


}
