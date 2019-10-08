package com.epi.springbootlearn.springboot_learn.service;

import javafx.scene.layout.BackgroundSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author：softwarekang
 * @Date: 2019/9/24 17:41
 **/
@Service
public class UserServiceImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 插入User
    public void create(String newName, Short newClass, Date newCreateTime) {
        jdbcTemplate.update("insert into  user(name, age,create_time) values (?,?,?)", newName, newClass, newCreateTime);
    }

    // 修改User
    public void update(String oldName, Short newClass) {
        jdbcTemplate.update("update user set age = ? where name = ? ", newClass, oldName);
    }
}
