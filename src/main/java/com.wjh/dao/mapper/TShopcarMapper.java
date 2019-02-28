package com.wjh.dao.mapper;

import com.wjh.bean.TShopcar;

import java.util.List;

public interface TShopcarMapper {

    int insert(TShopcar record);

    int insertSelective(TShopcar record);

    int updateNum(TShopcar tShopcar);

    List<TShopcar> selectCarByUid(Integer uid);

    //其实在用的时候是使用Uid和bid进行查询
    TShopcar selectSelective(TShopcar tShopcar);

}