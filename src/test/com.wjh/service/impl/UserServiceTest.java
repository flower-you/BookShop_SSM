package com.wjh.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wjh.bean.TUser;
import com.wjh.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class UserServiceTest {
	@Autowired
	private IUserService userv;
	@Test
	public void login() {
		TUser tuser=new TUser();
		tuser.setUsername("flower");
		tuser.setPassword("flower");
		tuser.setRoleid(2);;
		System.out.println(userv.login(tuser));
		
	}
	@Test
	public void existUserTest() {
		TUser user=new TUser();
		user.setUsername("flower");
		System.out.println(userv.ExistUser(user));
	}
	@Test
	public void regist() {
		TUser user=new TUser();
		user.setUsername("哈哈哈哈哈哈");
		user.setAge(22);
		user.setPassword("hahahahhaha");
		user.setRoleid(1);
		user.setPhone("1375263891");
		userv.regist(user);
	}
}
