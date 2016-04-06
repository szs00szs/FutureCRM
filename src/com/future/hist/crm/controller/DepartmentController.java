package com.future.hist.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Department;

@Controller("department")
public class DepartmentController {

	@RequestMapping("saveUI")
	public String saveUI(){
		
		return "saveUI";
	}
	@RequestMapping("save")
	public String save(Department department){
		
		return "save";
	}
	
}
