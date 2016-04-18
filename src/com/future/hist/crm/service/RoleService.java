package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Role;

public interface RoleService {

	void insertRole(Role role);

	int getTotalCount();

	List<Role> getAllRoleByPage(BaseSearch baseSearch);

	Role getRoleById(Long role_id);

	void updateRole(Role role);

	void deleteRoleById(Long role_id);

}
