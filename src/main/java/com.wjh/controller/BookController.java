package com.wjh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wjh.bean.TBook;
import com.wjh.service.IBookService;
import com.wjh.service.ITypeService;

@Controller
public class BookController {
	@Autowired
	private IBookService bookServ;
	
	@Autowired
	private ITypeService typeServ;
	
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping(value="newBookIndex",method=RequestMethod.POST)
	public Map<String,Object> newBook() {
		Page<TBook> page=PageHelper.startPage(1, 4);//挑出最新的四条记录显示在首页
		List<TBook> newBookList=bookServ.orderByOnlineTime();
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("newBookList", newBookList);
//        JSONArray json = net.sf.json.JSONArray.fromObject(map);
		return map;//返回当前页的图书及其分类信息
	}

	/**
	 * 跳转到最新上架页面
	 * @return
	 */
	@RequestMapping(value="newBookMore",method=RequestMethod.GET)
	public String newBookMore(int currentPage,HttpServletRequest request) {
		request.setAttribute("currentPage", currentPage);//传递当前页
		Page<TBook> page=PageHelper.startPage(currentPage, 8);
		List<TBook> newBookList=bookServ.orderByOnlineTime();
		request.setAttribute("total", page.getPages());//传递总页数
		 //每本书作为键，值为对应的分类，Map集合具有去重性，如果将两者反过来，那么由于分类会重复，书就会被覆盖掉
		 Map<TBook,List<String>> bookMap=new HashMap<TBook,List<String>>();
	        for(TBook book:newBookList) {
	        	List<String> typeList=typeServ.selectNameById(book.getId());
	        	bookMap.put(book,typeList);
	        }
	    request.setAttribute("bookMap", bookMap);
	    StringBuffer sb = new StringBuffer();
        //通过循环构建分页条,在后台构建分页条以简化jsp页面
        for(int i=1;i<=page.getPages();i++){
            if(i==currentPage){   //判断是否为当前页
                sb.append("『"+i+"』");  //构建分页条
            }else{
                sb.append("<a href='newBookMore?currentPage="+i+"'>"+i+"</a>"); //构建分页条
            }
            sb.append(" ");
        }
        request.setAttribute("pageBar", sb.toString());;
	    
		return "book/newBookMore";
	}
	
	@RequestMapping(value="bookDetail",method=RequestMethod.GET)
	public String bookDetail(int bookId,HttpServletRequest request) {
		TBook book=bookServ.selectBookById(bookId);
		request.setAttribute("book", book);
		return "book/bookDetail";
	}
	
}
