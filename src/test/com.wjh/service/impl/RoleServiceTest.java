package com.wjh.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wjh.bean.TRole;
import com.wjh.service.IRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class RoleServiceTest {
	@Autowired
	private IRoleService roleServ;
	
	@Test
	public void findAllRole() {
		List<TRole> roleList=roleServ.findAllRole();
		for(TRole role:roleList) {
			System.out.println(role);
		}
	}
	@Test
	public void pageTest() {
		Page<TRole> page=PageHelper.startPage(1,1);
		List<TRole> roleList=roleServ.findAllRole();
		System.out.println("总行数："+page.getTotal());
		System.out.println("最大页码值："+page.getPages());
		System.out.println("当前页码值："+page.getPageNum());
		
		
		roleList.forEach(System.out::println);
	}
}
