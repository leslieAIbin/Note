package com.sxt;

import com.alibaba.fastjson.JSON;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @program: redis-code
 * @author: 雷哥
 * @create: 2019-12-31 14:33
 **/

public class JedisPoolApp2 {

    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig=new GenericObjectPoolConfig();
        //配置连接池的相关信息
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxIdle(80);
        poolConfig.setMinIdle(20);
        poolConfig.setMaxWaitMillis(2000);
        JedisPool jedisPool=new JedisPool(poolConfig,"192.168.72.137",6379);
        //从连接池里面得到连接
        Jedis jedis = jedisPool.getResource();
        User user =new User("小明","武汉");

        jedis.set("user:1", JSON.toJSONString(user));

        String json = jedis.get("user:1");
        System.out.println(json);
        User user1=JSON.parseObject(json,User.class);
        System.out.println(user1.getName()+"  "+user1.getAddress());
        jedis.close();//还到池里面
    }
}
