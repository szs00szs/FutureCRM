package com.future.hist.crm.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.hist.crm.dao.RoleMapper;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Role;
import com.future.hist.crm.service.PrivilegeService;
import com.future.hist.crm.service.Privilege_RoleService;
import com.future.hist.crm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private PrivilegeService privilegeService;
	
	@Autowired
	private Privilege_RoleService privilege_RoleService;
	
	@Override
	public void insertRole(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public int getTotalCount() {
		return roleMapper.getTotalCount();
	}

	@Override
	public List<Role> getAllRoleByPage(BaseSearch baseSearch) {
		return roleMapper.getAllRoleByPage(baseSearch);
	}

	@Override
	public Role getRoleById(Long role_id) {
		return roleMapper.getRoleById(role_id);
	}

	@Override
	public void updateRole(Role role) {
		roleMapper.updateRole(role);
	}

	@Override
	public void deleteRoleById(Long role_id) {
		roleMapper.deleteRoleById(role_id);
	}

	@Override
	public Set<String> getRoleByIds(Long... roleIds) {
		 Set<String> roles = new HashSet<String>();
	        for(Long roleId : roleIds) {
	            Role role = getRoleById(roleId);
	            if(role != null) {
	                roles.add(role.getName());
	            }
	        }
	        return roles;
	}

	@Override
	public Set<String> findPermissions(Long... roleIds) {
		 Set<Long> priIds = new HashSet<Long>();
	        for(Long roleId : roleIds) {
	            Role role = getRoleById(roleId);
	            if(role != null) {
	            	priIds.addAll(privilege_RoleService.getPriIdsByRoleId(roleId));
	            }
	        }
	        return privilegeService.findPermissions(priIds);
	}
	
}
