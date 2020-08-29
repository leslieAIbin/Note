package com.sxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Hello world!
 *
 */
public class TestRedisApp
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("classpath:application-*.xml");

        JedisPool jedisPool = context.getBean(JedisPool.class);

        Jedis jedis = jedisPool.getResource();
        String name = jedis.set("name", "xiaoming");
        System.out.println(name);


        System.out.println(jedis.get("name"));
        jedis.close();


    }
}
