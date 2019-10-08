package com.epi.springbootlearn.springboot_learn.conf.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author：softwarekang
 * @Date: 2019/9/27 9:30
 **/
@Configuration
public class RedisClusterConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String redisNodes;

    @Bean
    public JedisCluster getJedisCluster() {
        String[] redisNodesTemp = redisNodes.split(",");
        Set<HostAndPort> nodes = new HashSet<>();
        for (String node : redisNodesTemp) {
            String[] arr = node.split(":");
            HostAndPort hostAndPort = new HostAndPort(arr[0], Integer.parseInt(arr[1]));
            nodes.add(hostAndPort);
        }
        JedisCluster jedisCluster = new JedisCluster(nodes);
        return jedisCluster;
    }
}

