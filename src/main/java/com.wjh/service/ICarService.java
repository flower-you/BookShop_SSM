package com.wjh.service;

import com.wjh.bean.TShopcar;

import java.util.List;

/**
 * Author:   17976
 * Date:     2019/2/11 19:12
 * Description: 购物车
 */
public interface ICarService {
    public boolean addBook(TShopcar tShopcar);
    public List<TShopcar> QueryCar(int uid);
}
