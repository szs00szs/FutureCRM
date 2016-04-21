package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

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
	
	@RequestMapping(value = "/user_saveUI" )
	public String saveUI(Map<String, Object> map){
		List<Department> departmentList = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		map.put("currentPage", 1);
		System.out.println("departmentList : " + departmentList);
		map.put("user", new User());
		return "/user/saveUI";
	}
	
	/**
	 * 增加用户并返回到当前页
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user_save" ,method = RequestMethod.POST)
	public String save( User user){
		user.setPassword("f379eaf3c831b04de153469d1bec345e");   //给用户设置初始密码（666666）
		userService.insertUser(user);
		int totalCount = userService.getTotalCount();
		PageParameter pageParameter = new PageParameter();
		int totalPage = (totalCount + pageParameter.getPageSize() - 1) / pageParameter.getPageSize();
		return "redirect:/sysUser/user_list/" + totalPage;
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
		List<Department> departmentList = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		map.put("user", user);
		System.out.println("user : " + user);
		map.put("currentPage", currentPage);
		return "user/saveUI";
	}
	
	@RequestMapping(value = "/user_update/{currentPage}")
	public String update(@PathVariable(value = "currentPage") Integer currentPage,User user){
		System.out.println("user : " + user);
		userService.updateUser(user);
		return "redirect:/sysUser/user_list/" + currentPage;
	}
	
	
	@RequestMapping(value = "/user_delete/{user_id}")
	public String delete(@PathVariable(value = "user_id") Long user_id){
//TODO 删除要返回到删除页
		userService.deleteUserById(user_id);
		return "redirect:/sysUser/user_list/1";
	}
	
//TODO 根据字段查询  （模糊查询）
	
}
