package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.PageParameter;
import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.Role;
import com.future.hist.crm.service.PrivilegeService;
import com.future.hist.crm.service.Privilege_RoleService;
import com.future.hist.crm.service.RoleService;

@Controller
@RequestMapping("/sysRole")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private Privilege_RoleService privilege_roleService;
	
	@RequiresPermissions("role:save")
	@RequestMapping(value = "role_save",method = RequestMethod.GET)
	public String save(Map<String, Object> map){
		map.put("currentPage", 1);
		return "role/saveUI";
	}
	/**
	 * 增加角色并返回到当前页
	 * @param role
	 * @return
	 */
	@RequiresPermissions("role:save")
	@RequestMapping(value = "role_save",method = RequestMethod.POST)
	public String save(Role role){
		System.out.println(role);
		roleService.insertRole(role);
		int totalCount = roleService.getTotalCount();
		PageParameter pageParameter = new PageParameter();
		int totalPage = (totalCount + pageParameter.getPageSize() - 1) / pageParameter.getPageSize();
		return "redirect:/sysRole/role_list/" + totalPage;
	}
	
	@RequiresPermissions("role:view")
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
	
	@RequiresPermissions("role:update")
	@RequestMapping(value = "/role_update/{role_id}/{currentPage}",method = RequestMethod.GET)
	public String updateUI(@PathVariable(value = "role_id") Long role_id,@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map){
		Role role = roleService.getRoleById(role_id);
		map.put("role", role);
		map.put("currentPage", currentPage);
		return "role/saveUI";
	}
	
	@RequiresPermissions("role:update")
	@RequestMapping(value = "/role_update/{currentPage}",method = RequestMethod.POST)
	public String update(@PathVariable(value = "currentPage") Integer currentPage,Role role){
		System.out.println("role : " + role);
		roleService.updateRole(role);
		return "redirect:/sysRole/role_list/" + currentPage;
	}
	
	@RequiresPermissions("role:delete")
	@RequestMapping(value = "/role_delete/{role_id}")
	public String delete(@PathVariable(value = "role_id") Long role_id){
		roleService.deleteRoleById(role_id);
		return "redirect:/sysRole/role_list/1";
	}
	
	@RequestMapping(value = "/set_privilege/{role_id}",method = RequestMethod.GET)
	public String set_privilege(@PathVariable(value = "role_id") Long role_id,Map<String, Object> map){
		Role role = roleService.getRoleById(role_id);
		List<Privilege> privilegeList = privilegeService.getAllPrivilege();
		List<Privilege> topPrivilegeList = privilegeService.findTopPrivileges();
		
		System.out.println("topPrivilegeList : " + topPrivilegeList);
		System.out.println("privilegeList : " + privilegeList);
		List<Long> privilegeIds = (List<Long>) privilege_roleService.getPriIdsByRoleId(role_id);
//		List<Privilege> children = privilegeService.findChildren();
		System.out.println("priIds : " + privilegeIds);
		role.setPriIds(privilegeIds);
		map.put("privilegeIds", privilegeIds);
		map.put("role", role);
		map.put("topPrivilegeList", topPrivilegeList);
		return "/role/set_privilegeUI";
	}
}
