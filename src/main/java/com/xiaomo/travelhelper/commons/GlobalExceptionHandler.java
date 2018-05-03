package com.xiaomo.travelhelper.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public ResultMessage exceptionHandler(HttpServletRequest req, Exception e) {

        e.printStackTrace();
        return ResultMessage.buildByFail(e.getMessage());
    }

}
