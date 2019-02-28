package com.wjh.dao.mapper;

import com.wjh.bean.TAddress;

public interface TAddressMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TAddress record);

    int insertSelective(TAddress record);

    TAddress selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TAddress record);

    int updateByPrimaryKey(TAddress record);
}