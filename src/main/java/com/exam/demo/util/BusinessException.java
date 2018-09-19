package com.exam.demo.util;

/**
 * @Author syg
 * @Date 2018-9-19
 * @Description 业务处理工具类  都是jdk提供的一些工具类RunTimeException
 */
public class BusinessException extends RuntimeException {

    private String code;//运行异常编码

    public BusinessException() {
        super();
    }

    public BusinessException(String code) {
        this.code = code;
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
