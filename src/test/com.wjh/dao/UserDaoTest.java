package com.wjh.dao;

import com.wjh.dao.mapper.TUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wjh.bean.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class UserDaoTest {

	@Autowired
	private TUserMapper usermapper;
	
	@Test
	public void testSelectByKey() {
		TUser user=usermapper.selectByPrimaryKey(1);
		
		System.out.println(user);
		
	}
	

}
