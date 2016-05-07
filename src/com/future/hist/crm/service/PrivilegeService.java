package com.future.hist.crm.service;

import java.util.List;
import java.util.Set;

import com.future.hist.crm.domain.Privilege;

public interface PrivilegeService {

	Privilege getById(Long priId);
	
	Set<String> findPermissions(Set<Long> priIds);

	List<Privilege> findMenus(Set<String> permissions);

	List<Privilege> getAllPrivilege();

	List<Privilege> findTopPrivileges();
}
