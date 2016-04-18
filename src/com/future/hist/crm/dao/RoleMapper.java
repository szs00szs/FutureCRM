package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Role;

public interface RoleMapper {

	void insert(Role role);

	int getTotalCount();

	List<Role> getAllRoleByPage(BaseSearch baseSearch);

	Role getRoleById(Long role_id);

	void updateRole(Role role);

	void deleteRoleById(Long role_id);

}
