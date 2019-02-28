package com.wjh.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wjh.bean.TBook;
import com.wjh.dao.mapper.TBookMapper;
import com.wjh.service.IBookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class BookServiceTest {

	@Autowired
	private IBookService  bookServ;
	
	@Autowired
	private TBookMapper bookMapper;
	
	@Test
	public void orderByOnlineTimeTest() {
		/**
		 * 用于模拟在action中的操作，到时候分页的参数值通过前台页面进行传入，通过Ajax的形式，首页展示前八条
		 * 更多点击超链接，然后根据用户点击页数或者上一页下一页来传入当前的页码值进行查询。
		 */
		Page<TBook> page=PageHelper.startPage(1, 5);

		List<TBook> newBookList=bookMapper.selectRecent();
		System.out.println("总行数："+page.getTotal());
		System.out.println("最大页码值："+page.getPages());
		System.out.println("当前页码值："+page.getPageNum());
		newBookList.forEach(System.out::println);
		
	}

}
