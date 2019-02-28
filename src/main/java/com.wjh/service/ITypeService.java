package com.wjh.service;

import com.wjh.bean.TType;

import java.util.List;

public interface ITypeService {
	List<String> selectNameById(Integer id);
	public List<TType> selectAll();
}
