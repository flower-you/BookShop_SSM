package com.wjh.util;

import redis.clients.jedis.Jedis;

/**
 * Author:   17976
 * Date:     2019/2/23 18:04
 * Description: 引入callback,封装细节，避免直接使用Jedis,出现资源不关闭的情况
 */
public interface RedisCallBack<T>{
    T callBack(Jedis jedis);
}
