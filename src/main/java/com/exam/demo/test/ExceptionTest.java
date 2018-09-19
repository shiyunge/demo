package com.exam.demo.test;

import com.exam.demo.util.BusinessException;

/**
 * @Author syg
 * @Date ${Date}
 * @Description **
 */
public class ExceptionTest {

    public static void main(String[] args) throws Exception{
        throw new BusinessException("我的第一个异常信息展示","300");
    }

}
