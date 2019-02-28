package com.wjh.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TBook {
    private Integer id;

    private String name;

    private Float price;

    private String auth;

    private String img;

    private BigDecimal rebate;

    private Integer stock;

    private String publisher;

    private Date publishdate;

    private Integer pages;

    private String size;

    private Integer printtimes;

    private Integer versions;

    private String content;

    private Date onlinetime;

    private String brief;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrinttimes() {
        return printtimes;
    }

    public void setPrinttimes(Integer printtimes) {
        this.printtimes = printtimes;
    }

    public Integer getVersions() {
        return versions;
    }

    public void setVersions(Integer versions) {
        this.versions = versions;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(Date onlinetime) {
        this.onlinetime = onlinetime;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

	@Override
	public String toString() {
		return "TBook [id=" + id + ", name=" + name + ", price=" + price + ", auth=" + auth + ", img=" + img
				+ ", rebate=" + rebate + ", stock=" + stock + ", publisher=" + publisher + ", publishdate="
				+ publishdate + ", pages=" + pages + ", size=" + size + ", printtimes=" + printtimes + ", versions="
				+ versions + ", content=" + content + ", onlinetime=" + onlinetime + ", brief=" + brief + "]";
	}
    
    
}