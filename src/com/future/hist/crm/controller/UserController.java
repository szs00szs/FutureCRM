package com.future.hist.crm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.User;
@Controller
@RequestMapping("/sysUser")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/user_saveUI")
	public String addUserUI(){
		
		return "/user/saveUI";
	}
	
	@RequestMapping(value = "/addUser" , method = RequestMethod.POST)
	public String addUser(User user){
		user.setPassword("f379eaf3c831b04de153469d1bec345e");   //给用户设置初始密码（666666）
		userMapper.addUser(user);
		return "redirect:/sysUser/user_list";
	}
	
	@RequestMapping(value = "user_list")
	public String list(Map<String, Object> map){
//		List<User> userList = userMapper.g
		return "/user/user_list";
	}
}
