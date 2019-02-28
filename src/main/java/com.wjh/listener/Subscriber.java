package com.wjh.listener;

import com.wjh.dao.RedisDao;
import com.wjh.dao.impl.RedisDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/23 22:29
 * Description: redis订阅程序
 */
@Configuration
public class Subscriber {
    @Autowired
    private RedisDao redisDao;

    @PostConstruct
    public void doSubscribe() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Jedis jedis=redisDao.getJedis();
                    jedis.auth("flower");
//        config(jedis);
//        只订阅patten匹配的超时事件
                    System.out.println("开始订阅..........");
                    jedis.psubscribe(new KeyExpiredListener(), "__key*@0__:expired");
                    break;
                }
            }
        }.start();
    }
    private static void config(Jedis jedis) {
        String parameter = "notify-keyspace-events";
        List<String> notify = jedis.configGet(parameter);
        if (notify.get(1).equals("")) {
            jedis.configSet(parameter, "Ex"); //过期事件
        }
    }
}
