package com.future.hist.crm.service;

import java.util.List;
import java.util.Map;

import com.future.hist.crm.domain.Department;

public interface DepartmentService {
	
	
	public void insertDepartment(Department department);

	public void updateDepartment(Department department);

	public void deleteDepartmentById(String department_id);
	
	public List<Department> getAllDepartment(Map<String, Object> map);
	
	public Department getDepartmentById(String department_id);
}
