package com.epi.springbootlearn.springboot_learn.controller.monitor;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author：softwarekang
 * @Date: 2019/9/23 10:58
 **/
@Controller
@EnableAutoConfiguration
public class MonitorApiController {

    @RequestMapping("/health_check")
    @ResponseBody
    public String check() {
        return "success";
    }
}
