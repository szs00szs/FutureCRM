package com.future.hist.crm.dao;

import java.util.Collection;
import java.util.List;

public interface Privilege_RoleMapper {

	Collection<? extends Long> getPriIdsByRoleId(Long roleId);

}
