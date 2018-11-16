package com.exam.demo.test;

import com.exam.demo.util.JudgeEmptyUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by syg on 2018-11-16
 */
public class JudgeEmpty {


    public static void main(String[] args) {
        String str = "";
        String str1 = null;
        System.out.print(JudgeEmptyUtil.StringEmpty(str));
        System.out.print(JudgeEmptyUtil.ObjectEmpty(str));
        System.out.print("======================================");
        Object object = new Object();
        System.out.print(JudgeEmptyUtil.ObjectEmpty(object));
        System.out.print("======================================");
        List lsit = new ArrayList();
        System.out.print(JudgeEmptyUtil.ArrayListEmpty(lsit));
        Map<String,Object> params = new HashMap<>();
        System.out.print("======================================");
        System.out.print(JudgeEmptyUtil.MapEmpty(params));

    }
}
