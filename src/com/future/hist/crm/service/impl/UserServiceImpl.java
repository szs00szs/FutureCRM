package com.future.hist.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public  void insertUser(User user) {
		userMapper.insert(user);
	}

	public void updateUser(User user) {
		userMapper.update(user);
	}

	public void deleteUserById(String user_id) {
		userMapper.deleteById(user_id);
	}
	
	public List<User> getAllUser(Map<String, Object> map) {
	return	userMapper.getAllUserByPage(map);

	}
	
	public User getUserById(String user_id) {
		return userMapper.getById(user_id);
	}
}
