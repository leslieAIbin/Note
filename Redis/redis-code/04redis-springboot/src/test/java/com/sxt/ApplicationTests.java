package com.sxt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;

import java.util.Collection;
import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        System.out.println(redisTemplate);
    }

    @Test
    void flushdb(){
        redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushAll();
                connection.flushDb();
                return "ok";
            }
        });
    }

    @Test
    void testNormal(){
        redisTemplate.keys("*");
        redisTemplate.multi();
        redisTemplate.exec();
        redisTemplate.watch("");
        redisTemplate.unwatch();
        redisTemplate.delete("k1");
        Collection<String> keys=null;
        redisTemplate.delete(keys);
        redisTemplate.randomKey();
        redisTemplate.rename("oldKey","newKey");
        redisTemplate.discard();

        //
        redisTemplate.getStringSerializer(); //指redis key序列化方式
        redisTemplate.getValueSerializer();  //指值的序列化方式
        redisTemplate.getHashKeySerializer();//指hash  Vlaue的 key序列化方式  hset(key,key,value)
        redisTemplate.getHashValueSerializer();//指hash  Vlaue的 value序列化方式


    }

    @Test
    void testString(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        //System.out.println(redisTemplate.getKeySerializer());
        //System.out.println(redisTemplate.getValueSerializer());

        //其它方法集
        RedisOperations<String, String> operations = opsForValue.getOperations();
//        opsForValue.get("");
//        opsForValue.set("","");
//        opsForValue.setIfPresent("","");
//        opsForValue.increment("");
//        opsForValue.decrement("");
//        opsForValue.set("name","xiaoming");
        System.out.println(opsForValue.get("name"));
        System.out.println("--------------------------");

        System.out.println("操作完成");
    }

    @Test
    void testList(){
        ListOperations<String, String> opsForList = this.redisTemplate.opsForList();

        RedisOperations<String, String> operations = opsForList.getOperations();

        opsForList.leftPush("","");
        opsForList.leftPushAll("","","","");
        opsForList.rightPush("","");
        opsForList.rightPushAll("","");
        opsForList.leftPop("");
        opsForList.rightPop("");


        List<String> key = opsForList.range("key", 0, -1);

    }

    @Test
    void testHash(){
        HashOperations<String, Object, Object> opsForHash = this.redisTemplate.opsForHash();

        opsForHash.put("","hashKey","value");

        opsForHash.get("","hashKey");

    }

    @Test
    void testSet(){
        SetOperations<String, String> opsForSet = this.redisTemplate.opsForSet();
        opsForSet.add("","");
        opsForSet.members("");

    }

    @Test
    void testZset(){
        ZSetOperations<String, String> opsForZSet = this.redisTemplate.opsForZSet();
        opsForZSet.add("key","value",1);

    }


    /**
     * 集群操作
     */
    @Test
    void test(){
        ClusterOperations<String, String> clusterOperations = this.redisTemplate.opsForCluster();
    }

}
