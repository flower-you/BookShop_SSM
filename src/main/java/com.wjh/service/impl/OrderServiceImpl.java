package com.wjh.service.impl;

import com.alibaba.fastjson.JSON;
import com.wjh.bean.TOrder;
import com.wjh.dao.RedisDao;
import com.wjh.dao.mapper.TOrderMapper;
import com.wjh.service.IOrderServie;
import com.wjh.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Author:   17976
 * Date:     2019/2/22 16:22
 * Description:
 */
@Service
public class OrderServiceImpl implements IOrderServie {
    @Autowired
    private TOrderMapper orderMapper;
    @Autowired
    private  RedisDao redisDao;

    @Override
    public void addOrder(TOrder order) {
        redisDao.setEx("order"+order.getId(), JSON.toJSONString(order),Constants.ORDER_PAY_TIMEOUT);
        orderMapper.insert(order);
    }

    /**
     * 生成的订单长度为24位
     * date+uuidHashCode
     * 例如：
     * date:20190226155041
     * orderid:201902261550412018896709
     * @return
     */
    @Override
    public String generateOrderId() {
        String orderId="";
        Integer uuidHashCode = UUID.randomUUID().toString().hashCode();
        if (uuidHashCode < 0) {
            uuidHashCode = uuidHashCode * (-1);
        }
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        orderId=date + uuidHashCode;
        return orderId;
    }

    @Override
    public TOrder queryOrderByOrderid(String orderid) {
        return orderMapper.selectByPrimaryKey(orderid);
    }
}
