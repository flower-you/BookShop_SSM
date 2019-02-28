package com.wjh.bean;

public class TCarBook {
    private Integer bid;

    private Integer carid;
    
    

    public TCarBook() {
		super();
	}

	public TCarBook(Integer bid, Integer carid) {
		super();
		this.bid = bid;
		this.carid = carid;
	}

	public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }
}