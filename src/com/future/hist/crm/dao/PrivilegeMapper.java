package com.future.hist.crm.dao;

import java.util.List;
import java.util.Set;

import com.future.hist.crm.domain.Privilege;

public interface PrivilegeMapper {

	void save(Privilege menu);
	
	Set<String> findPermissions(Set<Long> priIds);

	Privilege getById(Long priId);

	List<Privilege> getAllPrivilege();

}
