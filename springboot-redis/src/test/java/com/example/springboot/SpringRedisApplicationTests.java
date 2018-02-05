package com.example.springboot;

import com.example.springboot.entity.Student;
import com.example.springboot.pubsub.Subcribe;
import com.example.springboot.redis.RedisHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringRedisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RedisHandler redisHandler;

    private static final String STUDENT_CACHE = "STUDENT_CACHE";

    @Test
    public void testSet() {
        Student student = Student.builder().name("张三").age(10).sex(1).idCard("111111111111111").build();
        redisHandler.set(STUDENT_CACHE, student);
    }


    @Test
    public void testGet() {
        Student student = redisHandler.get(STUDENT_CACHE, Student.class);
        log.info(student.toString());
    }


    @Test
    public void testSubcribe() {
        redisHandler.publish(Subcribe.CHANNEL_TOPIC_1, "something published into CHANNEL_TOPIC_1...");
        redisHandler.publish(Subcribe.CHANNEL_TOPIC_2, "something published into CHANNEL_TOPIC_2...");
    }
}
