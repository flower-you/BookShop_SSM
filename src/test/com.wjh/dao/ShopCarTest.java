package com.wjh.dao;

import com.alibaba.fastjson.JSON;
import com.wjh.bean.TShopcar;
import com.wjh.dao.mapper.TShopcarMapper;
//import net.sf.json.JSON;
//import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/11 17:10
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class ShopCarTest {
    @Autowired
    private TShopcarMapper tShopcarMapper;

    @Test
    public void testInsert() {
        TShopcar tShopcar=new TShopcar();
        tShopcar.setUid(9);
        tShopcar.setBid(3);
        /**
         * 在加入购物车时先根据uid和bid判断这个商品存不存在，
         * 如果存在，在之前的基础上更新num的值
         * 如果不存在，
         */
        tShopcar.setNum(1);
        tShopcar.setStatus((byte)1);
        tShopcarMapper.insert(tShopcar);

    }

    @Test
    public void testSelectCar(){
        List<TShopcar> list=tShopcarMapper.selectCarByUid(9);
        for (TShopcar car:list){
            System.out.println(car);
        }
    }

    @Test
    public void testSelectCarByBU(){
        TShopcar tShopcar=new TShopcar();
        tShopcar.setUid(9);
        tShopcar.setBid(2);
        TShopcar ts=tShopcarMapper.selectSelective(tShopcar);

        //fastJson转换
        //对象转JSON字符串
        //JSON.toJSONString(String text)
        System.out.println(JSON.toJSONString(ts));//{"bid":2,"createTime":1549983634000,"num":2,"status":1,"uid":9}
        //json字符串转对象
        //JSON.parseObject(String text,Class<T> clazz)
        System.out.println(JSON.parseObject(JSON.toJSONString(ts),TShopcar.class).toString());
        //TShopcar{uid=9, bid=2, num=2, status=1, createTime=Tue Feb 12 23:00:34 CST 2019, updateTime=null}

    }

}
