package com.wjh.bean;

import java.io.Serializable;

public class TType implements Serializable {

    private static final long serialVersionUID = -7409422469370587330L;

    private Integer id;

    private String name;

    private String descr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "TType [id=" + id + ", name=" + name + ", descr=" + descr + "]";
    }


}