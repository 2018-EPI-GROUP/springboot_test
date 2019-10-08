package com.epi.springbootlearn.springboot_learn.service.provider;

import com.epi.springbootlearn.springboot_learn.moudle.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：softwarekang
 * @Date: 2019/9/25 14:25
 **/
public class UserProvider {

    public String selectUserById(@Param(value = "ids") List<Integer> ids) {
        String selectIds = ids.stream().map(id -> id.toString()).collect(Collectors.joining(","));
        return "select id, name, age create_time,update_time from user where id in " + "(" + selectIds + ")";
    }
}
