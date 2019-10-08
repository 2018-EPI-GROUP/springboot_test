package com.epi.springbootlearn.springboot_learn.service.jpa;

import com.epi.springbootlearn.springboot_learn.moudle.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author：softwarekang
 * @Date: 2019/9/24 20:19
 **/
public interface UserJpaRes extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
    List<User> findByNameAndAge(String name, Integer age);
}
