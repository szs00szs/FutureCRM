package com.future.hist.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return "redirect:/department_list";
	}
	
	@RequestMapping("department_list")
	public String list(){
		departmentService.getAllDepartment();
		return "department/department_list";
	}
	
}
