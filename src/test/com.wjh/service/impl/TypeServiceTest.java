package com.wjh.service.impl;

import com.wjh.bean.TType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wjh.dao.mapper.TTypeMapper;
import com.wjh.service.ITypeService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class TypeServiceTest {
	
	@Autowired
	private ITypeService typeServ;
	
	@Autowired
	private TTypeMapper typemapper;
	
	@Test
	public void selectNameById() {
		System.out.println(typemapper.selectNameById(2));
	}

	@Test
	public void testSelectAll(){
		List<TType> types=typeServ.selectAll();
		for (TType type:types){
			System.out.println(type.toString());
		}
	}

}
