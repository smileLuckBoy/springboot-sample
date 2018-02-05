package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import static com.example.springboot.pubsub.Subcribe.CHANNEL_TOPIC_1;
import static com.example.springboot.pubsub.Subcribe.CHANNEL_TOPIC_2;

/**
 * @author wangmin
 * @version OmniPrime.All rights reserved.
 * @Comments
 * @since 2017/12/8
 */

@Configuration
public class Lanuncher implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    RedisMessageListenerContainer container;

    @Autowired
    MessageListenerAdapter listenerAdapter1;

    @Autowired
    MessageListenerAdapter listenerAdapter2;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Topic topic = new ChannelTopic(CHANNEL_TOPIC_1);
        container.addMessageListener(listenerAdapter1, topic);

        topic = new ChannelTopic(CHANNEL_TOPIC_2);
        container.addMessageListener(listenerAdapter2, topic);
    }


}
