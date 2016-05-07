package com.future.hist.crm.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.News;
import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.exception.CustomException;
import com.future.hist.crm.service.NewsService;
import com.future.hist.crm.service.PrivilegeService;
import com.future.hist.crm.service.UserService;
import com.future.hist.crm.utils.UserUtils;
import com.future.hist.crm.web.bind.annotation.CurrentUser;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PrivilegeService privilegeService;

	@RequestMapping("login")
	public String login(HttpServletRequest request, HttpServletResponse response, User user, Model model) {
		String name = (String) request.getParameter("name");
		String password = (String) request.getParameter("password");

		System.out.println("the user'name is : " + name);
		System.out.println("the user'password is : " + password);

		List<News> newsList = newsService.getAllNews();
		model.addAttribute(newsList);

		return "workSpace";
	}

//	@RequestMapping(value = "/sysLogin", method = RequestMethod.GET)
//	public String login(ModelMap map) {
//		Principal principal = UserUtils.getPrincipal();
//		if (principal != null) {
//			System.out.println(UserUtils.getUser());
//			return "redirect:" + "index";
//		} else {
//			return "sysLogin";
//		}
//	}

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

	@RequestMapping(value = "/sysLogin")
	public String slogin( Model model, HttpServletRequest request) throws Exception {
		// 如果用户登录失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String)request.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        //登陆成功后shiro会自动跳转到上一个请求页面
		// 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		// 登陆失败还到login页面
		return "sysLogin";
	}

	@RequestMapping(value = "/sysIndex")
	public String index(@CurrentUser User loginUser, Model model,HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		String loginName = (String) subject.getPrincipal();
		System.out.println("loginName : " + loginName);
//		System.out.println("loginUser.getLoginName() : " + loginUser.getLoginName());
        Set<String> permissions = userService.findPermissions(loginName);
        List<Privilege> menus = privilegeService.findMenus(permissions);
        System.out.println("permissions : " + permissions + ", menus : " + menus);
        model.addAttribute("menus", menus);
        session.setAttribute("menus", menus);
        return "index";
    }

}
