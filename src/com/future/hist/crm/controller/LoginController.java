package com.future.hist.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController extends BaseController {
	
	@RequestMapping("login")
	public String login(HttpServletRequest request){
		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		
		System.out.println("the user'name is : " + name);
		System.out.println("the user'password is : " + password);
		
		return "workSpace";
	}
	
}
