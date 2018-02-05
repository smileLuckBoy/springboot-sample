package com.example.springboot.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author wangmin
 * @version OmniPrime.All rights reserved.
 * @Comments
 * @since 2018/2/5
 */
@Configuration
public class Subcribe {

    public static final String CHANNEL_TOPIC_1 = "CHANNEL_TOPIC_1";
    public static final String CHANNEL_TOPIC_2 = "CHANNEL_TOPIC_2";

    private final StringRedisTemplate redisTemplate;

    @Autowired
    public Subcribe(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Bean
    MessageListenerAdapter listenerAdapter1() {
        return new MessageListenerAdapter(new Receiver1(), "handleMessage");
    }

    @Bean
    MessageListenerAdapter listenerAdapter2() {
        return new MessageListenerAdapter(new Receiver2(), "handleMessage");
    }

    @Bean
    RedisMessageListenerContainer container() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisTemplate.getConnectionFactory());

        return container;
    }
}
