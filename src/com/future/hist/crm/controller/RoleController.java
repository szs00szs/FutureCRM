package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.PageParameter;
import com.future.hist.crm.domain.Role;
import com.future.hist.crm.service.RoleService;

@Controller
@RequestMapping("/sysRole")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "role_saveUI")
	public String saveUI(Map<String, Object> map){
		map.put("currentPage", 1);
		return "role/saveUI";
	}
	
	@RequestMapping(value = "role_save")
	public String save(Role role){
		System.out.println(role);
		roleService.insertRole(role);
		int totalCount = roleService.getTotalCount();
		PageParameter pageParameter = new PageParameter();
		int totalPage = (totalCount + pageParameter.getPageSize() - 1) / pageParameter.getPageSize();
		return "redirect:/sysRole/role_list/" + totalPage;
	}
	
	@RequestMapping("role_list/{currentPage}")
	public String list(@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map){
		BaseSearch baseSearch = new BaseSearch();
		int totalCount = roleService.getTotalCount();
		PageParameter pageParameter = new PageParameter(PageParameter.DEFAULT_PAGE_SIZE, currentPage, totalCount);
		System.out.println("pageParameter : " + pageParameter);
		System.out.println("baseSearch : " + baseSearch);
		baseSearch.setPage(pageParameter);
		List<Role> roleList = roleService.getAllRoleByPage(baseSearch);
		map.put("roleList", roleList);
		map.put("pageParameter", pageParameter);
		System.out.println("roleList : " + roleList);
		return "role/role_list";
	}
	
	@RequestMapping(value = "/role_updateUI/{role_id}/{currentPage}")
	public String updateUI(@PathVariable(value = "role_id") Long role_id,@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map){
		Role role = roleService.getRoleById(role_id);
		map.put("role", role);
		map.put("currentPage", currentPage);
		return "role/saveUI";
	}
	
	@RequestMapping(value = "/role_update/{currentPage}")
	public String update(@PathVariable(value = "currentPage") Integer currentPage,Role role){
		System.out.println("role : " + role);
		roleService.updateRole(role);
		return "redirect:/sysRole/role_list/" + currentPage;
	}
	
	@RequestMapping(value = "/role_delete/{role_id}")
	public String delete(@PathVariable(value = "role_id") Long role_id){
		roleService.deleteRoleById(role_id);
		return "redirect:/sysRole/role_list/1";
	}
}
