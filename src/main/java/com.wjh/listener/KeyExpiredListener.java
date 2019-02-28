package com.wjh.listener;

import com.wjh.bean.TOrder;
import com.wjh.dao.mapper.TOrderMapper;
import com.wjh.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPubSub;

/**
 * Author:   17976
 * Date:     2019/2/23 21:34
 * Description: 监听redis key是否过期
 */
@Component
public class KeyExpiredListener extends JedisPubSub {
    @Autowired
    private TOrderMapper orderMapper;
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
//        super.onPSubscribe(pattern, subscribedChannels);
        System.out.println("onPSubscribe " + pattern + " " + subscribedChannels);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage pattern -->" + pattern + "-->channel: " + channel + "message--> " + message);
        if (message.startsWith("order")){//订单如果超时，查询数据库，如果state为超时未支付，则交易关闭
            TOrder order=orderMapper.selectByPrimaryKey(message);
            String orderId=order.getId();
            System.out.println("过期订单----"+orderId);
            if (order.getState().equals(Constants.ORDER_PAY_TIMEOUT)){
                order.setState(Constants.ORDER_CLOSED);//超时未支付，交易关闭
            }
        }
    }
}
