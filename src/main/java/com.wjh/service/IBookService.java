package com.wjh.service;

import java.util.List;

import com.wjh.bean.TBook;

public interface IBookService {
	/**
	 * 查询出最新的图书，按onlinetime降序排列
	 * @return
	 */
	List<TBook> orderByOnlineTime();
	
	TBook selectBookById(int id);
}
