package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.User_RoleMapper;
import com.future.hist.crm.service.User_RoleService;

@Service
@Transactional
public class User_RoleServiceImpl implements User_RoleService{

	@Autowired
	private User_RoleMapper user_roleMapper;
	
	@Override
	public List<Long> getRoleIdsByUserId(Long user_id) {
		return user_roleMapper.getRoleIdsByUserId(user_id);
	}

}
