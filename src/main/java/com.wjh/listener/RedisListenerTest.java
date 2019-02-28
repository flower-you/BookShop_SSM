package com.wjh.listener;

/**
 * Author:   17976
 * Date:     2019/2/23 22:26
 * Description: 测试redis key超时
 */
import com.wjh.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisListenerTest {

    public static void main(String[] args){
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "116.62.140.147",6379);
        Jedis jedis = pool.getResource();
        jedis.auth("flower");
        jedis.select(0);
        jedis.set("testOrder", "你还在吗");
        jedis.expire("notify", 5);

        jedis.select(1);
        jedis.set("test","test");
        jedis.expire("test", 10);
    }
}
