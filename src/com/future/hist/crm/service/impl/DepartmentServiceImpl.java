package com.future.hist.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.DepartmentMapper;
import com.future.hist.crm.domain.Department;

@Service
@Transactional
public class DepartmentServiceImpl {
	
	private DepartmentMapper departmentMapper;
	
	public void insertDepartment(Department department) {
		departmentMapper.insert(department);

	}

	public void updateDepartment(Department department) {
		departmentMapper.update(department);
	}

	public void deleteDepartmentById(String department_id) {
		departmentMapper.delete(department_id);

	}
	
	public List<Department> getAllDepartment(Map<String, Object> map) {
	return	departmentMapper.getAllInstituteByPage(map);

	}

	public Department getDepartmentById(String department_id) {
		return departmentMapper.getById(department_id);

	}
}
