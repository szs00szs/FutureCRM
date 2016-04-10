package com.future.hist.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.DepartmentMapper;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public void insertDepartment(Department department) {
		departmentMapper.insert(department);

	}

	public void updateDepartment(Department department) {
		departmentMapper.update(department);
	}

	public void deleteDepartmentById(Long department_id) {
		departmentMapper.delete(department_id);

	}
	
	public List<Department> getAllDepartment(Map<String, Object> map) {
	return	departmentMapper.getAllDepartmentByPage(map);

	}

	public Department getDepartmentById(Long department_id) {
		return departmentMapper.getById(department_id);

	}

	public List<Department> getAllDepartment() {
		return departmentMapper.getAllDepartment();
	}
}
