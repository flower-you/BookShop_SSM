package com.wjh.service;

import com.wjh.bean.TUser;

public interface IUserService {
	/**
	 * 使用md5验证登录
	 * 将用户输入的密码和数据库中的密码进行对比
	 * @param user
	 * @return
	 */
	public TUser login(TUser user);
	
	public void regist(TUser user);
	
	public boolean ExistUser(TUser user);
}
