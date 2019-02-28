package com.wjh.bean;

import java.util.Date;

public class TAddress {
    private Integer uid;

    private String name;

    private String phone;

    private String address;

    private String addressdetail;

    private String zip;

    private String dft;

    private String descr;

    private Date mktime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressdetail() {
        return addressdetail;
    }

    public void setAddressdetail(String addressdetail) {
        this.addressdetail = addressdetail;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDft() {
        return dft;
    }

    public void setDft(String dft) {
        this.dft = dft;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getMktime() {
        return mktime;
    }

    public void setMktime(Date mktime) {
        this.mktime = mktime;
    }
}