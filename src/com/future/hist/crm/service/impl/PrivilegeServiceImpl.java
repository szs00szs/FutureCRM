package com.future.hist.crm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.future.hist.crm.dao.PrivilegeMapper;
import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.Privilege.PrivilegeType;
import com.future.hist.crm.service.PrivilegeService;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService{

	@Autowired
	private PrivilegeMapper privilegeMapper;
	
	@Override
	public Privilege getById(Long priId) {
		return privilegeMapper.getById(priId);
	}
	
	@Override
	public List<Privilege> getAllPrivilege() {
		return privilegeMapper.getAllPrivilege();
	}

	
	@Override
	public Set<String> findPermissions(Set<Long> priIds) {
		 Set<String> permissions = new HashSet<String>();
	        for(Long priId : priIds) {
	            Privilege privilege = getById(priId);
	            if(privilege != null && !StringUtils.isEmpty(privilege.getPermission())) {
	                permissions.add(privilege.getPermission());
	            }
	        }
	        return permissions;
	}
	
	@Override
	public List<Privilege> findMenus(Set<String> permissions) {
		 List<Privilege> allPrivilege = getAllPrivilege();
	        List<Privilege> menus = new ArrayList<Privilege>();
	        System.out.println("allPrivilege : " + allPrivilege);
	        for(Privilege privilege : allPrivilege) {
	            if(privilege.getType() != PrivilegeType.menu) {
	                continue;
	            }
	            if(!hasPermission(permissions, privilege)) {
	                continue;
	            }
	            menus.add(privilege);
	        }
	        return menus;
	}
	
	
	private boolean hasPermission(Set<String> permissions, Privilege privilege) {
        if(StringUtils.isEmpty(privilege.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(privilege.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
	}

}
