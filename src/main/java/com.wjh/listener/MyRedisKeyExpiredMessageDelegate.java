package com.wjh.listener;

import java.io.Serializable;
import java.util.Map;

/**
 * Author:   17976
 * Date:     2019/2/23 21:42
 * Description:
 */
public class MyRedisKeyExpiredMessageDelegate implements MyMessageDelegate {

    @Override
    public void handleMessage(String message) {

    }

    @Override
    public void handleMessage(Map message) {

    }

    @Override
    public void handleMessage(byte[] message) {

    }

    @Override
    public void handleMessage(Serializable message) {

    }

    @Override
    public void handleMessage(Serializable message, String channel) {

    }
}
