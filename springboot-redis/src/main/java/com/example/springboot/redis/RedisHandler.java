package com.example.springboot.redis;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @author wangmin
 * @Comments
 * @since 2017/10/22
 */
@Service
public class RedisHandler {

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public RedisHandler(StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = stringRedisTemplate;
    }

    /**
     * SET
     *
     * @param key
     * @param value
     * @param <T>
     */
    public <T> void set(String key, T value) {
        if (ObjectUtils.isEmpty(value)) return;
        redisTemplate.opsForValue().set(key, JSONObject.toJSONString(value));
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        String jsonStr = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(jsonStr)) return null;
        return JSONObject.parseObject(jsonStr, clazz);
    }
}
