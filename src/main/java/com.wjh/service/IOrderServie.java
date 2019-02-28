package com.wjh.service;

import com.wjh.bean.TOrder;

/**
 * Author:   17976
 * Date:     2019/2/22 16:16
 * Description:
 */
public interface IOrderServie {
    public void addOrder(TOrder order);

    /**
     * 生成不重复的订单号
     * 当前时间+uuid.hashCode()
     * @return
     */
    public String generateOrderId();
    public TOrder queryOrderByOrderid(String orderid);
}
