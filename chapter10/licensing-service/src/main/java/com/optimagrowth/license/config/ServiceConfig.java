package com.optimagrowth.license.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ServiceConfig{

    @Value("${example.property}")
    private String exampleProperty;

    @Value("${redis.host}")
    private String redisServer="";

    @Value("${redis.port}")
    private String redisPort="";

}
