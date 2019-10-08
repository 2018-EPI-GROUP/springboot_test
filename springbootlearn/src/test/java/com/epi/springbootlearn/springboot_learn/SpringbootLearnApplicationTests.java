package com.epi.springbootlearn.springboot_learn;

import com.epi.springbootlearn.springboot_learn.common.utils.HttpUntil;
import com.epi.springbootlearn.springboot_learn.dao.mapper.UserMapper;
import com.epi.springbootlearn.springboot_learn.moudle.User;
import com.epi.springbootlearn.springboot_learn.service.UserServiceImpl;
import com.epi.springbootlearn.springboot_learn.service.jpa.UserJpaRes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearnApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(SpringbootLearnApplicationTests.class);
    @Autowired
    private UserServiceImpl userService;

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserJpaRes userJpaRes;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "redisTemplate")
    private RedisTemplate userRedisTemplate;

    @Autowired
    private JedisCluster jedisCluster;

    @Resource
    private JavaMailSender javaMailSender;


    @Test
    public void contextLoads() {

    }

    // 健康测试
    @Test
    public void testHealthCheck() {
        String res = HttpUntil.sendGet("http://localhost/health_check", "");
        System.out.println(res);
    }

    // jdbcTemple测试
    @Test
    public void testJdbcTemple() {
        String newName = "王昱";
        Short newClass = 2019;
        userService.create(newName, newClass, new Date());
    }

    @Test
    public void testUpdate() {
        String oldName = "安康";
        Short newClass = 2000;
        userService.update(oldName, newClass);
    }

    @Test
    public void testJpaFindByName() {
        userJpaRes.findByName("安康").stream().forEach(System.out::println);
    }

    @Test
    public void testJpaFindByNameAndAge() {
        userJpaRes.findByNameAndAge("安康", 2000).stream().forEach(System.out::println);
    }


    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("an", "000");
        ValueOperations<String, User> valueOperations = userRedisTemplate.opsForValue();
        User user = new User();
        user.setAge(20);
        user.setName("ankang");
        userRedisTemplate.setKeySerializer(new StringRedisSerializer());
        userRedisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        valueOperations.set("softwarekang", user);
    }

    @Test
    public void testGetRedis() {
        userRedisTemplate.setKeySerializer(new StringRedisSerializer());
        userRedisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        System.out.println(userRedisTemplate.opsForValue().get("softwarekang"));
    }

    @Test
    public void testLogback() {
        log.info("aaaaaaaaaaaa");
        log.error("bbbbbbbbbb");
    }

    @Test
    public void testMybatis() {
        userMapper.createUser("王昱", 2000, new Date());
        userMapper.selectUserByName("安康").stream().forEach(System.out::println);
    }

    @Test
    @Rollback(value = true)
    public void testMybatisInsert() {
        User user = new User();
        user.setName("夏利");
        user.setAge(30);
        user.setCreateTime(new Date());
        System.out.println(userMapper.insertUser(user));
        userMapper.deleteByUserName(user);
    }

    @Test
    public void testMybatisSelectList() {
        userMapper.selectByName("安康").stream().forEach(System.out::println);
    }

    @Test
    public void testMybatisProvider() {
        userMapper.getUserByIds(Arrays.asList(1,2,4)).stream().forEach(System.out::println);
    }

    @Test
    public void testRedisCluster() {
        jedisCluster.set("11", "22");

        new HostAndPort("112", 50);
    }

    @Test
    public void testMail() throws Exception{
        final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setFrom("1214072754@qq.com");
        message.setTo("1471445331@qq.com");
        message.setSubject("我是你爷爷");
        message.setText("aaa");
        this.javaMailSender.send(mimeMessage);
    }
}
