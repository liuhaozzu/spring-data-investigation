package com.liuhaozzu.spring.data.investigation.redis.service;


import com.liuhaozzu.spring.data.investigation.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {
    private static final Logger LOGGER_HELPER = LoggerFactory.getLogger(RedisServiceTest.class);

    @Autowired
    private RedisService redisService;

    @Test
    public void testSetEx() {
        try {
            redisService.setEx("abc", "test", 3000, "testValue");
            LOGGER_HELPER.info(redisService.get("01", "test"));
            assertEquals(redisService.get("01","test"), "testValue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
