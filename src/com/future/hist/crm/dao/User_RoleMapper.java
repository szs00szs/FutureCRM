package com.future.hist.crm.dao;

import java.util.List;

public interface User_RoleMapper {

	List<Long> getRoleIdsByUserId(Long user_id);

}
