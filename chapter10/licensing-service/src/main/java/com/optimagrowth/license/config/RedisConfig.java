package com.optimagrowth.license.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.
        RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.
        JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

//@Configuration
//public class RedisConfig {
//    @Value("${jedis.host}")
//    private String redisHost;
//    @Value("${jedis.port}")
//    private Integer redisPort;
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
//       // redisStandaloneConfiguration.setPassword(RedisPassword.of("yourRedisPasswordIfAny"));
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//}
