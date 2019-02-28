package com.wjh.listener;

import java.io.Serializable;
import java.util.Map;

/**
 * Author:   17976
 * Date:     2019/2/23 21:41
 * Description:
 */
public interface MyMessageDelegate {
    void handleMessage(String message);
    void handleMessage(Map message);
    void handleMessage(byte[] message);
    void handleMessage(Serializable message);
    // pass the channel/pattern as well
    void handleMessage(Serializable message, String channel);
}
