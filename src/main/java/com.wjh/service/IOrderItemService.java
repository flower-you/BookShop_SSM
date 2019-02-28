package com.wjh.service;

import com.wjh.bean.TOrderItem;

import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/22 17:03
 * Description:
 */
public interface IOrderItemService {
    public void addOrderItem(TOrderItem orderItem);
    public List<TOrderItem>  OrderItemList(String orderId);
}
