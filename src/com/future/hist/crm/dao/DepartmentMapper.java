package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Department;

public interface DepartmentMapper {

	void insert(Department department);

	void update(Department department);

	void delete(Long department_id);

	List<Department> getAllDepartmentByPage(BaseSearch baseSearch);

	Department getById(Long department_id);

	int getTotalCount();

}
