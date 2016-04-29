package com.future.hist.crm.service;

import java.util.Collection;

public interface Privilege_RoleService {

	Collection<? extends Long> getPriIdsByRoleId(Long roleId);

}
