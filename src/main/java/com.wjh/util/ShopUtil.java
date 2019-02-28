package com.wjh.util;

import java.math.BigDecimal;

/**
 * Author:   17976
 * Date:     2019/2/25 22:19
 * Description: 商城项目中常用的一些方法
 */
public class ShopUtil {
    /**
     *
     * @param bd 要传入的BigDecimal价格对象
     * @param num   要保留的小数位数，例如num=2
     * @return
     */
    public static BigDecimal formatPrice(BigDecimal bd,int num){
        if(bd == null || num < 0){
            return null;
        }
        bd = bd.setScale(num, BigDecimal.ROUND_HALF_UP);//BigDecimal.ROUND_HALF_UP四舍五入
        return bd;
    }
}
