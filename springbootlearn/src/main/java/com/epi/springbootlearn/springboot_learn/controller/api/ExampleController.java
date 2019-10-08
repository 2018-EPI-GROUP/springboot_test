package com.epi.springbootlearn.springboot_learn.controller.api;

import com.epi.springbootlearn.springboot_learn.moudle.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @Author：softwarekang
 * @Date: 2019/9/23 11:03
 **/
@Controller
public class ExampleController {

    // 获取User列表
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserList() {
        List<User> userList = null; //Arrays.asList(new User(10, "小李"), new User(20, "安康"), new User(20, "王昱"));
        return userList;
    }

    // 异常测试
    @RequestMapping("/exception")
    @ResponseBody
    public String throwException() throws Exception {
        throw new Exception("异常测试");
    }

}
