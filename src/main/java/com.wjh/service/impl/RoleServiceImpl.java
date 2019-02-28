package com.wjh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wjh.bean.TRole;
import com.wjh.dao.mapper.TRoleMapper;
import com.wjh.service.IRoleService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private TRoleMapper roleMapper;
	@Override
	public List<TRole> findAllRole() {
		List<TRole> roleList=roleMapper.selectAll();
		return roleList;
	}

}
