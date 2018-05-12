package com.liuhaozzu.spring.data.investigation.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;

import java.util.Collection;

/**
 * Created by Administrator on 2018/5/8 0008.
 */
public class AppCacheManager implements CacheManager{
    private CacheManager redisCacheManager;
    private CacheManager ehCacheManager;
    public void setRedisCacheManager(RedisCacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }

    @Override
    public Cache getCache(String name) {
        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        return null;
    }
    public CacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public void setRedisCacheManager(CacheManager redisCacheManager) {
        this.redisCacheManager = redisCacheManager;
    }

    public CacheManager getEhCacheCacheManager() {
        return ehCacheManager;
    }

    public void setEhCacheCacheManager(CacheManager ehcacheCacheManager) {
        this.ehCacheManager = ehcacheCacheManager;
    }
}
