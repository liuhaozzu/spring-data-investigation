package com.liuhaozzu.spring.data.investigation.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.stereotype.Component;

@Component
public interface AutoClosableRedisConnection extends RedisConnection, AutoCloseable {

}
