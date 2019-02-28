package com.wjh.service.impl;

import com.alibaba.fastjson.JSON;
import com.wjh.bean.TShopcar;
import com.wjh.dao.RedisDao;
import com.wjh.dao.mapper.TShopcarMapper;
import com.wjh.service.ICarService;
import com.wjh.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Date;
import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/11 19:33
 * Description: 购物车实现类
 */
@Service
public class CarServiceImpl implements ICarService {
    @Autowired
    private TShopcarMapper tShopcarMapper;

    @Autowired
    private RedisDao redisDao;

    @Override
    public boolean addBook(TShopcar tShopcar) {
        int num = tShopcar.getNum();
        //在查询Mysql之前先从redis中去查，redis中查询出的结果为空再到mysql去查,然后将mysql中查询的结果缓存到redis中
        String rbook=redisDao.hget("car"+tShopcar.getUid(),tShopcar.getBid().toString());
        if (rbook==null||rbook.equals("nil")){//如果redis中不存在该商品那么在mysql中去查，查完之后将结果添加到redis中
            TShopcar bookInCar=tShopcarMapper.selectSelective(tShopcar);
            if (bookInCar!=null){
                //说明购物车中已经存在该类商品，此时只需要更新这个商品的数量
                tShopcar.setNum(num+bookInCar.getNum());
                tShopcarMapper.updateNum(tShopcar);
                bookInCar.setNum(num+bookInCar.getNum());
                redisDao.hset("car"+tShopcar.getUid(),tShopcar.getBid().toString(), JSON.toJSONString(bookInCar));
            }
            else{//购物车中不存在该商品，直接添加
                tShopcar.setNum(num);
                List<TShopcar> shopList=tShopcarMapper.selectCarByUid(tShopcar.getUid());
                int count=shopList.size();
                if (count>= Constants.CAR_MAX_SIZE){//购物车中的商品数量已达上限
                    return false;
                }
                tShopcarMapper.insert(tShopcar);
            }
        }
        else {//将从redis中查出来的结果更新到mysql中
            //将rbook转成TShopCar对象
            TShopcar bookInCar=JSON.parseObject(rbook,TShopcar.class);
            tShopcar.setNum(num+bookInCar.getNum());
            tShopcarMapper.updateNum(tShopcar);
            bookInCar.setNum(num+bookInCar.getNum());
            redisDao.hset("car"+tShopcar.getUid(),tShopcar.getBid().toString(), JSON.toJSONString(bookInCar));
        }
        return true;

    }

    @Override
    public List<TShopcar> QueryCar(int uid) {
        return tShopcarMapper.selectCarByUid(uid);
    }
}
