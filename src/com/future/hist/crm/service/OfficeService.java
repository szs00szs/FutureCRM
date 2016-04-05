package com.future.hist.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.DepartmentMapper;
import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.util.SpringContextHolder;
@Service
@Transactional(readOnly = true)
public class OfficeService implements InitializingBean {

	private static UserMapper userMapper = SpringContextHolder.getBean(UserMapper.class);

	private static DepartmentMapper departmentMapper = SpringContextHolder.getBean(DepartmentMapper.class);
	
	/**
	 * **********************************部门***********************************
	 */
    
	public static void insertDepartment(Department department) {
		departmentMapper.insert(department);

	}

	public static void updateDepartment(Department department) {
		departmentMapper.update(department);
	}

	public static void deleteDepartmentById(String department_id) {
		departmentMapper.delete(department_id);

	}
	
	public static List<Department> getAllDepartment(Map<String, Object> map) {
	return	departmentMapper.getAllInstituteByPage(map);

	}
	
	


	public static Department getDepartmentById(String department_id) {
		return departmentMapper.getById(department_id);

	}
	/**
	 * **********************************部门 end***********************************
	 * ***********************
	 */
	
	/**
	 * **********************************用户***********************************
	 */
    
	public static void insertUser(User user) {
		userMapper.insert(user);

	}

	public static void updateUser(User user) {
		userMapper.update(user);
	}

	public static void deleteUserById(String user_id) {
		userMapper.deleteById(user_id);

	}
	
	public static List<Department> getAllUser(Map<String, Object> map) {
	return	userMapper.getAllUserByPage(map);

	}
	
	


	public static User getUserById(String user_id) {
		return userMapper.getById(user_id);

	}
	/**
	 * **********************************用户end***********************************
	 * ***********************
	 */

	public void afterPropertiesSet() throws Exception {
		
	}

	



}
