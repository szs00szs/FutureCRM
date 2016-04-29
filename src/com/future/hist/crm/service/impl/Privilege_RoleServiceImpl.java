package com.future.hist.crm.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.Privilege_RoleMapper;
import com.future.hist.crm.service.Privilege_RoleService;
@Service
@Transactional
public class Privilege_RoleServiceImpl implements Privilege_RoleService{

	@Autowired
	private Privilege_RoleMapper privilege_RoleMapper; 
	@Override
	public Collection<? extends Long> getPriIdsByRoleId(Long roleId) {
		return privilege_RoleMapper.getPriIdsByRoleId(roleId);
	}
}
