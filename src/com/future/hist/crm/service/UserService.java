package com.future.hist.crm.service;

import java.util.List;
import java.util.Map;

import com.future.hist.crm.domain.User;

public interface UserService {
	public  void insertUser(User user) ;

	public void updateUser(User user);

	public void deleteUserById(String user_id);
	
	public List<User> getAllUser(Map<String, Object> map);
	
	public User getUserById(String user_id);
}
