package com.wjh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wjh.bean.TBook;
import com.wjh.dao.mapper.TBookMapper;
import com.wjh.service.IBookService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BookServiceImpl implements IBookService {

	@Autowired
	private TBookMapper bookMapper;

	@Override
	public List<TBook> orderByOnlineTime() {
		return bookMapper.selectRecent();
	}

	@Override
	public TBook selectBookById(int id) {
		return bookMapper.selectByPrimaryKey(id);
	}

}
