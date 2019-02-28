package com.wjh.service;

import com.wjh.bean.TUser;

public interface IUserService {
	public TUser login(TUser user);
	
	public void regist(TUser user);
	
	public boolean ExistUser(TUser user);
}
