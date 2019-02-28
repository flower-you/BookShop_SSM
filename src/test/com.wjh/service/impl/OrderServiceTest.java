package com.wjh.service.impl;

import com.wjh.bean.TOrder;
import com.wjh.service.IOrderServie;
import com.wjh.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Author:   17976
 * Date:     2019/2/25 19:48
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class OrderServiceTest {
    @Autowired
    private IOrderServie orderServie;

    @Test
    public  void testExpired(){
        TOrder order=new TOrder();
        order.setId(UUID.randomUUID().toString().replace("-",""));
        order.setState(Constants.ORDER_WAIT_ALIPAY);
        orderServie.addOrder(order);
    }
}
