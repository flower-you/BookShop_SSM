package com.wjh.service.impl;

import com.wjh.bean.TOrderItem;
import com.wjh.dao.mapper.TOrderItemMapper;
import com.wjh.dao.mapper.TOrderMapper;
import com.wjh.service.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/22 17:04
 * Description:
 */
@Service
public class OrderItemServiceImpl implements IOrderItemService {
    @Autowired
    private TOrderItemMapper orderItemMapper;


    @Override
    public void addOrderItem(TOrderItem orderItem) {
        orderItemMapper.insert(orderItem);
    }

    @Override
    public List<TOrderItem> OrderItemList(String orderId) {
        List<TOrderItem> orderItemList=orderItemMapper.selectByOrderId(orderId);
        return orderItemList;
    }

}
