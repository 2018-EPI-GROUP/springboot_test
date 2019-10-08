package com.epi.springbootlearn.springboot_learn.controller.base;

import com.epi.springbootlearn.springboot_learn.controller.api.ExampleController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：softwarekang
 * @Date: 2019/9/23 21:46
 **/
@ControllerAdvice(basePackageClasses = ExampleController.class)
public class ExampleControllerAdvice {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handlerController() {
        return "false";
    }
}
