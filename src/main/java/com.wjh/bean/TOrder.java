package com.wjh.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TOrder {
    private String id;

    private Integer uid;

    private String consignee;

    private String paytype="0";

    private BigDecimal amt;

    private Integer state;

    private Date orderdate;

    private Date updatetime;

    private Date sendgoods;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getSendgoods() {
        return sendgoods;
    }

    public void setSendgoods(Date sendgoods) {
        this.sendgoods = sendgoods;
    }
}