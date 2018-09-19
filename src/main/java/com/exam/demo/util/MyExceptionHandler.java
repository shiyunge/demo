package com.exam.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author syg
 * @Date 2018-9-19
 * @Description **
 */
@RestControllerAdvice
public class MyExceptionHandler {
    //internal server error 内部服务器异常
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerMyRuntimeException(BusinessException b) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", b.getMessage());
        result.put("code", b.getCode());
        return result;
    }
}
