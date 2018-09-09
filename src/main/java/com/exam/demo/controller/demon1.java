package com.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class demon1 {
    @RequestMapping("/ceshi")
    public String index() {
        return "test";
    }
}
