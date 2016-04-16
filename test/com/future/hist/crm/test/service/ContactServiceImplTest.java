package com.future.hist.crm.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.service.ContactService;

/**
 * @author 羊羊
 * @date 2016年4月8日
 */
public class ContactServiceImplTest {

	ApplicationContext applicationContext;
	ContactService contactService;
	
	@Before
	public void before(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:springbeans.xml");
		contactService = applicationContext.getBean(ContactService.class);
	}
	
	@Test
	public void testAddContact() {
		Contacts contact = new Contacts();
		
		contact.setContactAddress("联系地址1");
		contact.setDepartmentDuties("公司职务2");
		contact.setEmail("emails1");
		contact.setHobby("hobby1");
		contact.setHomePhone("12345");
		contact.setMobilePhone("12345678");
		contact.setName("联系人3");
		contact.setOfficeTelephone("1234568");
		contact.setPostCode("123456");
		contact.setQQNumber("987654");
		contact.setRemark("qwertyu");
		contact.setSex("男");
		contact.setBirthday(new Date());
		contact.setTaboo("1234567ygfdcvbhytrfb");
		
		contactService.addContact(contact);
	}

	@Test
	public void testDeleteContactById() {
		contactService.deleteContactById(3l);
	}

	@Test
	public void testDeleteContactByName() {
		contactService.deleteContactByName("联系人2");
	}

	@Test
	public void testUpdateContact() {
		Contacts contact = contactService.getContactById(1l);
		contact.setDepartmentDuties("公司职务");
		contactService.updateContact(contact);
	}

	@Test
	public void testGetAllContacts(){
		List<Contacts> list = contactService.getAllContacts();
		for(Contacts contact : list){
			System.out.println(contact);
		}
	}
	
	@Test
	public void testGetALlContactsByNameasc(){
		List<Contacts> list = contactService.getAllContactsByNameasc();
		for(Contacts contact : list){
			System.out.println(contact);
		}
	}
	
	@Test
	public void testGetContactById() {
		System.out.println(contactService.getContactById(1l));
	}

	@Test
	public void testGetContactByName() {
		System.out.println(contactService.getContactByName("联系人2"));
	}

	@Test
	public void testGetContactByDepartmentDuties() {
		List<Contacts> list = contactService.getContactByDepartmentDuties("公司植物2");
		for(Contacts contact : list){
			System.out.println(contact);
			
		}
	}

	@Test
	public void testGetContactByQQ() {
		System.out.println(contactService.getContactByQQ("QQ2"));
	}

}
