package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Department;

public interface DepartmentService {
	
	
	public void insertDepartment(Department department);

	public void updateDepartment(Department department);

	public void deleteDepartmentById(Long department_id);
	
	public List<Department> getAllDepartmentByPage(BaseSearch baseSearch);
	
	public Department getDepartmentById(Long department_id);

	public int getTotalCount();

	public List<Department> getAllDepartment();

	public List<Department> getDepartmentByNameLike(String name);
}
