package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.PageParameter;
import com.future.hist.crm.service.DepartmentService;

@Controller
@RequestMapping("/sysDepartment")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/department_saveUI")
	public String saveUI(Map<String, Object> map){
		map.put("currentPage", 1);
		return "department/saveUI";
	}
	@RequestMapping(value = "/department_save")
	public String save(Department department){
		System.out.println(department);
		departmentService.insertDepartment(department);
		int totalCount = departmentService.getTotalCount();
		PageParameter pageParameter = new PageParameter();
		int totalPage = (totalCount + pageParameter.getPageSize() - 1) / pageParameter.getPageSize();
		return "redirect:/sysDepartment/department_list/" + totalPage;
	}
	
	@RequestMapping("department_list/{currentPage}")
	public String list(@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map){
		BaseSearch baseSearch = new BaseSearch();
		int totalCount = departmentService.getTotalCount();
		PageParameter pageParameter = new PageParameter(PageParameter.DEFAULT_PAGE_SIZE, currentPage, totalCount);
		System.out.println("pageParameter : " + pageParameter);
		baseSearch.setPage(pageParameter);
		List<Department> departmentList = departmentService.getAllDepartmentByPage(baseSearch);
		map.put("departmentList", departmentList);
		map.put("pageParameter", pageParameter);
		System.out.println("departmentList : " + departmentList);
		return "department/department_list";
	}
	
	@RequestMapping(value = "/department_updateUI/{department_id}/{currentPage}")
	public String updateUI(@PathVariable(value = "department_id") Long department_id,@PathVariable(value = "currentPage") Integer currentPage,Map<String, Object> map){
		Department department = departmentService.getDepartmentById(department_id);
		map.put("department", department);
		map.put("currentPage", currentPage);
		return "department/saveUI";
	}
	
	@RequestMapping(value = "/department_update/{currentPage}")
	public String update(@PathVariable(value = "currentPage") Integer currentPage,Department department){
		System.out.println("department : " + department);
		departmentService.updateDepartment(department);
		return "redirect:/sysDepartment/department_list/" + currentPage;
	}
	
	@RequestMapping(value = "/department_delete/{department_id}")
	public String delete(@PathVariable(value = "department_id") Long department_id){
		departmentService.deleteDepartmentById(department_id);
		return "redirect:/sysDepartment/department_list/1";
	}
	
}
