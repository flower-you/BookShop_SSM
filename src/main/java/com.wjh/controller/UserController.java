package com.wjh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wjh.bean.TRole;
import com.wjh.bean.TUser;
import com.wjh.service.IRoleService;
import com.wjh.service.IUserService;


@Controller
@RequestMapping("/")//地址字符串的前缀
@SessionAttributes("user")//将model中的属性添加到session中
public class UserController {
	
	@Autowired
	private IUserService userv;
	
	@Autowired
	private IRoleService roleServ;
	
	
	private  ServletContext application;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="toLogin",method=RequestMethod.GET)
	public String toLogin(HttpServletRequest request) {
		if(application==null) {
			application=request.getServletContext();
		}
		
		Object obj=application.getAttribute("roleList");

		if(obj==null||(obj instanceof List)||((List)obj).size()<1) {
			List<TRole> roleList=roleServ.findAllRole();
			application.setAttribute("roleList", roleList);
		}
		
		return "user/login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(TUser tuser,Model model,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		TUser user=userv.login(tuser);
//		System.out.println("user"+user);
		System.out.println("request.getContextPath()"+request.getContextPath());
		if(user!=null) {
			model.addAttribute("user",user);
			String beforePath=(String)request.getSession().getAttribute("beforePath");
			System.out.println("before path"+beforePath);
			String method=(String)request.getSession().getAttribute("method");
			if(beforePath!=null) {
				//请求转发默认使用的是post方式，不支持get方式
				if("POST".equals(method)) {
					request.getRequestDispatcher(beforePath).forward(request, response);
				}
				//如果是GET方式，就使用重定向，重定向默认使用的是GET方式。request.getContextPath()获得项目地址BookShopSSM/
				else {
					response.sendRedirect(request.getContextPath()+beforePath);
				}
				
			}
			return "user/afterLogin";
		}
		else {
			model.addAttribute("msg", "用户名或密码错误！");
		}
		return "user/login";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="toRegist",method=RequestMethod.GET)
	public String toRegist(HttpServletRequest request) {
		if(application==null) {
			application=request.getServletContext();
		}
		
		Object obj=application.getAttribute("roleList");

		if(obj==null||(obj instanceof List)||((List)obj).size()<1) {
			List<TRole> roleList=roleServ.findAllRole();
			application.setAttribute("roleList", roleList);
		}
		return "user/regist";
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String regist(TUser tuser) {
		System.out.println("regist:"+tuser);
		try {
			userv.regist(tuser);
		}
		catch(Exception e){
			System.out.println("注册时出现错误！"+e);
		}
		return "user/login";
	}
	
	@ResponseBody	//将函数返回值作为请求返回值，没有这个注解的话，请求的响应应该是一个页面，不需要页面的话应该加上这个注解。
	@RequestMapping(value="check",method=RequestMethod.POST)
	public void check(TUser user,HttpServletResponse response) throws IOException {
		if(userv.ExistUser(user)) {//true 存在 false不存在
			response.getWriter().print("true");
		}
		else {
			response.getWriter().print("false");
		}
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		//清空该用户对应的session对象
		session.invalidate();
		return "user/login";
	}

}
