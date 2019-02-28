package com.wjh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wjh.bean.TUser;
import com.wjh.dao.mapper.TUserMapper;
import com.wjh.service.IUserService;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements IUserService {

	@Autowired
	private TUserMapper usermapper;

	public TUser login(TUser tuser) {
		 return usermapper.selectSelective(tuser);

	}

	@Override
	public void regist(TUser user) {
		usermapper.insert(user);
	}

	/**
	 * true 存在
	 * false 不存在
	 */
	@Override
	public boolean ExistUser(TUser user) {
		if(usermapper.selectSelective(user)==null) {
			return false;
		}
		return true;
	}
	
	

}
