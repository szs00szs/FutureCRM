package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.Department;

public interface DepartmentMapper {

	void insert(Department department);

	void update(Department department);

	void delete(Long department_id);

	List<Department> getAllDepartmentByPage();

	Department getById(Long department_id);

	/*public List<Department> getAllDp();
	
	public void deleteDepartment(Integer departmentId);
	
	public void updateDepartment(Department department);
	
	public Department findById(Integer departmentId);
	
	public Department findByName(String departmentName);
	
	public void addDepartment(Department department);*/
	
	//以上是以前写的，能用就用，不能用就直接删
}
