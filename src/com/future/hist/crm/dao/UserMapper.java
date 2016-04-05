package com.future.hist.crm.dao;

import java.util.List;
import java.util.Map;

import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.User;

public interface UserMapper {

	User getUserByName(String name);

	void insert(User user);

	void update(User user);

	void deleteById(String user_id);

	List<Department> getAllUserByPage(Map<String, Object> map);

	User getById(String user_id);

}
