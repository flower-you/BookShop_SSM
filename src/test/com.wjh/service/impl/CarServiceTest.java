package com.wjh.service.impl;

import com.wjh.bean.TShopcar;
import com.wjh.service.ICarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author:   17976
 * Date:     2019/2/14 21:36
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class CarServiceTest {
    @Autowired
    private ICarService carService;

    @Test
    public void testAddBook(){
        TShopcar tShopcar=new TShopcar();
        tShopcar.setUid(9);
        tShopcar.setBid(15);
        tShopcar.setNum(1);
        carService.addBook(tShopcar);
    }
}
