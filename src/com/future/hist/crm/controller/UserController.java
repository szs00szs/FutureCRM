package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.PageParameter;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.DepartmentService;
import com.future.hist.crm.service.UserService;
@Controller
@RequestMapping("/sysUser")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/user_saveUI")
	public String saveUI(Map<String, Object> map){
		List<Department> departmentList = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		System.out.println("departmentList : " + departmentList);
		map.put("user", new User());
		return "/user/saveUI";
	}
	
	@RequestMapping(value = "/user_save" ,method = RequestMethod.POST)
	public String save(@Valid User user){
		user.setPassword("f379eaf3c831b04de153469d1bec345e");   //给用户设置初始密码（666666）
		userService.insertUser(user);
		int totalCount = userService.getTotalCount();
		return "redirect:/sysUser/user_list/" + totalCount;
	}
	
	@RequestMapping("user_list/{currentPage}")
	public String list(@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map){
		BaseSearch baseSearch = new BaseSearch();
		int totalCount = userService.getTotalCount();
		PageParameter pageParameter = new PageParameter(PageParameter.DEFAULT_PAGE_SIZE, currentPage, totalCount);
		System.out.println("pageParameter : " + pageParameter);
		baseSearch.setPage(pageParameter);
		List<User> userList = userService.getAllUserByPage(baseSearch);
		map.put("userList", userList);
		map.put("pageParameter", pageParameter);
		System.out.println("userList : " + userList);
		return "user/user_list";
	}
	
	@RequestMapping(value = "/user_updateUI/{user_id}/{currentPage}")
	public String updateUI(@PathVariable(value = "user_id") Long user_id,@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map){
		User user = userService.getUserById(user_id);
		map.put("user", user);
		map.put("currentPage", currentPage);
		return "user/saveUI";
	}
	
	@RequestMapping(value = "/user_update/{currentPage}")
	public String update(@PathVariable(value = "currentPage") Integer currentPage,User user){
		System.out.println("user : " + user);
		userService.updateUser(user);
		return "redirect:/sysUser/user_list/" + currentPage;
	}
}
