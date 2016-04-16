package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.User;

public interface UserMapper {
    
    int deleteById(long id);

	User getUserByName(String name);

	void insert(User user);

	void update(User user);

	int getTotalCount();

	User getUserById(Long id);

	List<User> getAllUserByPage(BaseSearch baseSearch);

}
