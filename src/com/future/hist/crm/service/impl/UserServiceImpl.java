package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.BaseSearch;
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
}
