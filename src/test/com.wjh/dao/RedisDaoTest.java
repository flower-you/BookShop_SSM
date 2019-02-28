package com.wjh.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/11 10:21
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class RedisDaoTest {
    @Autowired
    private RedisDao redisDao;
    @Test
    public void testSet(){
        System.out.println(redisDao);
       System.out.println( redisDao.set("set","test"));
    }

    @Test
    public void testWatch(){
        int uid=9;
        int bid=15;
        Jedis jedis=redisDao.getJedis();
        String watch=jedis.watch("car"+uid);
        long startTime=System.currentTimeMillis();
        System.out.println(startTime+"----开始监听-------");
        Transaction ts=jedis.multi();

        Response<String> rs=ts.hget("car",""+bid);

        System.out.println(rs.toString());
        List<Object> lb=ts.exec();
        if (lb.size()>0&&lb!=null){
            for (Object object:lb){
                if (object!=null){
                    System.out.println(object.toString());
                }
            }
        }
        jedis.unwatch();
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime+"----监听结束--------");
        jedis.close();

    }
}
