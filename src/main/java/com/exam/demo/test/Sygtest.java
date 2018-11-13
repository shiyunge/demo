package com.exam.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class Sygtest {

    @Value("${syg}")
    private String str;

    @Autowired
    private Sygtest sygtest;

    public String getStr() {
        return str;
    }


    public static void main(String[] args) {
    }
}
