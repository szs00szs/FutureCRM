package com.future.hist.crm.service;

import java.util.List;
import java.util.Set;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.User;

public interface UserService {
	public  void insertUser(User user) ;

	public void updateUser(User user);

	public void deleteUserById(Long id);
	
	public User getUserById(Long user_id);
	
	public User getUserByName(String name);
	
	public List<User> getUserByNameLike_(String name);
	
	public User getUserByLoginName(String loginName);

	public int getTotalCount();

	public List<User> getAllUserByPage(BaseSearch baseSearch);
	
	public List<User> getAllUser();

	public List<User> getUserByLike(User user);

	public Set<String> findRoles(String loginName);

	public Set<String> findPermissions(String loginName);
}
