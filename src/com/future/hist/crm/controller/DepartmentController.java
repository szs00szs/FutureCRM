package com.future.hist.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Department;
import com.future.hist.crm.service.DepartmentService;

@Controller
@RequestMapping("/sysDepartment")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/department_saveUI")
	public String saveUI(){
		
		return "department/saveUI";
	}
	@RequestMapping(value = "/department_save")
	public String save(Department department){
		System.out.println(department);
		departmentService.insertDepartment(department);
		return "redirect:/sysDepartment/department_list";
	}
	
	@RequestMapping("department_list")
	public String list(Map<String, Object> map){
		List<Department> departmentList = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		System.out.println("departmentList : " + departmentList);
		return "department/department_list";
	}
	
	@RequestMapping(value = "/department_updateUI/{department_id}")
	public String updateUI(@PathVariable(value = "department_id") Long department_id,Map<String, Object> map){
		Department department = departmentService.getDepartmentById(department_id);
		map.put("department", department);
		return "department/saveUI";
	}
	
	@RequestMapping(value = "/department_update")
	public String update(Department department){
		System.out.println("department : " + department);
		departmentService.updateDepartment(department);
		return "redirect:/sysDepartment/department_list";
	}
	
	@RequestMapping(value = "/department_delete/{department_id}")
	public String delete(@PathVariable(value = "department_id") Long department_id){
		departmentService.deleteDepartmentById(department_id);
		return "redirect:/sysDepartment/department_list";
	}
}
