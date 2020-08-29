package com.sxt;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final String HOST="192.168.72.137";
    public static final Integer HOST_IP=6379;

    public static void main( String[] args )
    {
        Jedis jedis=new Jedis(HOST,HOST_IP);
//        jedis.auth("123456");

        System.out.println(jedis);
        String ping = jedis.ping();
        System.out.println(ping);

        jedis.close();//一定要注意

    }
}
