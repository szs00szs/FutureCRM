package com.future.hist.crm.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.Privilege_RoleService;
import com.future.hist.crm.service.RoleService;
import com.future.hist.crm.service.UserService;
import com.future.hist.crm.service.User_RoleService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private PasswordHelper passwordHelper;
	
	@Autowired
	private User_RoleService user_roleService;
	
	
	
	@Autowired
	private RoleService roleService;
	
	public  void insertUser(User user) {
		//加密密码
        passwordHelper.encryptPassword(user);
		userMapper.insert(user);
	}

	public void updateUser(User user) {
		userMapper.update(user);
	}

	public User getUserById(Long id) {
		return userMapper.getUserById(id);
	}
	
	public User getUserByName(String name){
		return userMapper.getUserByName(name);
	}
	
	public List<User> getUserByNameLike_(String name){
		return userMapper.getUserByNameLike_(name);
	}
	
	public User getUserByLoginName(String loginName){
		return userMapper.getUserByLoginName(loginName);
	}

	public int getTotalCount() {
		return userMapper.getTotalCount();
	}

	public void deleteUserById(Long id) {
		userMapper.deleteById(id);
	}

	public List<User> getAllUserByPage(BaseSearch baseSearch) {
		return userMapper.getAllUserByPage(baseSearch);
	}

	@Override
	public List<User> getAllUser() {
		return userMapper.getAllUser();
	}

	@Override
	public List<User> getUserByLike(User user) {
		System.out.println("user : " + user);
		return userMapper.getUserByLike(user);
	}

	@Override
	public Set<String> findRoles(String loginName) {
		System.out.println("loginName : " + loginName);
		User user = userMapper.getUserByLoginName(loginName);
		List<Long> roleIds = user_roleService.getRoleIdsByUserId(user.getId());
        user.setRoleIds(roleIds);
		return roleService.getRoleByIds(user.getRoleIds().toArray(new Long[0]));
	}
	 /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String loginName) {
        User user = getUserByLoginName(loginName);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        System.out.println("user_id : " + user.getId());
        List<Long> roleIds = user_roleService.getRoleIdsByUserId(user.getId());
        user.setRoleIds(roleIds);
        return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }

	@Override
	public boolean isExistLoginName(String loginName) {
		User user = userMapper.getUserByLoginName(loginName);
		if(user != null){
			return true;
		}else{
			return false;
		}
	}
}
