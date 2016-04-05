package com.future.hist.crm.test.mybatis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.hist.crm.dao.UserMapper;
import com.future.hist.crm.domain.User;

public class MybatisConnectionTest {
	
	@Test
	public void testConnectionSql(){
		ApplicationContext application = new ClassPathXmlApplicationContext("classpath:springbeans.xml");
		//System.out.println("afterApplication__::" + application.getApplicationName() + "----" );
		
		UserMapper userMapper = application.getBean(UserMapper.class);
		 User user  = userMapper.selectById(1);
			
		
		
		//System.out.println("afterUserMapper !userMapper is : " + userMapper.getClass() + "UserMapper'user" + userMapper.getUserById(1));
		//User user1 = userMapper.getUserById(1);
		System.out.println("the result is : " + user);
		System.out.println(user.toString());
	}
	
}
