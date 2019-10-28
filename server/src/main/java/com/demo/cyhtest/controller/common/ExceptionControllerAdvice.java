package com.demo.cyhtest.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: chenyuhao
 * @Date: 2019/10/28 17:24
 * @Version 1.0
 */
@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public GenericResponse<?> dealException(Exception e) {
        log.error("------系统异常，{}", e);
        return GenericResponse.err("");
    }

}
