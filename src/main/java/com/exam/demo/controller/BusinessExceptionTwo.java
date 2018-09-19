package com.exam.demo.controller;

import com.exam.demo.util.BusinessException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author syg
 * @Date ${Date}  web页面上对于异常的处理机制
 * @Description **
 */

@RestController
public class BusinessExceptionTwo {

    @RequestMapping("/exception")
    public void doException() {
        throw new BusinessException("异常处理", "520");
    }


}
