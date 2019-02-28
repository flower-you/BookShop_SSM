package com.wjh.dao;

import com.wjh.bean.TUser;
import com.wjh.util.RedisCallBack;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Author:   17976
 * Date:     2019/2/1 10:57
 * Description: redisdao
 */
public interface RedisDao {

    public Jedis getJedis();

    public boolean set(String key,String value);

    /**
     * 设置键过期时间
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public boolean setEx(String key,String value,int seconds);

    public String getRedisInfo();

    public long hset(String key,String field,String value);

    public  String hget(String key,String field);

    public String get(String key);

    /**
     *设置Key过期时间，成功返回1，key永久生存或者不存在的都返回-1
     * @param key
     * @param seconds
     * @return
     */
    public long expire(String key,int seconds);

    /**
     * 查询Key过期时间，成功返回过期时间，单位：s，key永久生存返回-1
     * @param key
     * @return
     */
    public long expire(String key);

    public void executeRedisCallback(RedisCallBack redisCallBack);


}
