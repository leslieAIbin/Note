package com.sxt.cache;

import com.alibaba.fastjson.JSON;
import com.sxt.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.Serializable;

/**
 * @program: redis-code
 * @author: 雷哥
 * @create: 2019-12-31 16:39
 **/
@Component
@Aspect
@EnableAspectJAutoProxy
public class CacheUserAspect {


    private Log log= LogFactory.getLog(CacheUserAspect.class);

    public static final String POINTCUT_ADD="execution(* com.sxt.service.impl.UserServiceImpl.insert(..))";
    public static final String POINTCUT_UPDATE="execution(* com.sxt.service.impl.UserServiceImpl.updateByPrimaryKey(..))";
    public static final String POINTCUT_DELETE="execution(* com.sxt.service.impl.UserServiceImpl.deleteByPrimaryKey(..))";
    public static final String POINTCUT_GETONE="execution(* com.sxt.service.impl.UserServiceImpl.selectByPrimaryKey(..))";

    //redis里面的前缀
    public static final String PROFIX="user:";

    //注入JedisPool
    @Autowired
    private JedisPool jedisPool;



    @Around(value = CacheUserAspect.POINTCUT_ADD)
    public Object cacheAddUser(ProceedingJoinPoint pjp) throws Throwable {
        //插入数据库
        User user = (User) pjp.proceed();
        Jedis jedis = jedisPool.getResource();

        //把user转成json串
        String json= JSON.toJSONString(user);
        jedis.set(PROFIX+user.getId(),json);
        log.info(PROFIX+user.getId()+"数据已存入到Redis");
        jedis.close();
        return user;
    }

    @Around(value = CacheUserAspect.POINTCUT_UPDATE)
    public Object cacheUpdateUser(ProceedingJoinPoint pjp) throws Throwable {
        //修改数据库
        User user = (User) pjp.proceed();
        Jedis jedis = jedisPool.getResource();
        //把user转成json串
        String json= JSON.toJSONString(user);
        jedis.set(PROFIX+user.getId(),json);
        log.info(PROFIX+user.getId()+"数据已更新到Redis");
        jedis.close();
        return user;
    }

    @Around(value = CacheUserAspect.POINTCUT_DELETE)
    public Object cacheDeleteUser(ProceedingJoinPoint pjp) throws Throwable {
        //删除数据库
        Serializable id = (Serializable) pjp.getArgs()[0];
        log.info(PROFIX+id+"数据库数据已删除");
        Jedis jedis = jedisPool.getResource();
        if(jedis.exists(PROFIX+id)){
            jedis.del(PROFIX+id);
            log.info(PROFIX+id+"数据已从Redis删除");
        }
        jedis.close();
        return id;
    }

    @Around(value = CacheUserAspect.POINTCUT_GETONE)
    public Object cacheGetOneUser(ProceedingJoinPoint pjp) throws Throwable {
        Serializable id = (Serializable) pjp.getArgs()[0];
        if(null==id){
            return null;
        }
        Jedis jedis = jedisPool.getResource();
        String json = jedis.get(PROFIX + id);
        if(null!=json){
            User user=JSON.parseObject(json,User.class);
            log.info(PROFIX+id+"已从redis里机查询到数据");
            jedis.close();
            return user;
        }else{
            log.info(PROFIX+id+"缓存里面没有数据，要从数据库里面查询");
            User user= (User) pjp.proceed();
            if(null!=user){
                jedis.set(PROFIX+user.getId(),JSON.toJSONString(user));
                log.info(PROFIX+id+"数据已存入redis");
            }
            jedis.close();
            return  user;
        }
    }








}
