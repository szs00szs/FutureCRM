package com.future.hist.crm.service;

import java.util.List;
import java.util.Set;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Role;

public interface RoleService {

	void insertRole(Role role);

	int getTotalCount();

	List<Role> getAllRoleByPage(BaseSearch baseSearch);

	Role getRoleById(Long role_id);

	void updateRole(Role role);

	void deleteRoleById(Long role_id);

	/**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> getRoleByIds(Long... roleIds);

	Set<String> findPermissions(Long... roleIds);

}
