package com.future.hist.crm.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sysRole")
public class RoleController {

	@RequestMapping(value = "role_saveUI")
	public String saveUI(Map<String, Object> map){
		map.put("currentPage", 1);
		return "role/saveUI";
	}
}
