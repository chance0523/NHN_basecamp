package com.godo.redis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    // 기본
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 특정 오퍼레이션 직접 주입
    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valueOps;


    /**
     * String Operation의 set 커맨드
     *
     * @param key   Redis Key
     * @param value key에 저장될 value
     */
    public void setStringValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * String Operation의 get 커맨드
     *
     * @param key Redis Key
     */
    public String getStringValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

}