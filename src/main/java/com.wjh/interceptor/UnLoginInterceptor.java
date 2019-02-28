package com.wjh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.wjh.bean.TUser;
/**
 * 防止未登录非法访问个人信息的拦截器
 * 拦截对象：
 * 和个人信息相关的请求
 * @author 17976
 *
 */
public class UnLoginInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0,HttpServletResponse arg1, 
    		Object arg2, Exception arg3) throws Exception {
    	
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
		Object arg2, ModelAndView arg3) throws Exception {
    	
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
		Object arg2) throws Exception {
	
    	TUser user = (TUser) request.getSession().getAttribute("user");
    	if(user == null){
			request.getRequestDispatcher("/toLogin").forward(request, response);//如果未登录就转向登录界面
	    	System.out.println("UnLoginInterceptor");//测试
			return false;
    	}
    	return true;
    }

}
