package com.future.hist.crm.dao;

import java.util.List;
import java.util.Map;

import com.future.hist.crm.domain.User;

public interface UserMapper {
    int count();
    
    int deleteByUser(User user);

    int deleteById(long id);

    int addUser(User user);

    int addSelective(User user);

    List<User> selectByUser(User user);

    User selectById(long id);

	User getUserByName(String name);

	void insert(User user);

	void update(User user);

	void deleteById(String user_id);

	List<User> getAllUserByPage (Map<String, Object> map);

	User getById(String user_id);

}
