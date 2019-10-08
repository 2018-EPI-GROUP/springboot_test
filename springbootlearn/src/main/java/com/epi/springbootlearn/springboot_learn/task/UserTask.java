package com.epi.springbootlearn.springboot_learn.task;

import com.epi.springbootlearn.springboot_learn.dao.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author：softwarekang
 * @Date: 2019/9/25 15:43
 **/
// 定时任务
@Component
public class UserTask {

    private static final Logger log = LoggerFactory.getLogger(UserTask.class);
    @Autowired
    private UserMapper userMapper;

    @Scheduled(fixedRate = 1000 * 60)
    public void deleteUserTableByName() {
        userMapper.deleteByName("王昱");
        log.info("task 删除任务执行完成");
    }

}
