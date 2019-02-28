package com.wjh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjh.service.ITypeService;

@Controller
public class ITypeController {

	@Autowired
	private ITypeService typeServ;
	
	@ResponseBody
	@RequestMapping(value="selectNameById.ajax",method=RequestMethod.POST)
	public List<String> selectNameById(HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id=Integer.parseInt(request.getParameter("bookid"));
		List<String> typeName=typeServ.selectNameById(id);
		return typeName;
	}
}
