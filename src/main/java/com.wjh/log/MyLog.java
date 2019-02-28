package com.wjh.log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wjh.service.impl.UserServiceImpl;

@Aspect
@Component
public class MyLog {
	private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	 @After("execution(* com.wjh.service.impl.UserServiceImpl.login(..))")
	    public void loginLog(){
	        logger.info("user login");
	    }

}
