package com.wjh.Listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Author:   17976
 * Date:     2019/2/25 18:17
 * Description:
 */
public class OtherTest {
    public static void main(String[] args){
//        String str="orderxx001";
//        if(str.startsWith("order")){
//            System.out.println("expired a order");
//        }

        Integer uuidHashCode = UUID.randomUUID().toString().hashCode();
        if (uuidHashCode < 0) {
            uuidHashCode = uuidHashCode * (-1);
        }
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println(date);
        String orderId=date + uuidHashCode;
        System.out.println(orderId);
        System.out.println(orderId.length());

//        if (new Integer(1).equals(1)){
//            System.out.println("true");
//        }
    }
}
