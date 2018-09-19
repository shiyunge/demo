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

    /**
     * 处理非自定义异常  这里是运行时的异常
     *
     * @param
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerRuntimeException() {
        Map<String, Object> result = new HashMap<>();
        result.put("message", "服务器出现异常了啊,请稍后再尝试哦");
        result.put("code", "500");//这边的话需要自己手动去写 因为没有对应的构造方法
        return result;
    }
}
