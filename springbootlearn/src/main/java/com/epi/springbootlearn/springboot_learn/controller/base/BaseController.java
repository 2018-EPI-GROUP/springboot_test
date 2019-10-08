package com.epi.springbootlearn.springboot_learn.controller.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：softwarekang
 * @Date: 2019/9/23 11:02
 **/
@ControllerAdvice
public class BaseController {
    private final static Logger logger = LoggerFactory.getLogger(BaseController.class);

    // 全局异常处理等
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handlerException() {

        return "success";
    }
}
