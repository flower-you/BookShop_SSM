package com.wjh.dao.impl;

import com.wjh.bean.TUser;
import com.wjh.dao.RedisDao;
import com.wjh.util.RedisCallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.awt.*;
import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/1 11:21
 * Description:
 */
@Repository
public class RedisDaoImpl implements RedisDao {

    @Autowired
    private JedisPool jedisPool;


    @Override
    public boolean set(String key, String value) {

        Jedis jedis=null;
        try {
            jedis=getJedis();
            String result=jedis.set(key,value);
            if ("OK".equals(result)){
                return  true;
            }
        }
        finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return false;
    }

    @Override
    public boolean setEx(String key, String value, int seconds) {
        Jedis jedis=null;
        try {
            jedis=getJedis();
            String result=jedis.setex(key,seconds,value);
            if ("OK".equals(result)){
                return  true;
            }
        }
        finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return false;
    }


    @Override
    public String getRedisInfo() {
        return getJedis().info();
    }

    @Override
    public long hset(String key, String field, String value) {
        long result=0;
        Jedis jedis=null;
        try {
            jedis=getJedis();
            result=jedis.hset(key,field,value);
            return  result;
        }
        finally {
            if (jedis!=null){
                jedis.close();
            }
        }
    }

    @Override
    public String hget(String key, String field) {
        String result=null;
        Jedis jedis=null;
        try {
            jedis=getJedis();
            result=jedis.hget(key,field);
            return  result;
        }
        finally {
            if (jedis!=null){
                jedis.close();
            }
        }
    }

    @Override
    public String get(String key) {
        String result=null;
        Jedis jedis=null;
        try {
            jedis=getJedis();
            result=jedis.get(key);
            return  result;
        }
        finally {
            if (jedis!=null){
                jedis.close();
            }
        }
    }

    @Override
    public long expire(String key, int seconds) {
        long result=0;
        Jedis jedis=null;
        try {
            jedis=getJedis();
            result=jedis.expire(key,seconds);
            return result;
        }
        finally {
            if (jedis!=null){
                jedis.close();
            }
        }
    }

    @Override
    public long expire(String key) {
        long result=0;
        Jedis jedis=null;
        try {
            jedis=getJedis();
            result=jedis.ttl(key);
            return result;
        }
        finally {
            if (jedis!=null){
                jedis.close();
            }
        }
    }

    @Override
    public void executeRedisCallback(RedisCallBack redisCallBack) {
        Jedis jedis=null;
        try {
            jedis=null;
            redisCallBack.callBack(jedis);
        }
        finally{
            if(jedis!=null){
                jedis.close();
            }
        }
    }


    public Jedis getJedis(){
//        long startTime=System.currentTimeMillis();
        Jedis resource=jedisPool.getResource();
//        System.out.println(startTime+"开始获取jedis.......");
        return resource;
    }




}
