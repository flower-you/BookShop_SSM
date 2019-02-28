package com.wjh.controller;

import com.alibaba.fastjson.JSON;
import com.wjh.bean.TBook;
import com.wjh.bean.TOrder;
import com.wjh.bean.TOrderItem;
import com.wjh.bean.TUser;
import com.wjh.service.IBookService;
import com.wjh.service.IOrderItemService;
import com.wjh.service.IOrderServie;
import com.wjh.util.Constants;
import com.wjh.util.ShopUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:   17976
 * Date:     2019/2/25 18:50
 * Description:
 */
public class OrderController {
    @Autowired
    private IOrderServie orderService;
    @Autowired
    private IOrderItemService orderItemService;
    @Autowired
    private IBookService bookService;
    /**
     * 点立即付款的时候就生成订单信息，存入数据库
     * 先生成订单
     * 再生成订单项
     *
     * 这里传入的参数orderItem应该是一个json数组格式的，因为一个订单中有多个订单项，对应的orderId只有一个
     * @return
     */
    @RequestMapping(value = "toOrder",method =RequestMethod.GET )
    public String addOrder(String orderItem, HttpServletRequest request){
        List<TOrderItem> orderItemList= JSON.parseArray(orderItem,TOrderItem.class);
        TOrder order=new TOrder();
        String orderId=orderService.generateOrderId();
        order.setId(orderId);
        HttpSession session=request.getSession();
        TUser user=(TUser)session.getAttribute("user");
        order.setUid(user.getId());
        order.setState(Constants.ORDER_WAIT_ALIPAY);//待支付，等支付完毕之后设置为1：待发货 超时未支付设置为已关闭,同时将该订单对应的订单项从订单表中删除
        /**
         * 循环将orderItem添加到数据库中
         */
        float sum=0;
        for (TOrderItem tOrderItem:orderItemList){
            tOrderItem.setOrderid(orderId);
            //将float格式的价格转换为两位小数
            tOrderItem.setPrice(ShopUtil.formatPrice(new BigDecimal(tOrderItem.getPrice()),2).floatValue());
            orderItemService.addOrderItem(tOrderItem);
            sum+=tOrderItem.getPrice();
        }
        /**
         * 订单价格为个订单项的总和
         * BigDecimal.ROUND_HALF_UP表示采用"四舍五入"的模式处理价格
         * 保留两位小数
         */
        BigDecimal bd=new BigDecimal(sum);
        order.setAmt(bd.setScale(2,BigDecimal.ROUND_HALF_UP));
        orderService.addOrder(order);
        /**
         * 存入数据库之后应该查出当前的订单信息，显示到前台，跳转到订单详情页
         * 订单详情页：
         *  订单信息：
         *      订单中的订单项信息：
         *          订单项中的商品信息
         */
        //订单信息
        TOrder tOrder=orderService.queryOrderByOrderid(orderId);
        request.setAttribute("order",tOrder);
        //订单项信息
        List<TOrderItem> orderItems=orderItemService.OrderItemList(orderId);
        Map orderItemMap=new HashMap<TOrderItem,TBook>();
        for (TOrderItem tOrderItem:orderItems){
            TBook book=bookService.selectBookById(tOrderItem.getBookid());
            orderItemMap.put(tOrderItem,book);
        }
        return "order/orderDetail";
    }

}
