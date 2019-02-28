package com.wjh.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wjh.bean.TType;
import com.wjh.dao.RedisDao;
import com.wjh.util.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wjh.dao.mapper.TTypeMapper;
import com.wjh.service.ITypeService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class TypeServiceImpl implements ITypeService{

	@Autowired
	private TTypeMapper typeMapper;
	@Autowired
	private RedisDao redisDao;
	@Override
	public List<String> selectNameById(Integer id) {
		return typeMapper.selectNameById(id);
	}

	@Override
	public List<TType> selectAll() {
		String typeListStr=redisDao.get("typeList");
		System.out.println("---------typeList------"+typeListStr);
		if (typeListStr==null||typeListStr.equals("")){//查询数据库
			List<TType> typeList=typeMapper.selectAll();
			System.out.println(JSONArray.toJSONString(typeList));
			redisDao.set("typeList",JSONArray.toJSONString(typeList));
			return typeList;
		}
		else {
		List<TType> typeList=JSONObject.parseArray(typeListStr,TType.class);
		return  typeList;
		}
	}
}
