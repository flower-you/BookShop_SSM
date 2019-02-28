package com.wjh.dao.mapper;

import com.wjh.bean.TOrderItem;

import java.util.List;

public interface TOrderItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(TOrderItem record);

    int insertSelective(TOrderItem record);

    TOrderItem selectByPrimaryKey(String id);

    List<TOrderItem> selectByOrderId(String orderid);

    int updateByPrimaryKeySelective(TOrderItem record);

    int updateByPrimaryKey(TOrderItem record);
}