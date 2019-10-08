package com.epi.springbootlearn.springboot_learn.dao.mapper;

import com.epi.springbootlearn.springboot_learn.moudle.User;
import com.epi.springbootlearn.springboot_learn.service.provider.UserProvider;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @Author：softwarekang
 * @Date: 2019/9/25 12:55
 **/
@Mapper
public interface UserMapper {

    @Select("select id, name, age, create_time, update_time from user where name = #{name}")
    List<User> selectUserByName(@Param(value = "name") String name);

    @Insert("insert into user(name, age, create_time) values(#{name}, #{age}, #{createTime})")
    int createUser(@Param(value = "name") String name, @Param(value = "age") Integer age, @Param(value = "createTime") Date createTime);

    @Insert("insert into user(name,age,create_time) values(#{name},  #{age}, #{createTime})")
    int insertUser(User user);

    @Delete("delete from user where name = #{name}")
    int deleteByName(@Param(value = "name") String name);

    @Delete("delete from user where name = #{name}")
    int deleteByUserName(User user);

    @Results({
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "updateTime", column = "update_time")
    })
    @Select("select id, name, age, create_time, update_time from user where name = #{name}" )
    List<User> selectByName(@Param(value = "name")String name);

    // 动态SQl编写S
    @SelectProvider(type = UserProvider.class, method = "selectUserById")
    List<User> getUserByIds(@Param(value = "ids") List<Integer> ids);

    // 删除无
}
