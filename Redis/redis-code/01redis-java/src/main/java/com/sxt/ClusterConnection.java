package com.sxt;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class ClusterConnection
{
    public static final String HOST="192.168.72.137";
    public static final Integer HOST_IP=7000;

    public static void main( String[] args )
    {
        Set<HostAndPort> nodes=new HashSet<>();
        nodes.add(new HostAndPort(HOST,7000));
        nodes.add(new HostAndPort(HOST,7001));
        nodes.add(new HostAndPort(HOST,7002));
        nodes.add(new HostAndPort(HOST,7003));
        nodes.add(new HostAndPort(HOST,7004));
        nodes.add(new HostAndPort(HOST,7005));
        JedisCluster jedisCluster=new JedisCluster(nodes);

        jedisCluster.set("name","xdd");

        System.out.println(jedisCluster.get("name"));
        jedisCluster.close();//一定要注意

    }
}
