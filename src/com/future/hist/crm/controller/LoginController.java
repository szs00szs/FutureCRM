package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.security.SystemAuthorizingRealm.Principal;
import com.future.hist.crm.util.UserUtils;

@Controller
public class LoginController extends BaseController {
	
	@RequestMapping("login")
	public String login(HttpServletRequest request){
		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		
		System.out.println("the user'name is : " + name);
		System.out.println("the user'password is : " + password);
		
		return "workSpace";
	}
	
	@RequestMapping(value = "/sysLogin", method = RequestMethod.GET)
	public String login(ModelMap map) {
		Principal principal = UserUtils.getPrincipal();
		if (principal != null) {
			System.out.println(UserUtils.getUser());
			return "redirect:" + "index";
		} else {
			return "sysLogin";
		}
	}

	@RequestMapping(value = "/footing")
	public String footing() {
		return "footing";
	}
	
	@RequestMapping(value = "/heading")
	public String heading() {
		return "heading";
	}
	
	@RequestMapping(value = "/content_menu")
	public String content_menu() {
		return "content_menu";
	}
	
	@RequestMapping(value = "/loginOut")
	public String loginOut() {
		UserUtils.clearCache();
		UserUtils.getSubject().logout();
		return "redirect:" + "sysLogin";
	}

	
	@RequestMapping(value = "/sysLogin", method = RequestMethod.POST)
	public String slogin(ModelMap map) {
		return "sysLogin";
	}
	
	@RequestMapping(value = "/index")
	public String index(HttpSession httpSession) {
		List<Privilege> list = UserUtils.getPrivilegeList();
		List<Privilege> parentPrivilege = new ArrayList<Privilege>();
		List<Privilege> sonPrivilege = new ArrayList<Privilege>();
		for (Privilege privilege : list) {
//			if (privilege.getParent()) {
//				System.out.println("father" + privilege.getName());
//				parentPrivilege.add(privilege);
//			} else {
//				System.out.println("son" + privilege.getName());
//				sonPrivilege.add(privilege);
//			}
		}
		User user = UserUtils.getUser();
		httpSession.setAttribute("parentPrivilege", parentPrivilege);
		httpSession.setAttribute("sonPrivilege", sonPrivilege);
		httpSession.setAttribute("user", user);
		return "index";
	}

}
