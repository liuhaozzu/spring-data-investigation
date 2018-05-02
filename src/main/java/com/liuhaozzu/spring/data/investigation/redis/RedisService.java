package com.liuhaozzu.spring.data.investigation.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.stereotype.Component;

@Component
public class RedisService {
    private static final Logger LOGGER_HELPER = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisConnectionFactory connFactory;


    /**
     * @param logStr
     * @param key
     * @param expireInSecs
     * @param value
     * @throws Exception
     * @see RedisStringCommands#setEx(byte[], long, byte[])
     */
    public void setEx(String logStr, String key, int expireInSecs, String value) throws Exception {
        RedisConnection conn = connFactory.getConnection();
        LOGGER_HELPER.info(logStr, " act=setEx key=", key, " expire=", expireInSecs, " value=", value);
        try {
            if (key == null || value == null || expireInSecs <= 0) {
                LOGGER_HELPER.error("logstr=" + logStr + " act=setEx errMsg=key_or_value_must_not_be_null key=" + key + " value=" + value);
                return;
            }
            conn.setEx(key.getBytes(), expireInSecs, value.getBytes());
        } catch (Exception e) {
            LOGGER_HELPER.error(logStr, " act=setEx key=", key, " value=", value, " msg=", "redis_保存数据出现情_现发起一次重试 e=", e.toString());
            if (conn != null) {
                conn.close();
            }
            conn = connFactory.getConnection();
            conn.setEx(key.getBytes(), expireInSecs, value.getBytes());
        }
    }

    /**
     * @param key
     * @return
     * @throws Exception
     * @see RedisStringCommands#get(byte[])
     */
    public String get(String logStr, String key) throws Exception {
        RedisConnection conn = connFactory.getConnection();
        byte[] bytes = null;
        try {
            bytes = conn.get(key.getBytes());
        } finally {
            if (conn != null){
                conn.close();
            }
        }
        if (bytes == null) {
            LOGGER_HELPER.warn(logStr, " act=redis缓存无此key_可能是超时失效了");
            return null;
        }
        return new String(bytes);
    }
}
