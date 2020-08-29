package com.sxt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootTest
class ApplicationRedisTemplateTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        System.out.println(redisTemplate);
        System.out.println(redisTemplate.getKeySerializer());
        System.out.println(redisTemplate.getValueSerializer());
    }
    @Test
    void testString(){
        //这是设置key的序列化方式   因为RedisTemplate<Object,Object> 如果传String key会被当做object进么序列化
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations opsForValue = redisTemplate.opsForValue();
        //opsForValue.set("user:1".toString(),new User(1,"xiaoming","wh",new Date()));
        User user = (User) opsForValue.get("user:1");
        System.out.println(user);
        System.out.println("操作成功");
    }
    @Test
    void testString2(){
        //这是设置key的序列化方式   因为RedisTemplate<Object,Object> 如果传String key会被当做object进么序列化
        this.redisTemplate.setKeySerializer(new StringRedisSerializer());
        this.redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        ValueOperations opsForValue = redisTemplate.opsForValue();
        //opsForValue.set("user:2".toString(),new User(1,"xiaoming","wh",new Date()));
        User user = (User) opsForValue.get("user:2");
        System.out.println(user);
        System.out.println("操作成功");
    }
}
