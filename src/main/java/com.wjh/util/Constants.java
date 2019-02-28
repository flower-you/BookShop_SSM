package com.wjh.util;

/**
 * Author:   17976
 * Date:     2019/2/11 19:39
 * Description: 需要用到的一些常量
 */
public class Constants {
    public static final int CAR_MAX_SIZE=100;//购物车中的商品种数最大数量

    public static final int ORDER_WAIT_ALIPAY=0;//订单待支付
    public static final int ORDER_CLOSED=1;//超时未支付，交易关闭
    public static final int ORDER_WAIT_SEND=0;//已付款，待发货
    public static final int ORDER_WAIT_RECEIVE=0;//已发货，待收货
    public static final int ORDER_PAY_TIMEOUT=6;//秒，订单超时未支付的时间,24小时:86400s
}
