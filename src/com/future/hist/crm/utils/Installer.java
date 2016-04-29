package com.future.hist.crm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.future.hist.crm.dao.PrivilegeMapper;
import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.Privilege;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.impl.PasswordHelper;

@Component
public class Installer {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordHelper passwordHelper;
	
	@Autowired
	private PrivilegeMapper privilegeMapper;
	
	
	@Transactional
	public void install(){ 
		//保存超级管理员用户
		User user = new User();
		user.setLoginName("admin");
		user.setName("超级管理员");
		user.setPassword("admin");
		passwordHelper.encryptPassword(user);
		userMapper.insert(user);
		
		//保存权限数据
		Privilege menu,menu1,menu2,menu3,menu4,menu5;
		menu = new Privilege("系统管理", null, null);
		menu1 = new Privilege("岗位管理", "/role:view", menu);
		menu2 = new Privilege("部门管理", "/department:view", menu);
		menu3 = new Privilege("用户管理", "/user:view", menu);
		
		privilegeMapper.save(menu);
		privilegeMapper.save(menu1);
		privilegeMapper.save(menu2);
		privilegeMapper.save(menu3);
		
		//岗位管理下的权限
		privilegeMapper.save(new Privilege("岗位列表", "/role:view", menu1));
		privilegeMapper.save(new Privilege("岗位删除", "/role:delete", menu1));
		privilegeMapper.save(new Privilege("岗位添加", "/role:save", menu1));
		privilegeMapper.save(new Privilege("岗位修改", "/role:update", menu1));
		
		//部门管理下的权限
		privilegeMapper.save(new Privilege("部门列表", "/department:view", menu1));
		privilegeMapper.save(new Privilege("部门删除", "/department:delete", menu1));
		privilegeMapper.save(new Privilege("部门添加", "/department:save", menu1));
		privilegeMapper.save(new Privilege("部门修改", "/department:update", menu1));
		
		//用户管理下的权限
		privilegeMapper.save(new Privilege("用户列表", "/user:view", menu1));
		privilegeMapper.save(new Privilege("用户删除", "/user:delete", menu1));
		privilegeMapper.save(new Privilege("用户添加", "/user:save", menu1));
		privilegeMapper.save(new Privilege("用户修改", "/user:update", menu1));
		
//		//部门管理下的权限
//		session.save(new Privilege("部门列表", "/department_list", menu2));
//		session.save(new Privilege("部门删除", "/department_delete", menu2));
//		session.save(new Privilege("部门添加", "/department_add", menu2));
//		session.save(new Privilege("部门修改", "/department_edit", menu2));
//		
//		//用户管理下的权限
//		session.save(new Privilege("用户列表", "/user_list", menu3));
//		session.save(new Privilege("用户删除", "/user_delete", menu3));
//		session.save(new Privilege("用户添加", "/user_add", menu3));
//		session.save(new Privilege("用户修改", "/user_edit", menu3));
//		session.save(new Privilege("初始化密码", "/user_initPassword", menu3));
//		
//		
//		//网上交流
//		menu = new Privilege("网上交流", null, null);
//		menu1 = new Privilege("论坛管理", "/forumManage_list", menu);
//		menu2 = new Privilege("论坛", "/forum_list", menu);
//		session.save(menu);
//		session.save(menu1);
//		session.save(menu2);
//		
//		//审批流转
//		menu = new Privilege("审批流转", null, null);
//		menu1 = new Privilege("审批流程管理", "/processDefinition_list", menu);
//		menu2 = new Privilege("表单模板管理", "/template_list", menu);
//		menu3 = new Privilege("起草申请", "/flow_templateList", menu);
//		menu4 = new Privilege("待我审批", "/flow_myTaskList", menu);
//		menu5 = new Privilege("我的申请查询", "/flow_myApplicationList", menu);
//		session.save(menu);
//		session.save(menu1);
//		session.save(menu2);
//		session.save(menu3);
//		session.save(menu4);
//		session.save(menu5);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springbeans.xml");
		Installer installer = (Installer) ctx.getBean("installer");
		installer.install();
	}
	
}
